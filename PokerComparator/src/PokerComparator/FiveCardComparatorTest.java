package PokerComparator;
import cardUtilities.*;

import static org.junit.Assert.*;
import java.io.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FiveCardComparatorTest {

	//allows output to be read by test cases
	private static final ByteArrayOutputStream output = new ByteArrayOutputStream();
	private static final ByteArrayOutputStream errOutput = new ByteArrayOutputStream();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setOut(new PrintStream(output));
		System.setErr(new PrintStream(errOutput));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	public void testGetHandBlack() {
		Hand test = FiveCardComparator.getHand("Black: 2H 4C AC JS TD");
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('T', 'D');
		Hand control = new Hand(c1,c2,c3,c4,c5);
		assertTrue(control.equals(test));
	}
	
	@Test
	public void testGetHandWhite() {
		Hand test = FiveCardComparator.getHand("White: 2H 4C AC JS TD");
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('T', 'D');
		Hand control = new Hand(c1,c2,c3,c4,c5);
		assertTrue(control.equals(test));
	}
	
	@Test
	public void testGetHandDuplicateCard() {
		Hand test = FiveCardComparator.getHand("White: 2H 4C 4C JS TD");
		assertEquals("Hands should not contain duplicate cards", errOutput.toString());
		errOutput.reset();
	}
	
	@Test
	public void testGetWinningHandQualityHighCard() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('T', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(0, FiveCardComparator.getWinningHandQuality(test));
	}
	
	@Test
	public void testGetWinningHandQualityPair() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('4', 'S');
		Card c5 = new Card('T', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(1, FiveCardComparator.getWinningHandQuality(test));
	}
	
	@Test
	public void testGetWinningHandQualityTwoPair() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('2', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('A', 'S');
		Card c5 = new Card('T', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(2, FiveCardComparator.getWinningHandQuality(test));
	}
	
	@Test
	public void testGetWinningHandQualityThreeOfAKind() {
		Card c1 = new Card('4', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('4', 'S');
		Card c5 = new Card('T', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(3, FiveCardComparator.getWinningHandQuality(test));
	}
	
	@Test
	public void testGetWinningHandQualityStraight() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'S');
		Card c5 = new Card('6', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(4, FiveCardComparator.getWinningHandQuality(test));
	}
	
	@Test
	public void testGetWinningHandQualityStraightWithFaceCard() {
		Card c1 = new Card('8', 'H');
		Card c2 = new Card('9', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('Q', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(4, FiveCardComparator.getWinningHandQuality(test));
	}
	
	@Test
	public void testGetWinningHandQualityFlush() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('J', 'C');
		Card c5 = new Card('T', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(5, FiveCardComparator.getWinningHandQuality(test));
	}
	
	@Test
	public void testGetWinningHandQualityFullHouse() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('2', 'C');
		Card c4 = new Card('4', 'S');
		Card c5 = new Card('4', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(6, FiveCardComparator.getWinningHandQuality(test));
	}
	
	@Test
	public void testGetWinningHandQualityFourOfAKind() {
		Card c1 = new Card('4', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('4', 'S');
		Card c5 = new Card('4', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(7, FiveCardComparator.getWinningHandQuality(test));
	}
	
	@Test
	public void testGetWinningHandQualityStraightFlush() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('6', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		assertEquals(8, FiveCardComparator.getWinningHandQuality(test));
	}
	
	@Test
	public void testPrintWinningHandHighCard(){
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('T', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		FiveCardComparator.printWinningHand(test, 0);
		assertEquals("high card: AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testPrintWinningHandPair() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('4', 'S');
		Card c5 = new Card('T', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		FiveCardComparator.printWinningHand(test, 1);
		assertEquals("a pair: 4C and 4S", output.toString());
		output.reset();
	}
	
	@Test
	public void testPrintWinningHandTwoPair() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('2', 'C');
		Card c4 = new Card('4', 'S');
		Card c5 = new Card('T', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		FiveCardComparator.printWinningHand(test, 2);
		assertEquals("two pair: 2H 2C 4C 4S", output.toString());
		output.reset();
	}
	
	@Test
	public void testPrintWinningHandThreeOfAKind() {
		Card c1 = new Card('4', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('4', 'S');
		Card c5 = new Card('T', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		FiveCardComparator.printWinningHand(test, 3);
		assertEquals("three of a kind: 4H 4C 4S", output.toString());
		output.reset();
	}
	
	@Test
	public void testPrintWinningHandStraight() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'S');
		Card c5 = new Card('6', 'D');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		FiveCardComparator.printWinningHand(test, 4);
		assertEquals("straight: 2H 3C 4C 5S 6D", output.toString());
		output.reset();
	}
	
	@Test
	public void testPrintWinningHandFlush() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('A', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('T', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		FiveCardComparator.printWinningHand(test, 5);
		assertEquals("flush: 2C 4C 5C TC AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testPrintWinningHandFullHouse() {
		Card c1 = new Card('2', 'S');
		Card c2 = new Card('2', 'C');
		Card c3 = new Card('4', 'D');
		Card c4 = new Card('4', 'C');
		Card c5 = new Card('4', 'H');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		FiveCardComparator.printWinningHand(test, 6);
		assertEquals("full house: 4D 4C 4H and 2S 2C", output.toString());
		output.reset();
	}
	
	@Test
	public void testPrintWinningHandFourOfAKind() {
		Card c1 = new Card('2', 'S');
		Card c2 = new Card('2', 'C');
		Card c3 = new Card('2', 'H');
		Card c4 = new Card('2', 'D');
		Card c5 = new Card('T', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		FiveCardComparator.printWinningHand(test, 7);
		assertEquals("four of a kind: 2S 2C 2H 2D", output.toString());
		output.reset();
	}
	
	@Test
	public void testPrintWinningHandStraightFlush() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('6', 'C');
		Hand test = new Hand(c1,c2,c3,c4,c5);
		FiveCardComparator.printWinningHand(test, 8);
		assertEquals("straight flush: 2C 3C 4C 5C 6C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerHighCardWhiteWinsFirstCard() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('K', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 0);
		assertEquals("White wins with high card: AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerHighCardWhiteWinsSecondCard() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('Q', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 0);
		assertEquals("White wins with high card: AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerHighCardWhiteWinsThirdCard() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('9', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 0);
		assertEquals("White wins with high card: AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerHighCardWhiteWinsFourthCard() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('5', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 0);
		assertEquals("White wins with high card: AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerHighCardWhiteWinsLastCard() {
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 0);
		assertEquals("White wins with high card: AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerHighCardBlackWinsFirstCard() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('K', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 0);
		assertEquals("Black wins with high card: AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerHighCardBlackWinsSecondCard() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('Q', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 0);
		assertEquals("Black wins with high card: AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerHighCardBlackWinsThirdCard() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('9', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 0);
		assertEquals("Black wins with high card: AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerHighCardBlackWinsFourthCard() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('5', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 0);
		assertEquals("Black wins with high card: AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerHighCardBlackWinsLastCard() {
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 0);
		assertEquals("Black wins with high card: AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerHighCardDraw(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'C');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 0);
		assertEquals("Draw", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerPairWhiteWinsDifferentPair(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('2', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 1);
		assertEquals("White wins with a pair: 3H and 3C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerPairWhiteWinsSamePairFirstCard(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('K', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 1);
		assertEquals("White wins with a pair: 3H and 3C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerPairWhiteWinsSamePairSecondCard(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('Q', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 1);
		assertEquals("White wins with a pair: 3H and 3C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerPairWhiteWinsSamePairLastCard(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('9', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 1);
		assertEquals("White wins with a pair: 3H and 3C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerPairBlackWinsDifferentPair(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('2', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 1);
		assertEquals("Black wins with a pair: 3H and 3C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerPairBlackWinsSamePairFirstCard(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('K', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 1);
		assertEquals("Black wins with a pair: 3H and 3C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerPairBlackWinsSamePairSecondCard(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('Q', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 1);
		assertEquals("Black wins with a pair: 3H and 3C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerPairBlackWinsSamePairLastCard(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('9', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 1);
		assertEquals("Black wins with a pair: 3H and 3C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerPairDraw(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 1);
		assertEquals("Draw", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerTwoPairWhiteWinsHighPair(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'D');
		Card c4 = new Card('A', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('2', 'S');
		Card c32 = new Card('T', 'H');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('J', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 2);
		assertEquals("White wins with two pair: 3H 3C AS AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerTwoPairWhiteWinsLowPair(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'D');
		Card c4 = new Card('A', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('2', 'S');
		Card c32 = new Card('T', 'H');
		Card c42 = new Card('A', 'H');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 2);
		assertEquals("White wins with two pair: 3H 3C AS AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerTwoPairWhiteWinsSingleton(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'D');
		Card c4 = new Card('A', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('9', 'H');
		Card c42 = new Card('A', 'H');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 2);
		assertEquals("White wins with two pair: 3H 3C AS AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerTwoPairBlackWinsHighPair(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'D');
		Card c4 = new Card('A', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('2', 'S');
		Card c32 = new Card('T', 'H');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('J', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 2);
		assertEquals("Black wins with two pair: 3H 3C AS AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerTwoPairBlackWinsLowPair(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'D');
		Card c4 = new Card('A', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('2', 'S');
		Card c32 = new Card('T', 'H');
		Card c42 = new Card('A', 'H');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 2);
		assertEquals("Black wins with two pair: 3H 3C AS AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerTwoPairBlackWinsSingleton(){
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'D');
		Card c4 = new Card('A', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('9', 'H');
		Card c42 = new Card('A', 'H');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 2);
		assertEquals("Black wins with two pair: 3H 3C AS AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerTwoPairDraw() {
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('T', 'D');
		Card c4 = new Card('A', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('T', 'H');
		Card c42 = new Card('A', 'H');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 2);
		assertEquals("Draw", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerThreeOfAKindWhiteWins() {
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('3', 'D');
		Card c4 = new Card('T', 'S');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('2', 'S');
		Card c32 = new Card('2', 'H');
		Card c42 = new Card('T', 'H');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 3);
		assertEquals("White wins with three of a kind: 3H 3C 3D", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerThreeOfAKindBlackWins() {
		Card c1 = new Card('3', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('3', 'D');
		Card c4 = new Card('T', 'S');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('2', 'S');
		Card c32 = new Card('2', 'H');
		Card c42 = new Card('T', 'H');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 3);
		assertEquals("Black wins with three of a kind: 3H 3C 3D", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerStraightWhiteWins() {
		Card c1 = new Card('7', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'D');
		Card c4 = new Card('5', 'S');
		Card c5 = new Card('6', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('4', 'H');
		Card c42 = new Card('5', 'H');
		Card c52 = new Card('6', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 4);
		assertEquals("White wins with straight: 3C 4D 5S 6C 7H", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerStraightBlackWins() {
		Card c1 = new Card('7', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'D');
		Card c4 = new Card('5', 'S');
		Card c5 = new Card('6', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('4', 'H');
		Card c42 = new Card('5', 'H');
		Card c52 = new Card('6', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 4);
		assertEquals("Black wins with straight: 3C 4D 5S 6C 7H", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerStraightDraw() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'D');
		Card c4 = new Card('5', 'S');
		Card c5 = new Card('6', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('4', 'H');
		Card c42 = new Card('5', 'H');
		Card c52 = new Card('6', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 4);
		assertEquals("Draw", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFlusWhiteWinsFirstCard() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'C');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'S');
		Card c22 = new Card('4', 'S');
		Card c32 = new Card('T', 'S');
		Card c42 = new Card('J', 'S');
		Card c52 = new Card('K', 'S');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 5);
		assertEquals("White wins with flush: 2C 4C TC JC AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFlushWhiteWinsSecondCard() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('Q', 'C');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('4', 'D');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'D');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 5);
		assertEquals("White wins with flush: 2C 4C TC QC AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFlushWhiteWinsThirdCard() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'C');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('4', 'D');
		Card c32 = new Card('9', 'D');
		Card c42 = new Card('J', 'D');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 5);
		assertEquals("White wins with flush: 2C 4C TC JC AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFlushWhiteWinsFourthCard() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('5', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'C');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('4', 'D');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'D');
		Card c52 = new Card('A', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 5);
		assertEquals("White wins with flush: 2C 5C TC JC AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFlushWhiteWinsLastCard() {
		Card c1 = new Card('3', 'C');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'C');
		Card c5 = new Card('A', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('4', 'C');
		Card c32 = new Card('T', 'C');
		Card c42 = new Card('J', 'C');
		Card c52 = new Card('A', 'C');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 5);
		assertEquals("White wins with flush: 3C 4C TC JC AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFlushBlackWinsFirstCard() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'C');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('4', 'D');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'D');
		Card c52 = new Card('K', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 5);
		assertEquals("Black wins with flush: 2C 4C TC JC AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFlushBlackWinsSecondCard() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('Q', 'C');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('4', 'D');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'D');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 5);
		assertEquals("Black wins with flush: 2C 4C TC QC AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFlushBlackWinsThirdCard() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'C');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('4', 'D');
		Card c32 = new Card('9', 'D');
		Card c42 = new Card('J', 'D');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 5);
		assertEquals("Black wins with flush: 2C 4C TC JC AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFlushBlackWinsFourthCard() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('5', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'C');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('4', 'D');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'D');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 5);
		assertEquals("Black wins with flush: 2C 5C TC JC AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFlushBlackWinsLastCard() {
		Card c1 = new Card('3', 'C');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'C');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('4', 'D');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'D');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 5);
		assertEquals("Black wins with flush: 3C 4C TC JC AC", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFlushDraw(){
		Card c1 = new Card('3', 'C');
		Card c2 = new Card('4', 'C');
		Card c3 = new Card('T', 'C');
		Card c4 = new Card('J', 'C');
		Card c5 = new Card('A', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('3', 'D');
		Card c22 = new Card('4', 'D');
		Card c32 = new Card('T', 'D');
		Card c42 = new Card('J', 'D');
		Card c52 = new Card('A', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 5);
		assertEquals("Draw", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFullHouseWhiteWins() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('2', 'C');
		Card c3 = new Card('4', 'D');
		Card c4 = new Card('4', 'S');
		Card c5 = new Card('4', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('2', 'S');
		Card c32 = new Card('3', 'H');
		Card c42 = new Card('3', 'S');
		Card c52 = new Card('3', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 6);
		assertEquals("White wins with full house: 4D 4S 4C and 2H 2C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFullHouseBlackWins() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('2', 'C');
		Card c3 = new Card('4', 'D');
		Card c4 = new Card('4', 'S');
		Card c5 = new Card('4', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('2', 'S');
		Card c32 = new Card('3', 'H');
		Card c42 = new Card('3', 'S');
		Card c52 = new Card('3', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 6);
		assertEquals("Black wins with full house: 4D 4S 4C and 2H 2C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFourOfAKindWhiteWins() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'D');
		Card c4 = new Card('4', 'S');
		Card c5 = new Card('4', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'C');
		Card c32 = new Card('3', 'H');
		Card c42 = new Card('3', 'S');
		Card c52 = new Card('3', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 7);
		assertEquals("White wins with four of a kind: 4H 4D 4S 4C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerFourOfAKindBlackWins() {
		Card c1 = new Card('2', 'H');
		Card c2 = new Card('4', 'H');
		Card c3 = new Card('4', 'D');
		Card c4 = new Card('4', 'S');
		Card c5 = new Card('4', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'S');
		Card c32 = new Card('3', 'H');
		Card c42 = new Card('3', 'S');
		Card c52 = new Card('3', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 7);
		assertEquals("Black wins with four of a kind: 4H 4D 4S 4C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerStraightFlushWhiteWins() {
		Card c1 = new Card('7', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('6', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'D');
		Card c32 = new Card('4', 'D');
		Card c42 = new Card('5', 'D');
		Card c52 = new Card('6', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 8);
		assertEquals("White wins with straight flush: 3C 4C 5C 6C 7C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerStraightFlushBlackWins() {
		Card c1 = new Card('7', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('6', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'D');
		Card c32 = new Card('4', 'D');
		Card c42 = new Card('5', 'D');
		Card c52 = new Card('6', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 8);
		assertEquals("Black wins with straight flush: 3C 4C 5C 6C 7C", output.toString());
		output.reset();
	}
	
	@Test
	public void testTiebreakerStraightFlushDraw() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('6', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'D');
		Card c32 = new Card('4', 'D');
		Card c42 = new Card('5', 'D');
		Card c52 = new Card('6', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.tiebreaker(white, black, 8);
		assertEquals("Draw", output.toString());
		output.reset();
	}
	
	@Test
	public void testCheckInputBlackSmall() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('6', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'D');
		Card c32 = new Card('4', 'D');
		Card c42 = new Card('5', 'D');
		Hand black = new Hand(c12,c22,c32,c42);
		FiveCardComparator.checkInput(black, white);
		assertEquals("Hands should be 5 cards each", errOutput.toString());
		errOutput.reset();
	}
	
	@Test
	public void testCheckInputBlackLarge() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('6', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'D');
		Card c32 = new Card('4', 'D');
		Card c42 = new Card('5', 'D');
		Card c52 = new Card('6', 'D');
		Card c62 = new Card('7', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52,c62);
		FiveCardComparator.checkInput(black, white);
		assertEquals("Hands should be 5 cards each", errOutput.toString());
		errOutput.reset();
	}
	
	@Test
	public void testCheckInputWhiteSmall() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('6', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'D');
		Card c32 = new Card('4', 'D');
		Card c42 = new Card('5', 'D');
		Hand white = new Hand(c12,c22,c32,c42);
		FiveCardComparator.checkInput(black, white);
		assertEquals("Hands should be 5 cards each", errOutput.toString());
		errOutput.reset();
	}
	
	@Test
	public void testCheckInputWhiteLarge() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('6', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'D');
		Card c32 = new Card('4', 'D');
		Card c42 = new Card('5', 'D');
		Card c52 = new Card('6', 'D');
		Card c62 = new Card('7', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52,c62);
		FiveCardComparator.checkInput(black, white);
		assertEquals("Hands should be 5 cards each", errOutput.toString());
		errOutput.reset();
	}
	
	@Test
	public void testCheckInputBothSmall() {
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'D');
		Card c32 = new Card('4', 'D');
		Card c42 = new Card('5', 'D');
		Hand white = new Hand(c12,c22,c32,c42);
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Hand black = new Hand(c1,c2,c3,c4);
		FiveCardComparator.checkInput(black, white);
		assertEquals("Hands should be 5 cards each", errOutput.toString());
		errOutput.reset();
	}
	
	@Test
	public void testCheckInputBothLarge() {
		Card c12 = new Card('2', 'D');
		Card c22 = new Card('3', 'D');
		Card c32 = new Card('4', 'D');
		Card c42 = new Card('5', 'D');
		Card c52 = new Card('6', 'D');
		Card c62 = new Card('7', 'D');
		Hand white = new Hand(c12,c22,c32,c42,c52,c62);
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('6', 'C');
		Card c6 = new Card('7', 'C');
		Hand black = new Hand(c1,c2,c3,c4,c5,c6);
		FiveCardComparator.checkInput(black, white);
		assertEquals("Hands should be 5 cards each", errOutput.toString());
		errOutput.reset();
	}
	
	@Test
	public void testCheckInputContainsDuplicate() {
		Card c1 = new Card('2', 'C');
		Card c2 = new Card('3', 'C');
		Card c3 = new Card('4', 'C');
		Card c4 = new Card('5', 'C');
		Card c5 = new Card('6', 'C');
		Hand white = new Hand(c1,c2,c3,c4,c5);
		Card c12 = new Card('2', 'C');
		Card c22 = new Card('3', 'D');
		Card c32 = new Card('4', 'D');
		Card c42 = new Card('5', 'D');
		Card c52 = new Card('6', 'D');
		Hand black = new Hand(c12,c22,c32,c42,c52);
		FiveCardComparator.checkInput(black, white);
		assertEquals("Hands should not contain the same cards", errOutput.toString());
		errOutput.reset();
	}

}
