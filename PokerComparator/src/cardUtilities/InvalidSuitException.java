package cardUtilities;

/**
 * 
 * exception used when invalid card suit is passed to card constructor
 * @author Jacob
 *
 */
public class InvalidSuitException extends Exception{
	
	private char suit;
	
	public InvalidSuitException(char badSuit){
		suit = badSuit;
	}
	
	public char getBadSuit(){
		return suit; 
	}
}
