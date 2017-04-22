package cardUtilities;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CardTest {
	
	private static final ByteArrayOutputStream errOutput = new ByteArrayOutputStream();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setErr(new PrintStream(errOutput));
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.setErr(null);
	}

	@Test
	public void testCardErrRank(){
		Card test = new Card('V', 'C');
		assertEquals("V is not a valid Rank", errOutput.toString());
		errOutput.reset();
	}
	
	@Test
	public void testCardErrSuit(){
		Card test = new Card('2', 'G');
		assertEquals("G is not a valid Suit", errOutput.toString());
		errOutput.reset();
	}
	
	@Test
	public void testCardRank2() {
		Card test = new Card('2', 'C');
		assertEquals(test.getRank(), '2');	
	}
	
	@Test
	public void testCardRank3() {
		Card test = new Card('3', 'C');
		assertEquals(test.getRank(), '3');	
	}
	
	@Test
	public void testCardRank4() {
		Card test = new Card('4', 'C');
		assertEquals(test.getRank(), '4');	
	}
	
	@Test
	public void testCardRank5() {
		Card test = new Card('5', 'C');
		assertEquals(test.getRank(), '5');	
	}
	
	@Test
	public void testCardRank6() {
		Card test = new Card('6', 'C');
		assertEquals(test.getRank(), '6');	
	}
	
	@Test
	public void testCardRank7() {
		Card test = new Card('7', 'C');
		assertEquals(test.getRank(), '7');	
	}
	
	@Test
	public void testCardRank8() {
		Card test = new Card('8', 'C');
		assertEquals(test.getRank(), '8');	
	}
	
	@Test
	public void testCardRank9() {
		Card test = new Card('9', 'C');
		assertEquals(test.getRank(), '9');	
	}
	
	@Test
	public void testCardRankT() {
		Card test = new Card('T', 'C');
		assertEquals(test.getRank(), 'T');	
	}
	
	@Test
	public void testCardRankJ() {
		Card test = new Card('J', 'C');
		assertEquals(test.getRank(), 'J');	
	}
	
	@Test
	public void testCardRankQ() {
		Card test = new Card('Q', 'C');
		assertEquals(test.getRank(), 'Q');	
	}
	
	@Test
	public void testCardRankK() {
		Card test = new Card('K', 'C');
		assertEquals(test.getRank(), 'K');	
	}
	
	@Test
	public void testCardRankA() {
		Card test = new Card('A', 'C');
		assertEquals(test.getRank(), 'A');
	}
	
	@Test
	public void testCardSuitC() {
		Card test = new Card('2', 'C');
		assertEquals(test.getSuit(), 'C');
	}
	
	@Test
	public void testCardSuitS() {
		Card test = new Card('2', 'S');
		assertEquals(test.getSuit(), 'S');
	}
	
	@Test
	public void testCardSuitH() {
		Card test = new Card('2', 'H');
		assertEquals(test.getSuit(), 'H');
	}
	
	@Test
	public void testCardSuitD() {
		Card test = new Card('2', 'D');
		assertEquals(test.getSuit(), 'D');
	}

	@Test
	public void testIsValidSuitC() {
		char test = 'C';
		assertTrue(Card.isValidSuit(test));
	}
	
	@Test
	public void testIsValidSuitD() {
		char test = 'D';
		assertTrue(Card.isValidSuit(test));
	}
	
	@Test
	public void testIsValidSuitH() {
		char test = 'H';
		assertTrue(Card.isValidSuit(test));
	}
	
	@Test
	public void testIsValidSuitS() {
		char test = 'S';
		assertTrue(Card.isValidSuit(test));
	}
	
	@Test
	public void testIsValidSuitFalse() {
		char test = 'z';
		assertFalse(Card.isValidSuit(test));
	}

	@Test
	public void testIsValidRank2() {
		char test = '2';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRank3() {
		char test = '3';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRank4() {
		char test = '4';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRank5() {
		char test = '5';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRank6() {
		char test = '6';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRank7() {
		char test = '7';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRank8() {
		char test = '8';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRank9() {
		char test = '9';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRankT() {
		char test = 'T';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRankJ() {
		char test = 'J';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRankQ() {
		char test = 'Q';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRankK() {
		char test = 'K';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRankA() {
		char test = 'A';
		assertTrue(Card.isValidRank(test));
	}
	
	@Test
	public void testIsValidRankFalse() {
		char test = 'z';
		assertFalse(Card.isValidRank(test));
	}
	
	@Test
	public void testCompareRank2A() {
		Card test = new Card('2', 'C');
		Card compare = new Card('A', 'C');
		assertEquals(test.compareRank(compare), 12);
	}
	
	@Test
	public void testCompareRankA2() {
		Card test = new Card('A', 'C');
		Card compare = new Card('2', 'C');
		assertEquals(test.compareRank(compare), -12);
	}
	
	@Test
	public void testCompareRank22() {
		Card test = new Card('2', 'C');
		Card compare = new Card('2', 'C');
		assertEquals(test.compareRank(compare), 0);
	}
	
	@Test
	public void testCompareRankAA() {
		Card test = new Card('A', 'C');
		Card compare = new Card('A', 'C');
		assertEquals(test.compareRank(compare), 0);
	}
	
	@Test
	public void testCompareRank66() {
		Card test = new Card('6', 'C');
		Card compare = new Card('6', 'C');
		assertEquals(test.compareRank(compare), 0);
	}
	
	@Test
	public void testCompareRank26() {
		Card test = new Card('2', 'C');
		Card compare = new Card('6', 'C');
		assertEquals(test.compareRank(compare), 4);
	}
	
	@Test
	public void testCompareRank6A() {
		Card test = new Card('6', 'C');
		Card compare = new Card('A', 'C');
		assertEquals(test.compareRank(compare), 8);
	}
	
	@Test
	public void testCompareSuitCC() {
		Card test = new Card('2', 'C');
		Card compare = new Card('2', 'C');
		assertTrue(test.compareSuit(compare));
	}
	
	@Test
	public void testCompareSuitCS() {
		Card test = new Card('2', 'C');
		Card compare = new Card('2', 'S');
		assertFalse(test.compareSuit(compare));
	}
	
	@Test
	public void testToString2C() {
		Card test = new Card('2', 'C');
		assertEquals(test.toString(), "2C");
	}
	
	@Test
	public void testToStringAH() {
		Card test = new Card('A', 'H');
		assertEquals(test.toString(), "AH");
	}
	
	
	@Test
	public void testEquals() {
		Card test = new Card('2', 'C');
		Card compare = new Card('2', 'C');
		assertTrue(test.equals(compare));
	}
	
	@Test
	public void testEqualsFalseRank() {
		Card test = new Card('2', 'C');
		Card compare = new Card('3', 'C');
		assertFalse(test.equals(compare));
	}
	
	@Test
	public void testEqualsFalseSuit() {
		Card test = new Card('2', 'C');
		Card compare = new Card('2', 'H');
		assertFalse(test.equals(compare));
	}
	
	@Test
	public void testEqualsFalseAll() {
		Card test = new Card('2', 'C');
		Card compare = new Card('A', 'H');
		assertFalse(test.equals(compare));
	}

}
