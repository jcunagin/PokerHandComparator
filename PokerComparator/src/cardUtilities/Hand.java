package cardUtilities;
import java.util.*;

/**
 * Represents and processes information about a hand of cards.
 * Cards are sorted in numerical order from lowest rank to highest
 * @author Jacob
 *
 */
public class Hand {

	//array holds all cards in hand
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand(){
		//acounts for proper initialization with 0 args passed
	}
	
	public Hand(Card... args){	
		for(Card arg: args){
			cards.add(arg);
		}
		this.sort();
	}
	
	/**
	 * sorts the given hand by suit
	 */
	private void sort(){ //Hands of cards tend to be small, insertion sort should not impact performance
		if(!this.isEmpty()){
			ArrayList<Card> sortedCards = new ArrayList<Card>();
			Iterator<Card> items = this.cards.iterator();
			sortedCards.add(items.next());
			while(items.hasNext()){
				Card current = items.next();
				Iterator<Card> sortedItems = sortedCards.iterator();
				int index = 0;
				while(sortedItems.hasNext()){ //finds index of first card higher than current
					Card comparison = sortedItems.next();
					if(current.compareRank(comparison)>0){
						break;
					}else if(current.compareRank(comparison) == 0){
						if(current.getRank() > comparison.getRank()){
							break;
						}
					}
					index++;
				}
				sortedCards.add(index, current); //adds current at index below next highest card
			}
			this.cards = sortedCards;
		}
	}
	
	/**
	 * @return True if there are no card objects in the hand object
	 */
	public boolean isEmpty(){
		boolean empty = true;
		if(!this.cards.isEmpty()){
			empty = false;
		}
		return empty;
	}
	
	/**
	 * @return Card object with the highest rank among Card objects in this, null if hand contains no cards
	 */
	public Card getHighCard(){
		Card highCard = null;
		if(!this.isEmpty()){
			this.sort();
			highCard = this.cards.get(this.cards.size()-1);
		}
		return highCard;
	}
	
	/**
	 * @return Card object with the lowest rank among Card objects in this
	 */
	public Card getLowCard(){
		Card lowCard = null;
		if(!this.isEmpty()){
			this.sort();
			lowCard = this.cards.get(0);
		}
		return lowCard;
	}
	
	/**
	 * @return Map<Character,Integer>, with the Character representing the rank, Integer occurrences of that rank
	 */
	public Map<Character,Integer> countRankMatches(){
		Map<Character,Integer> matches = new HashMap<Character,Integer>();
		if(!this.isEmpty()){
			Iterator<Card> items = this.cards.iterator();
			while(items.hasNext()){
				Card current = items.next();
				if(matches.containsKey(current.getRank())){  //increments instances of current rank
					matches.put(current.getRank(), matches.get(current.getRank())+1);
				}else{  //adds current rank to map
					matches.put(current.getRank(), 1);
				}
			}
		}	
		return matches;
	}
	
	/**
	 * @param c
	 * @return a Hand containing all Cards with a matching rank
	 */
	public Hand getRankMatches(Card c){
		Hand matches = new Hand();
		Iterator<Card> items = this.cards.iterator();
		while(items.hasNext()){
			Card current = items.next();
			if(current.compareRank(c) == 0){
				matches.add(current);
			}
		}
		return matches;
	}
	
	/**
	 * @param c
	 */
	public void add(Card c){
		if(!this.isEmpty()){
			Iterator<Card> items = this.cards.iterator();
			int index = 0;
			while(items.hasNext()){ //finds index of first card higher than current
				Card comparison = items.next();
				if(c.compareRank(comparison)>0){
					break;
				}else if(c.compareRank(comparison) == 0){
					if(c.getRank() > comparison.getRank()){
						break;
					}
				}
				index++;
			}
			this.cards.add(index, c);
		}else{
			this.cards.add(c);
		}
	}
	
	
	/**
	 * @param c
	 * @return true if hand contains a card with a matching suit and rank
	 */
	public boolean contains(Card c){
		boolean result = false;
		Iterator<Card> items = this.cards.iterator();
		while(items.hasNext()){
			Card compare = items.next();
			if(compare.getRank() == c.getRank() && compare.getSuit() == c.getSuit()){
				result = true; //identical card found
				break;
			}
		}
		return result;
	}
	
	/**
	 * @param comparison
	 * @return true if both hands have the same cards
	 */
	public boolean equals(Hand comparison){
		boolean equality = true;
		if(this.cards.size() == comparison.cards.size() && !this.isEmpty() && !comparison.isEmpty()){ //If hands have different sizes ther is no need to check
			Iterator<Card> items = this.cards.iterator();
			Iterator<Card> compareItems = this.cards.iterator();
			while(items.hasNext() && compareItems.hasNext()){
				if(!items.next().equals(compareItems.next())){
					equality = false;
					break;
				}
			}
		}else if(!(this.isEmpty() && comparison.isEmpty())){ //only runs code if both are not null
			equality = false;
		}
		return equality;
	}
	
	/**
	 * Returns the Cards in hand separated by spaces
	 */
	public String toString() {
		String hand = "";
		Iterator<Card> items = this.cards.iterator();
		while(items.hasNext()){
			hand += items.next().toString();
			if(items.hasNext()){
				hand += " ";
			}
		}
		return hand;
	}
	
	/**
	 * Generates a Map where the keys correspond to suits and values how many times that suit is represented
	 * @return Map<Character, Integer> corresponding to suits and their frequency
	 */
	public Map<Character,Integer> countSuitMatches(){
		Map<Character,Integer> matches = new HashMap<Character,Integer>();
		if(!this.isEmpty()){
			Iterator<Card> items = this.cards.iterator();
			while(items.hasNext()){
				Card current = items.next();
				if(matches.containsKey(current.getSuit())){  //increments instances of current rank
					matches.put(current.getSuit(), matches.get(current.getSuit())+1);
				}else{  //adds current rank to map
					matches.put(current.getSuit(), 1);
				}
			}
		}	
		return matches;
	}
	
    /**
     * @param c the card to be compared to
     * @return A hand containing all cards of the given hand that match the suit of c
     */
	public Hand getSuitMatches(Card c) {
    	Hand matches = new Hand();
		Iterator<Card> items = this.cards.iterator();
		while(items.hasNext()){
			Card current = items.next();
			if(current.compareSuit(c)){
				matches.add(current);
			}
		}
		return matches;
    }
	
	/**
	 * 
	 * @return The number of cards in this
	 */
	public int size() {
		return this.cards.size();
	}
	
	/**
	 * 
	 * @return Generates and array containing all cards in the hand
	 */
	public Card[] getCards(){
		Card[] output = new Card[this.cards.size()];
		return this.cards.toArray(output);
	}
}
