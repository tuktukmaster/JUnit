import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Quick and dirty tests of Kayak finder program
 * Not an exhaustive set of tests, but a good start
 * @author Nathan Gossett
 *
 */
public class TestsOfKayakFinder {
	
	/**
	 * Make sure it doesn't find a Kayak that isn't there
	 */
	@Test
	public void testNoKayak() {
		char[][] testfail = {{'A', 'K', 'A', 'Y', 'Y', 'Y', 'A', 'K', 'K', 'K'},
				{'K', 'K', 'K', 'Y', 'K', 'A', 'A', 'A', 'K', 'Y'},
				{'K', 'A', 'K', 'K', 'A', 'A', 'K', 'Y', 'Y', 'Y'},
				{'Y', 'K', 'Y', 'Y', 'A', 'A', 'K', 'K', 'Y', 'A'},
				{'Y', 'K', 'K', 'K', 'K', 'Y', 'A', 'A', 'K', 'A'},
				{'A', 'Y', 'Y', 'Y', 'K', 'A', 'A', 'Y', 'Y', 'K'},
				{'Y', 'Y', 'A', 'A', 'A', 'A', 'Y', 'Y', 'A', 'K'},
				{'A', 'A', 'K', 'Y', 'A', 'A', 'Y', 'Y', 'Y', 'Y'},
				{'Y', 'Y', 'K', 'A', 'K', 'K', 'K', 'Y', 'Y', 'A'},
				{'A', 'A', 'K', 'K', 'K', 'A', 'Y', 'Y', 'A', 'K'}};
		assertFalse(Kayak.containsKayak(testfail));
	}
	
	/*
	 * Make sure it fails on empty matrices
	 * */
	@Test
	public void emptyInput() {
		char[][] testEmpty1 = {{}};
		char[][] testEmpty2 = {{},{},{}};
		assertFalse(Kayak.containsKayak(testEmpty1));
		assertFalse(Kayak.containsKayak(testEmpty2));
	}
	
	/* 
	 * Make sure it works for small sets
	 */
	@Test
	public void smallSetsPassing() {
		char[][] smallSetHorizontalPass = {{'K','A','Y','A','K'}};
		char[][] smallSetVertPass = {{'K'},{'A'},{'Y'},{'A'},{'K'}};
		assertTrue(Kayak.containsKayak(smallSetVertPass));
		assertTrue(Kayak.containsKayak(smallSetHorizontalPass));	
	}
	@Test
	public void smallSetsFailing() {
		char[][] smallSetHorizontalPass = {{'K','A','A','K'}};
		char[][] smallSetVertPass = {{'K'},{'A'},{'E'},{'A'},{'K'}};
		assertFalse(Kayak.containsKayak(smallSetVertPass));
		assertFalse(Kayak.containsKayak(smallSetHorizontalPass));	
	}
	
	/*
	 * Just some weird edge cases that might somehow fail
	 */
	@Test
	public void edgeCaseFailures() {
		char[][] twoYFailHorizontal = {{'K','A','Y','Y','A','K'}};
		char[][] twoYFailVert = {{'K'},{'A'},{'Y'},{'Y'},{'A'},{'K'}};
		assertFalse(Kayak.containsKayak(twoYFailHorizontal));
		assertFalse(Kayak.containsKayak(twoYFailVert));	
	}
	
	/**
	 * Find a horizontal kayak
	 */
	@Test
	public void testHorizontalKayak() {	
		char[][] testhorz = {{'A', 'K', 'A', 'Y', 'Y', 'Y', 'A', 'K', 'K', 'K'},
				{'K', 'K', 'K', 'Y', 'K', 'A', 'A', 'A', 'K', 'Y'},
				{'K', 'A', 'K', 'K', 'A', 'A', 'K', 'Y', 'Y', 'Y'},
				{'Y', 'K', 'Y', 'Y', 'A', 'A', 'K', 'K', 'Y', 'A'},
				{'Y', 'K', 'K', 'K', 'K', 'Y', 'A', 'A', 'K', 'A'},
				{'A', 'Y', 'Y', 'Y', 'K', 'A', 'A', 'Y', 'Y', 'K'},
				{'Y', 'Y', 'A', 'A', 'A', 'A', 'Y', 'Y', 'A', 'K'},
				{'A', 'A', 'K', 'Y', 'A', 'A', 'Y', 'Y', 'Y', 'Y'},
				{'Y', 'Y', 'K', 'A', 'K', 'K', 'K', 'Y', 'Y', 'A'},
				{'A', 'A', 'K', 'K', 'K', 'A', 'Y', 'A', 'K', 'K'}};
		assertTrue(Kayak.containsKayak(testhorz));
	}
	
