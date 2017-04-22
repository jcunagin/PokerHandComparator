package cardUtilities;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class HandTest {

	@Test
	public void testHand() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('K', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertNotNull(test);
		assertFalse(test.isEmpty());
	}
	
	@Test
	public void testHandEmpty() {
		Hand test = new Hand();
		assertTrue(test.isEmpty());
	}
	
	@Test
	public void testHandDuplicate() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('2', 'C');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('K', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertNotNull(test);
	}
	
	@Test
	public void testGetHighCardEmpty() {
		Hand test = new Hand();
		assertNull(test.getHighCard());
	}

	@Test
	public void testGetHighCardNumeric() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('5', 'D');
		Card c5 = new Card('6', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c5, test.getHighCard());
	}
	
	@Test
	public void testGetHighCardFace() {
		Card c1 = new Card('T', 'C');
		Card c2 = new Card('J', 'C');
		Card c3 = new Card('Q', 'S');
		Card c4 = new Card('K', 'D');
		Card c5 = new Card('A', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c5, test.getHighCard());
	}
	
	@Test
	public void testGetHighCardMixed() {
		Card c1 = new Card('J', 'C');
		Card c2 = new Card('7', 'C');
		Card c3 = new Card('Q', 'S');
		Card c4 = new Card('8', 'D');
		Card c5 = new Card('K', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c5, test.getHighCard());
	}
	
	@Test
	public void testGetHighCardPosition1() {
		Card c1 = new Card('A', 'C');
		Card c2 = new Card('T', 'C');
		Card c3 = new Card('Q', 'S');
		Card c4 = new Card('K', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c1, test.getHighCard());
	}
	
	@Test
	public void testGetHighCardPosition2() {
		Card c1 = new Card('T', 'C');
		Card c2 = new Card('A', 'C');
		Card c3 = new Card('Q', 'S');
		Card c4 = new Card('K', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c2, test.getHighCard());
	}
	
	@Test
	public void testGetHighCardPosition3() {
		Card c1 = new Card('T', 'C');
		Card c2 = new Card('Q', 'C');
		Card c3 = new Card('A', 'S');
		Card c4 = new Card('K', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c3, test.getHighCard());
	}
	
	@Test
	public void testGetHighCardPosition4() {
		Card c1 = new Card('T', 'C');
		Card c2 = new Card('K', 'C');
		Card c3 = new Card('Q', 'S');
		Card c4 = new Card('A', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c4, test.getHighCard());
	}
	
	@Test
	public void testGetHighCardDuplicates() {
		Card c1 = new Card('T', 'C');
		Card c2 = new Card('A', 'C');
		Card c3 = new Card('Q', 'S');
		Card c4 = new Card('K', 'D');
		Card c5 = new Card('A', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c2.getRank(), test.getHighCard().getRank());
	}
	
	@Test
	public void testGetLowCardEmpty() {
		Hand test = new Hand();
		assertNull(test.getLowCard());
	}

	@Test
	public void testGetLowCardNumeric() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('5', 'D');
		Card c5 = new Card('6', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c1, test.getLowCard());
	}
	
	@Test
	public void testGetLowCardFace() {
		Card c1 = new Card('T', 'C');
		Card c2 = new Card('J', 'C');
		Card c3 = new Card('Q', 'S');
		Card c4 = new Card('K', 'D');
		Card c5 = new Card('A', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c1, test.getLowCard());
	}
	
	@Test
	public void testGetLowCardMixed() {
		Card c1 = new Card('7', 'C');
		Card c2 = new Card('J', 'C');
		Card c3 = new Card('Q', 'S');
		Card c4 = new Card('8', 'D');
		Card c5 = new Card('K', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c1, test.getLowCard());
	}
	
	@Test
	public void testGetLowCardPosition2() {
		Card c1 = new Card('A', 'C');
		Card c2 = new Card('T', 'C');
		Card c3 = new Card('Q', 'S');
		Card c4 = new Card('K', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c2, test.getLowCard());
	}
	
	@Test
	public void testGetLowCardPosition3() {
		Card c1 = new Card('T', 'C');
		Card c2 = new Card('A', 'C');
		Card c3 = new Card('7', 'S');
		Card c4 = new Card('K', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c3, test.getLowCard());
	}
	
	@Test
	public void testGetLowCardPosition4() {
		Card c1 = new Card('T', 'C');
		Card c2 = new Card('Q', 'C');
		Card c3 = new Card('A', 'S');
		Card c4 = new Card('7', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c4, test.getLowCard());
	}
	
	@Test
	public void testGetLowCardPosition5() {
		Card c1 = new Card('T', 'C');
		Card c2 = new Card('K', 'C');
		Card c3 = new Card('Q', 'S');
		Card c4 = new Card('A', 'D');
		Card c5 = new Card('7', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c5, test.getLowCard());
	}
	
	@Test
	public void testGetLowCardDuplicates() {
		Card c1 = new Card('T', 'C');
		Card c2 = new Card('A', 'C');
		Card c3 = new Card('Q', 'S');
		Card c4 = new Card('T', 'D');
		Card c5 = new Card('A', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(c1.getRank(), test.getLowCard().getRank());
	}
	
	@Test
	public void testCountRankMatchesEmpty() {
		Hand test = new Hand();
		assertTrue(test.countRankMatches().isEmpty());
	}
	
	@Test
	public void testCountRankMatches1() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'H');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Map<Character, Integer> result = test.countRankMatches();
		assertEquals(1, result.get('2').intValue());
		assertEquals(1, result.get('3').intValue());
		assertEquals(1, result.get('5').intValue());
		assertEquals(1, result.get('4').intValue());
		assertEquals(1, result.get('J').intValue());
	}
	
	@Test
	public void testCountRankMatches2() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Map<Character, Integer> result = test.countRankMatches();
		assertEquals(1, result.get('2').intValue());
		assertEquals(1, result.get('3').intValue());
		assertEquals(2, result.get('4').intValue());
		assertEquals(1, result.get('J').intValue());
	}
	
	@Test
	public void testCountRankMatches3() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Map<Character, Integer> result = test.countRankMatches();
		assertEquals(1, result.get('2').intValue());
		assertEquals(3, result.get('4').intValue());
		assertEquals(1, result.get('J').intValue());
	}
	
	@Test
	public void testCountRankMatches4() {
		Card c1 = new Card('4', 'C');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Map<Character, Integer> result = test.countRankMatches();
		assertEquals(4, result.get('4').intValue());
		assertEquals(1, result.get('J').intValue());
	}
	
	@Test
	public void testCountRankMatches5() {
		Card c1 = new Card('4', 'C');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('4', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Map<Character, Integer> result = test.countRankMatches();
		assertEquals(5, result.get('4').intValue());
	}
	
	@Test
	public void testCountRankTwoPair() {
		Card c1 = new Card('3', 'C');
		Card c2 = new Card('3', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Map<Character, Integer> result = test.countRankMatches();
		assertEquals(2, result.get('3').intValue());
		assertEquals(2, result.get('4').intValue());
		assertEquals(1, result.get('J').intValue());
	}
	
	@Test
	public void testCountRankMatchesFullHouse() {
		Card c1 = new Card('4', 'C');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('3', 'D');
		Card c5 = new Card('3', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Map<Character, Integer> result = test.countRankMatches();
		assertEquals(3, result.get('4').intValue());
		assertEquals(2, result.get('3').intValue());
	}
	
	@Test
	public void testGetRankMatchesEmpty() {
		Hand test = new Hand();
		Card c1 = new Card('4', 'C');
		assertTrue(test.getRankMatches(c1).isEmpty());
	}
	
	@Test
	public void testGetRankMatches0() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('2', 'H');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand result = new Hand();
		Card c6 = new Card('A', 'D');
		assertTrue(result.equals(test.getRankMatches(c6)));
	}
	
	
	@Test
	public void testGetRankMatches1() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'H');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand result = new Hand(c1);
		Card c6 = new Card('2', 'D');
		assertTrue(result.equals(test.getRankMatches(c6)));
	}
	
	@Test
	public void testGetRankMatches2() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('2', 'H');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand result = new Hand(c1, c2);
		Card c6 = new Card('2', 'D');
		assertTrue(result.equals(test.getRankMatches(c6)));
	}
	
	
	@Test
	public void testEqualsTrueEmpty(){
		Hand test = new Hand();
		Hand test2 = new Hand();
		assertTrue(test.equals(test2));
	}
	
	@Test
	public void testEqualsTrueSameObjectsSameOrder(){
		Card c1 = new Card('4', 'C');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('3', 'D');
		Card c5 = new Card('3', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand test2 = new Hand(c1,c2,c3,c4,c5);
		assertTrue(test.equals(test2));
	}
	
	@Test
	public void testEqualsTrueSameObjectsDifferentOrder(){
		Card c1 = new Card('4', 'C');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('3', 'D');
		Card c5 = new Card('3', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand test2 = new Hand(c2,c1,c4,c3,c5);
		assertTrue(test.equals(test2));
	}
	
	@Test
	public void testEqualsTrueIdenticalObjectsSameOrder(){
		Card c1 = new Card('4', 'C');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('3', 'D');
		Card c5 = new Card('3', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('4', 'C');
		Card c22 = new Card('4', 'H');
		Card c32 = new Card('4', 'S');
		Card c42 = new Card('3', 'D');
		Card c52 = new Card('3', 'C');
		Hand test2 = new Hand(c12,c22,c32,c42,c52);
		assertTrue(test.equals(test2));
	}
	
	public void testEqualsTrueIdenticalObjectsDifferentOrder() {
		Card c1 = new Card('4', 'C');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('3', 'D');
		Card c5 = new Card('3', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('4', 'C');
		Card c22 = new Card('4', 'H');
		Card c32 = new Card('4', 'S');
		Card c42 = new Card('3', 'D');
		Card c52 = new Card('3', 'C');
		Hand test2 = new Hand(c52,c32,c42,c22,c12);
		assertTrue(test.equals(test2));
	}
	
	@Test
	public void testEqualsFalseThisEmpty(){
		Card c1 = new Card('4', 'C');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('3', 'D');
		Card c5 = new Card('3', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand test2 = new Hand();
		assertFalse(test.equals(test2));
	}
	
	@Test
	public void testEqualsFalseComparisonEmpty(){
		Card c1 = new Card('4', 'C');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('3', 'D');
		Card c5 = new Card('3', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand test2 = new Hand();
		assertFalse(test2.equals(test));
	}
	
	@Test
	public void testAddHighCard(){
		Card c1 = new Card('3', 'C');
		Card c2 = new Card('3', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand test2 = new Hand(c1,c2,c3,c4);
		test2.add(c5);
		assertTrue(test.equals(test2));
	}
	
	@Test
	public void testAddMiddleCard(){
		Card c1 = new Card('3', 'C');
		Card c2 = new Card('3', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand test2 = new Hand(c1,c2,c5,c4);
		test2.add(c5);
		assertTrue(test.equals(test2));
	}
	
	@Test
	public void testAddLowCard(){
		Card c1 = new Card('3', 'C');
		Card c2 = new Card('3', 'H');
		Card c3 = new Card('4', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand test2 = new Hand(c5,c2,c3,c4);
		test2.add(c1);
		assertTrue(test.equals(test2));
	}
	
	@Test
	public void testToString(){
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'H');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals("2C 3H 4D 5S JC", test.toString());
	}
	
	@Test
	public void testToStringEmpty() {
		Hand test = new Hand();
		assertEquals("", test.toString());
	}
	
	
	@Test
	public void testCountSuitMatches1() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'H');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'D');
		Hand test = new Hand(c1,c2,c3,c4);
		Map<Character, Integer> result = test.countSuitMatches();
		assertEquals(1, result.get('C').intValue());
		assertEquals(1, result.get('H').intValue());
		assertEquals(1, result.get('S').intValue());
		assertEquals(1, result.get('D').intValue());
	}
	
	@Test
	public void testCountSuitMatches2() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'D');
		Hand test = new Hand(c1,c2,c3,c4);
		Map<Character, Integer> result = test.countSuitMatches();
		assertEquals(2, result.get('C').intValue());
		assertEquals(1, result.get('S').intValue());
		assertEquals(1, result.get('D').intValue());
	}
	
	@Test
	public void testCountSuitMatches3() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('5', 'C');
		Card c4 = new Card('4', 'D');
		Hand test = new Hand(c1,c2,c3,c4);
		Map<Character, Integer> result = test.countSuitMatches();
		assertEquals(3, result.get('C').intValue());
		assertEquals(1, result.get('D').intValue());
	}
	
	@Test
	public void testCountSuitMatches4() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('5', 'C');
		Card c4 = new Card('4', 'C');
		Hand test = new Hand(c1,c2,c3,c4);
		Map<Character, Integer> result = test.countSuitMatches();
		assertEquals(4, result.get('C').intValue());
	}
	
	@Test
	public void testCountSuitMatchesTwoPair() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('5', 'D');
		Card c4 = new Card('4', 'D');
		Hand test = new Hand(c1,c2,c3,c4);
		Map<Character, Integer> result = test.countSuitMatches();
		assertEquals(2, result.get('C').intValue());
		assertEquals(2, result.get('D').intValue());
	}
	
	@Test
	public void testGetSuitMatchesEmpty() {
		Hand test = new Hand();
		Card c1 = new Card('4', 'C');
		assertTrue(test.getSuitMatches(c1).isEmpty());
	}
	
	@Test
	public void testGetSuitMatches0() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('2', 'H');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'C');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand result = new Hand();
		Card c6 = new Card('A', 'D');
		assertTrue(result.equals(test.getSuitMatches(c6)));
	}
	
	
	@Test
	public void testGetSuitMatches1() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'H');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand result = new Hand(c4);
		Card c6 = new Card('2', 'D');
		assertTrue(result.equals(test.getSuitMatches(c6)));
	}
	
	@Test
	public void testGetSuitMatches2() {
		Card c1 = new Card('2', 'D');
		Card c2 = new Card('2', 'H');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Hand result = new Hand(c1, c4);
		Card c6 = new Card('2', 'D');
		assertTrue(result.equals(test.getSuitMatches(c6)));
	}
	
	@Test
	public void testContainsTrue() {
		Card c1 = new Card('2', 'D');
		Card c2 = new Card('2', 'H');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Card c6 = new Card('2', 'D');
		assertTrue(test.contains(c6));
	}
	
	@Test
	public void testContainsFalseSameSuit() {
		Card c1 = new Card('2', 'D');
		Card c2 = new Card('2', 'H');
		Card c3 = new Card('5', 'S');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Card c6 = new Card('7', 'D');
		assertFalse(test.contains(c6));
	}
	
	@Test
	public void testContainsFalseSameRank() {
		Card c1 = new Card('2', 'D');
		Card c2 = new Card('2', 'H');
		Card c3 = new Card('5', 'D');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Card c6 = new Card('5', 'S');
		assertFalse(test.contains(c6));
	}
	
	@Test
	public void testContainsFalseNoSimilarities() {
		Card c1 = new Card('2', 'D');
		Card c2 = new Card('2', 'H');
		Card c3 = new Card('5', 'D');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Card c6 = new Card('7', 'S');
		assertFalse(test.contains(c6));
	}
	
	@Test
	public void testSize0() {
		Hand test = new Hand();
		assertEquals(0, test.size());
	}
	
	@Test
	public void testSizeNot0() {
		Card c1 = new Card('2', 'D');
		Card c2 = new Card('2', 'H');
		Card c3 = new Card('5', 'D');
		Card c4 = new Card('4', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		
		assertEquals(5, test.size());
	}
	
	@Test
	public void testGetCardsEmpty(){
		Hand test = new Hand();
		Card[] testCards = test.getCards();
		assertEquals(0, testCards.length);
	}
	
	@Test
	public void testGetCardsNotEmpty() {
		Card c1 = new Card('2', 'D');
		Card c2 = new Card('2', 'H');
		Card c3 = new Card('4', 'D');
		Card c4 = new Card('5', 'D');
		Card c5 = new Card('J', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		Card[] testCards = test.getCards();
		assertEquals(c1, testCards[0]);
		assertEquals(c2, testCards[1]);
		assertEquals(c3, testCards[2]);
		assertEquals(c4, testCards[3]);
		assertEquals(c5, testCards[4]);
	}
}
	