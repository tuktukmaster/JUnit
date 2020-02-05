import static org.junit.Assert.*;

import imports.org.junit.Test;

/**
 * Quick and dirty tests of Kayak finder program
 * Not an exhaustive set of tests, but a good start
 * @author Nathan Gossett, Berke Lunstad
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
	 * Make sure it fails on jagged arrays. Dr Gosset hasn't responded so maybe they are ok?
	 */
	@Test
	public void jaggedArray() {
		char[][] testJagged = {{'A', 'K', 'A', 'Y', 'Y', 'Y', 'A', 'K', 'K', 'K'},
				{'K', 'K', 'K', 'Y', 'K', 'A', 'A', 'A', 'K', 'Y','e'},
				{'K', 'A', 'K', 'K', 'A', 'K', 'Y', 'Y', 'Y'},
				{'Y', 'K', 'Y', 'Y', 'A', 'A', 'K', 'K', 'Y', 'A'},
				{'Y', 'K', 'K', 'K', 'K', 'Y', 'A', 'A', 'K'},
				{'A', 'Y', 'Y', 'Y', 'K', 'A', 'A', 'Y', 'Y', 'K'},
				{'Y', 'Y', 'A', 'A', 'A', 'A', 'Y', 'Y', 'A', 'K'},
				{'A', 'A', 'K', 'Y', 'A', 'A', 'Y', 'Y', 'Y', 'Y'},
				{'Y', 'Y', 'K', 'A', 'K', 'K', 'K', 'Y', 'Y', 'A'},
				{'A', 'K', 'A', 'Y', 'A', 'K', 'Y', 'Y', 'A', 'K'}};
		assertFalse(Kayak.containsKayak(testJagged));
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