	/**
	 * Find a vertical kayak
	 */
	@Test
	public void testVerticalKayak() {
		char[][] testvert = 
			   {{'A', 'K', 'A', 'Y', 'Y', 'Y', 'A', 'K', 'K', 'K'},
				{'K', 'K', 'K', 'Y', 'K', 'A', 'A', 'A', 'K', 'Y'},
				{'K', 'Y', 'K', 'K', 'A', 'A', 'K', 'Y', 'Y', 'Y'},
				{'Y', 'K', 'Y', 'K', 'A', 'A', 'K', 'A', 'Y', 'A'},
				{'Y', 'K', 'K', 'A', 'K', 'Y', 'A', 'K', 'K', 'A'},
				{'A', 'Y', 'Y', 'Y', 'K', 'A', 'A', 'Y', 'Y', 'K'},
				{'Y', 'Y', 'A', 'K', 'A', 'A', 'Y', 'Y', 'A', 'K'},
				{'A', 'A', 'K', 'Y', 'A', 'A', 'Y', 'Y', 'Y', 'Y'},
				{'Y', 'Y', 'K', 'A', 'K', 'K', 'K', 'Y', 'Y', 'A'},
				{'A', 'A', 'K', 'K', 'K', 'A', 'Y', 'Y', 'A', 'K'}};
		assertTrue(Kayak.containsKayak(testvert));
	}
	
	/**
	 * Find a kayak that goes from top left to bottom right diagonally
	 */
	@Test
	public void testTopLeftBottomRightDiagonalKayak() {
		char[][] testdiag = 
			   {{'A', 'K', 'A', 'Y', 'Y', 'Y', 'A', 'K', 'K', 'K'},
				{'K', 'K', 'K', 'Y', 'K', 'A', 'A', 'A', 'K', 'Y'},
				{'K', 'A', 'K', 'K', 'A', 'A', 'K', 'Y', 'Y', 'Y'},
				{'Y', 'K', 'Y', 'Y', 'A', 'A', 'K', 'K', 'Y', 'A'},
				{'Y', 'K', 'A', 'K', 'K', 'Y', 'A', 'A', 'K', 'A'},
				{'A', 'Y', 'Y', 'Y', 'K', 'A', 'A', 'Y', 'Y', 'K'},
				{'Y', 'Y', 'A', 'A', 'A', 'A', 'Y', 'Y', 'A', 'K'},
				{'A', 'A', 'K', 'Y', 'A', 'K', 'Y', 'Y', 'Y', 'Y'},
				{'Y', 'Y', 'K', 'A', 'K', 'K', 'K', 'Y', 'Y', 'A'},
				{'A', 'A', 'K', 'K', 'K', 'A', 'Y', 'Y', 'A', 'K'}};
		assertTrue(Kayak.containsKayak(testdiag));
	}
	
	/**
	 * Find a kayak that goes from top right to bottom left diagonally
	 */
	@Test
	public void testTopRightBottomLeftDiagonalKayak() {
		char[][] testdiag2 = 
			   {{'A', 'K', 'A', 'Y', 'Y', 'Y', 'A', 'K', 'K', 'K'},
				{'K', 'K', 'K', 'Y', 'K', 'A', 'A', 'A', 'K', 'Y'},
				{'K', 'A', 'K', 'K', 'A', 'A', 'K', 'Y', 'Y', 'Y'},
				{'Y', 'K', 'Y', 'Y', 'A', 'A', 'K', 'K', 'Y', 'A'},
				{'Y', 'K', 'K', 'K', 'Y', 'Y', 'A', 'A', 'K', 'A'},
				{'A', 'Y', 'Y', 'A', 'K', 'A', 'A', 'Y', 'Y', 'K'},
				{'Y', 'Y', 'K', 'A', 'A', 'A', 'Y', 'Y', 'A', 'K'},
				{'A', 'A', 'K', 'Y', 'A', 'A', 'Y', 'Y', 'Y', 'Y'},
				{'Y', 'Y', 'K', 'A', 'K', 'K', 'K', 'Y', 'Y', 'A'},
				{'A', 'A', 'K', 'K', 'K', 'A', 'Y', 'Y', 'A', 'K'}};
		assertTrue(Kayak.containsKayak(testdiag2));
	}

}