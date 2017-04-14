package cardUtilities;

/**
 * 
 * exception used when invalid card rank is passed to card constructor
 * @author Jacob
 *
 */
public class InvalidRankException extends Exception{
	
	private char rank;
	
	public InvalidRankException(char badRank){
		rank = badRank;
	}
	
	public char getBadRank(){
		return rank; 
	}
}
