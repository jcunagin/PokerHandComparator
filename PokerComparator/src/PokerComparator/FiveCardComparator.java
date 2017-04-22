package PokerComparator;
import cardUtilities.*;
import java.io.*;
import java.util.*;

public class FiveCardComparator {
	
	/**
	 * Searches the given string for all character pairs that are a valid card and returns a hand containing those cards
	 * 
	 * @param input
	 * @return A hand of cards composed from characters in input
	 */
	static Hand getHand(String input){ //package accessibility for testing
		Hand output = new Hand();
		
		for(int i = 0; i<input.length()-1; i++){ //will look at every char pair in the string
			if(Card.isValidRank(input.charAt(i)) && Card.isValidSuit(input.charAt(i+1))){ //valid card found in string
				try{
					if(output.contains(new Card(input.charAt(i), input.charAt(i+1)))){
						throw new IllegalArgumentException();
					}
				}catch(IllegalArgumentException e){
					System.err.print("Hands should not contain duplicate cards");
				}
				output.add(new Card(input.charAt(i), input.charAt(i+1))); //card added to hand
			}
		}
		
		return output;
	}
	
	/**
	 * 
	 * @param input
	 * @return An integer representing the quality of the hand. Poker hands are ranked 0-8 in the order High Card, Pair, Two Pair, Three of a Kind, Straight, Flush, Full HOuse, Four of a Kind, Straight Flush
	 */
	static int getWinningHandQuality(Hand input) { //package accessibility for testing
		int handQuality = 0;
		
		Map<Character, Integer> rankCount = input.countRankMatches();
		Map<Character, Integer> suitCount = input.countSuitMatches();
		
		switch(rankCount.size()){
			case 5: if(input.getLowCard().compareRank(input.getHighCard()) == 4){ //highest card is 4 ranks higher than the lowest with no duplicates
																					//only possibility is 5 cards in order
						handQuality = 4; //hand is straight, flush or straight flush
					}
					break;
			case 4: handQuality = 1; //hand is pair, or flush
					break;
			case 3: if(rankCount.containsValue(new Integer(3))){
						handQuality = 3; // hand is three of a kind, or flush
					}else{
						handQuality = 2; //hand is two pair or flush
					}
					break;
			case 2: if(rankCount.containsValue(4)){
						handQuality = 7; //hand is four of a kind
					}else {
						handQuality = 6; //hand is full house
					}
					break;
		}
		
		boolean flush = false;
		if(suitCount.size() == 1){
			flush = true;
		}
		if(flush && handQuality<=3){
			handQuality = 5; //hand is flush
		}else if(flush && handQuality == 4){
			handQuality = 8; // hand is straight flush
		}
		
		return handQuality;
	}
	
	/**
	 * Prints the details of the winning hand to System.out
	 * @param winningHand
	 * @param handQuality
	 */
	static void printWinningHand(Hand winningHand, int handQuality){
		Card[] cards = winningHand.getCards();
		Map<Character, Integer> rankMap = winningHand.countRankMatches();
		switch(handQuality){
		case 0: System.out.print("high card: " + winningHand.getHighCard().toString());
				break;
		case 1: Card card1 = null;
				Card card2 = null;
				for(int i = 0; i<cards.length-1; i++){
					for(int j = i+1; j<cards.length; j++){
						if(cards[i].compareRank(cards[j]) == 0){
							card1 = cards[i];
							card2 = cards[j];
							break;
						}
					}
				}
				
				System.out.print("a pair: " + card1.toString() + " and " + card2.toString());
				break;
		case 2: Hand pairs = new Hand();
				for(int i = 0; i<cards.length; i++){
					if(rankMap.get(cards[i].getRank()) == 2){
						pairs.add(cards[i]);
					}
				}
				System.out.print("two pair: " + pairs.toString());
				break;
		case 3:Hand set = new Hand();
				for(int i = 0; i<cards.length; i++){
					if(rankMap.get(cards[i].getRank()) == 3){
						set.add(cards[i]);
					}
				}
				System.out.print("three of a kind: " + set.toString());
				break;
		case 4: System.out.print("straight: " + winningHand.toString());
				break;
		case 5: System.out.print("flush: " + winningHand.toString());
				break;
		case 6: Hand pair = new Hand();
				for(int i = 0; i<cards.length; i++){
						if(rankMap.get(cards[i].getRank()) == 2){
							pair.add(cards[i]);
						}
				}
				Hand triplet = new Hand();
				for(int i = 0; i<cards.length; i++){
					if(rankMap.get(cards[i].getRank()) == 3){
						triplet.add(cards[i]);
					}
				}
				System.out.print("full house: " + triplet.toString() + " and "+ pair.toString());
				break;
		case 7: Hand quadruplet = new Hand();
				for(int i = 0; i<cards.length; i++){
					if(rankMap.get(cards[i].getRank()) == 4){
						quadruplet.add(cards[i]);
					}
				}
				System.out.print("four of a kind: " + quadruplet.toString());
				break;
		case 8: System.out.print("straight flush: " + winningHand.toString());
				break;
		}
	}
	
