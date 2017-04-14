package cardUtilities;

/**
 * 
 * Holds information about the rank and suit of a card
 * 
 * @author Jacob Cunagin
 *
 */
class Card {
	//valid ranks for cards in a deck
	private static final char[] RANKS = {'2','3','4','5','6','7','8',
			'9','T','J','Q','K','A'};
	
	//valid suits for cards in a deck
	private static final char[] SUITS = {'S', 'C', 'H', 'D'};
	
	//values held by every card
	private char rank;
	private char suit;
	
	/**
	 * 
	 * @param givenRank
	 * @param givenSuit
	 * @throws InvalidRankException
	 * @throws InvalidSuitException
	 */
	public Card(char givenRank, char givenSuit){
	
		try {
			if(Card.isValidRank(givenRank)){
				rank = givenRank;
			}else{
				throw new InvalidRankException(givenRank);
			}
			
			if(Card.isValidSuit(givenSuit)){
				suit = givenSuit;
			}else{
				throw new InvalidSuitException(givenSuit);
			}
		}catch(InvalidRankException e){
			System.out.println(givenRank + " is not a valid Rank");
		}catch(InvalidSuitException e){
			System.out.println(givenSuit + "is not a valid Suit");
		}
		
	}
	
	/**
	 * Determines if the given char is a valid suit in a deck of cards 
	 * @param suit
	 * @return true if the provided char is in the set of valid suits, false if otherwise
	 */
	public static boolean isValidSuit(char suit){
		boolean valid = false;
		for(int i = 0; i<SUITS.length; i++){
			if(suit == SUITS[i]){
				valid = true;
				break;
			}
		}
		return valid;
	}
	
	/**
	 * Determines if the given char is a valid rank in a deck of cards
	 * @param rank
	 * @return true if the provided char is the the set of valid ranks, false if otherwise
	 */
	public static boolean isValidRank(char rank){
		boolean valid = false;
		for(int i = 0; i<RANKS.length; i++){
			if(rank == RANKS[i]){
				valid = true;
				break;
			}
		}
		return valid;
	}
	
	/**
	 * compares the ranks between two cards
	 * 
	 * @param comparison
	 * @return the rank of comparison - the rank of this
	 */
	public int compareRank(Card comparison){
		int rankInt = 0;
		int comparisonInt = 0;
		for(int i=0; i<RANKS.length; i++){
			if(this.rank == RANKS[i]){
				rankInt = i;
			}
		}
		for(int i=0; i<RANKS.length; i++){
			if(comparison.rank == RANKS[i]){
				comparisonInt = i;
			}
		}
		return comparisonInt-rankInt;
	}
	
	/**
	 * compares the suits of two cards
	 * @param comparison
	 * @return true if the suits are the same, false if otherwise
	 */
	public boolean compareSuit(Card comparison){
		boolean suitSimilarity = this.suit == comparison.suit;
		return suitSimilarity;
	}
	
	/**
	 * Converts the card to a string
	 * @return a char representation of the card
	 */
	public String toString(){
		String result = String.valueOf(this.rank) 
				+ String.valueOf(this.suit);
		return result;
	}
	
	/**
	 * Checks two cards for identical suits and ranks
	 * @param comparison
	 * @return false unless cards have equal suit and rank
	 */
	public boolean equals(Card comparison){
		boolean equality = false;
		if(this.rank == comparison.rank && this.suit == comparison.suit){
			equality=true;
		}
		return equality;
	}
	
	/**
	 * Returns the rank of the card as a char
	 * @return The card rank
	 */
	public char getRank(){
		return this.rank;
	}
	
	/**
	 * Returns the suit of the card as a char
	 * @return The card suit
	 */
	public char getSuit(){
		return this.suit;
	}

}
