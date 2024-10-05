package com.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	StringCalculator stringCalculator = new StringCalculator();
	
	/**
	 * This test checks that when an empty string is passed to the add() 
	 * method of the StringCalculator class, it correctly returns 0.
	 * 
	 * An empty string represents no numbers, so the expected result is 0.
	 */
	@Test
	public void testEmptyString() {
		assertEquals(0,stringCalculator.add(""));
	}
	
	/**
	 * This test verifies that when a single number is passed as a string 
	 * to the add() method of the StringCalculator class, it correctly 
	 * returns the integer value of that number.
	 * 
	 * For example, when the input is "1", the add() method should return 1.
	 */
	@Test
	public void testSingleNumberReturnsTheNumber() {
	    assertEquals(1, stringCalculator.add("1"));
	}

	/**
	 * Tests that the add method correctly returns the sum of two comma-separated numbers.
	 * Specifically, this test checks if the input "1,2" correctly returns the sum 3.
	 */
	@Test
	public void testTwoNumbersReturnsTheirSum() {
	    assertEquals(6, stringCalculator.add("1,5"));
	}

	/**
	 * Tests that the add method correctly returns the sum of two comma-separated numbers.
	 * Specifically, this test checks if the input "1,5,8" correctly returns the sum 14.
	 */
	@Test
	public void testThreeNumbersReturnsTheirSum() {
	    assertEquals(14, stringCalculator.add("1,5,8"));
	}

	
}