	/**
	 * Determines which hand is the winning hand when both have the same winning hand quality and prints the details to System.out
	 * @param white
	 * @param black
	 */
	static void tiebreaker(Hand white, Hand black, int handQuality){
		Card[] whiteCards = white.getCards();
		Card[] blackCards = black.getCards();
		Map<Character, Integer> whiteRankMap = white.countRankMatches();
		Map<Character, Integer> blackRankMap = black.countRankMatches();
		boolean draw = true;
		switch(handQuality){
		case 0: //compares cards from highest to lowest
				for(int i=white.size()-1; i >= 0; i--){
					if(whiteCards[i].compareRank(blackCards[i]) > 0){
						draw = false;
						System.out.print("Black wins with ");
						printWinningHand(black, handQuality);
						break;
					}else if(whiteCards[i].compareRank(blackCards[i]) < 0){
						draw = false;
						System.out.print("White wins with ");
						printWinningHand(white, handQuality);
						break;
					}
				}
				break;
		case 1: //finds cards that are in pair for comparisson
				Card whitePairCard = null;
				for(int i = 0; i<whiteCards.length; i++){
						if(whiteRankMap.get(whiteCards[i].getRank()) == 2){
							whitePairCard = whiteCards[i];
							break;
						}
				}
				Card blackPairCard = null;
				for(int i = 0; i<blackCards.length; i++){
						if(blackRankMap.get(blackCards[i].getRank()) == 2){
							blackPairCard = blackCards[i];
							break;
						}
				}
				
				if(whitePairCard.compareRank(blackPairCard) > 0){//black has higher rank in pair
					draw = false;
					System.out.print("Black wins with ");
					printWinningHand(black, handQuality);
				}else if(whitePairCard.compareRank(blackPairCard) < 0){ //white has higher rank pair
					draw = false;
					System.out.print("White wins with ");
					printWinningHand(white, handQuality);
				}else { //pairs are tied
					//compares cards from highest to lowest
					for(int i=white.size()-1; i >= 0; i--){
						if(whiteCards[i].compareRank(blackCards[i]) > 0){
							draw = false;
							System.out.print("Black wins with ");
							printWinningHand(black, handQuality);
							break;
						}else if(whiteCards[i].compareRank(blackCards[i]) < 0){
							draw = false;
							System.out.print("White wins with ");
							printWinningHand(white, handQuality);
							break;
						}
					}
				}
				break;
		case 2: //finds pairs for both hands
				Hand whiteTwoPair = new Hand();
				Card whiteSingleton = null;
				for(int i = 0; i<whiteCards.length; i++){
					if(whiteRankMap.get(whiteCards[i].getRank()) == 2){
						whiteTwoPair.add(whiteCards[i]);
					}else{
						whiteSingleton = whiteCards[i];
					}
				}
				Hand blackTwoPair = new Hand();
				Card blackSingleton = null;
				for(int i = 0; i<blackCards.length; i++){
					if(blackRankMap.get(blackCards[i].getRank()) == 2){
						blackTwoPair.add(blackCards[i]);
					}else{
						blackSingleton = blackCards[i];
					}
				}
				if(whiteTwoPair.getHighCard().compareRank(blackTwoPair.getHighCard()) > 0){ //black has the higher high pair
					draw = false;
					System.out.print("Black wins with ");
					printWinningHand(black, handQuality);
				}else if(whiteTwoPair.getHighCard().compareRank(blackTwoPair.getHighCard()) < 0){ //white has the higher high pair
					draw = false;
					System.out.print("White wins with ");
					printWinningHand(white, handQuality);
				}else{ //high pairs are equal
					if(whiteTwoPair.getLowCard().compareRank(blackTwoPair.getLowCard()) > 0){ //black has the higher low pair
						draw = false;
						System.out.print("Black wins with ");
						printWinningHand(black, handQuality);
					}else if(whiteTwoPair.getLowCard().compareRank(blackTwoPair.getLowCard()) < 0){ //white has the higher low pair
						draw = false;
						System.out.print("White wins with ");
						printWinningHand(white, handQuality);
					}else{//both pairs are equal
						if(whiteSingleton.compareRank(blackSingleton) > 0){ //black has the higher unpaired card
							draw = false;
							System.out.print("Black wins with ");
							printWinningHand(black, handQuality);
						}else if(whiteSingleton.compareRank(blackSingleton) < 0){ //white has the higher unpaired card
							draw = false;
							System.out.print("White wins with ");
							printWinningHand(white, handQuality);
						}
					}
				}
				break;
		case 3: //Finds one card in the three of a kind for each hand
				Card whiteTripletCard = null;
				for(int i = 0; i<whiteCards.length; i++){
					if(whiteRankMap.get(whiteCards[i].getRank()) == 3){
						whiteTripletCard = whiteCards[i];
						break;
					}
				}
				Card blackTripletCard = null;
				for(int i = 0; i<blackCards.length; i++){
					if(blackRankMap.get(blackCards[i].getRank()) == 3){
						blackTripletCard = blackCards[i];
						break;
					}
				}
			
				//compares the rank of each three of a kind
				if(whiteTripletCard.compareRank(blackTripletCard) > 0){ //black triplet is higher
					draw = false;
					System.out.print("Black wins with ");
					printWinningHand(black, handQuality);
				}else{ //white triplet is higher, cannot be equal
					draw = false;
					System.out.print("White wins with ");
					printWinningHand(white, handQuality);
				}
				break;
		case 4: //check straights for high cards
				if(white.getHighCard().compareRank(black.getHighCard()) > 0){ //black has the higher straight
					draw = false;
					System.out.print("Black wins with ");
					printWinningHand(black, handQuality);
				}else if(white.getHighCard().compareRank(black.getHighCard()) < 0){ //white has the higher straight
					draw = false;
					System.out.print("White wins with ");
					printWinningHand(white, handQuality);
				}
				break;
		case 5: //checks flush for high cards
				for(int i=white.size()-1; i >= 0; i--){
					if(whiteCards[i].compareRank(blackCards[i]) > 0){
						draw = false;
						System.out.print("Black wins with ");
						printWinningHand(black, handQuality);
						break;
					}else if(whiteCards[i].compareRank(blackCards[i]) < 0){
						draw = false;
						System.out.print("White wins with ");
						printWinningHand(white, handQuality);
						break;
					}
				}
				break;
		case 6: //gets triplet for each hand
				Card whiteHouseCard = null;
				for(int i = 0; i<whiteCards.length; i++){
					if(whiteRankMap.get(whiteCards[i].getRank()) == 3){
						whiteHouseCard = whiteCards[i];
						break;
					}
				}
				Card blackHouseCard = null;
				for(int i = 0; i<blackCards.length; i++){
						if(blackRankMap.get(blackCards[i].getRank()) == 3){
							blackHouseCard = blackCards[i];
							break;
						}
				}
				//compares three of a kind
				if(whiteHouseCard.compareRank(blackHouseCard) > 0){ //black triplet is higher
					draw = false;
					System.out.print("Black wins with ");
					printWinningHand(black, handQuality);
				}else{ //white triplet is higher, cannot be equal
					draw = false;
					System.out.print("White wins with ");
					printWinningHand(white, handQuality);
				}
				break;
		case 7: //gets the 4 of a kind for each hand
				Card whiteFourOf = null;
				for(int i = 0; i<whiteCards.length; i++){
					if(whiteRankMap.get(whiteCards[i].getRank()) == 4){
						whiteFourOf = whiteCards[i];
						break;
					}
				}
				Card blackFourOf = null;
				for(int i = 0; i<whiteCards.length; i++){
					if(blackRankMap.get(blackCards[i].getRank()) == 4){
						blackFourOf = blackCards[i];
						break;
					}
				}
				
				//determines winning hand
				if(whiteFourOf.compareRank(blackFourOf) >0){ //black four of a kind is greater
					draw = false;
					System.out.print("Black wins with ");
					printWinningHand(black, handQuality);
				}else{ //white four of a kind is higher, cannot be equal
					draw = false;
					System.out.print("White wins with ");
					printWinningHand(white, handQuality);
				}
				break;
		case 8: //compares highest card in each straight flush
				if(white.getHighCard().compareRank(black.getHighCard()) > 0){ //black has the higher straight
					draw = false;
					System.out.print("Black wins with ");
					printWinningHand(black, handQuality);
				}else if(white.getHighCard().compareRank(black.getHighCard()) < 0){ //white has the higher straight
					draw = false;
					System.out.print("White wins with ");
					printWinningHand(white, handQuality);
				}
				break;
				
		}
		//hands are equal
		if(draw){
			System.out.print("Draw");
		}
	}
	
	/**
	 * checks to make sure both hands are valid
	 * @param black
	 * @param white
	 */
	static void checkInput(Hand black, Hand white){
		try{
			if(black.size() != 5 || white.size() != 5){
				throw new IllegalArgumentException();
			}
		}catch(IllegalArgumentException e){
			System.err.print("Hands should be 5 cards each");
		}
		try{
			Card[] blackCards = black.getCards();
			for(int i = 0; i<black.size(); i++){
				if(white.contains(blackCards[i])){
					throw new IllegalArgumentException();
				}
			}
		}catch(IllegalArgumentException e){
			System.err.print("Hands should not contain the same cards");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("This program will compare two hands of five cards for the highest poker hand.");
		System.out.println("Cards with a rank 2-9 should be represented as their number rank.");
		System.out.println("Cards ranked 10, Jack, Queen, King Ace should be represented as T,J,Q,K,A respectively.");
		System.out.println("The suits should be represented as Spades=S Diamonds=D Hearts=H and Clubs=C.");
		System.out.println("Cards should be represented as 2C for two of clubs.");
		System.out.println("Please input hands in the form \"Black: Card1 Card2 Card3 Card4 Card5 White: Card1 Card2 Card3 Card4 Card5\".");
		
		//gets input as a string
		Scanner input = new Scanner(System.in);
		String Hands = input.nextLine();
		input.close();
		
		//splits input into one for each hand
		int white = Hands.indexOf("White:");
		String blackHandString = Hands.substring(0, white);
		String whiteHandString = Hands.substring(white);
		
		//converts strings into hands
		Hand blackHand = getHand(blackHandString); 
		Hand whiteHand = getHand(whiteHandString);
		checkInput(blackHand,whiteHand);
		
		//finds the best poker hand in each hand
		int blackHandQuality = getWinningHandQuality(blackHand);
		int whiteHandQuality = getWinningHandQuality(whiteHand);
		
		//prints winner
		if(blackHandQuality > whiteHandQuality){
			System.out.print("Black wins with ");
			printWinningHand(blackHand, blackHandQuality);
		}else if(whiteHandQuality > blackHandQuality){
			System.out.print("White wins with ");
			printWinningHand(whiteHand, whiteHandQuality);
		}else{
			tiebreaker(whiteHand, blackHand, whiteHandQuality);
		}
		System.out.println("");
	}

}
