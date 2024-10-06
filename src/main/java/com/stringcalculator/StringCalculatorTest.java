package com.stringcalculator;

import static org.junit.Assert.assertThrows;
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

	/*
	 * Test the add method with a string containing numbers separated by new lines
	 * and commas
	 */	
	@Test
	public void testNewLineBetweenNumbersReturnsTheirSum() {
	    assertEquals(6, stringCalculator.add("1\n2,3"));
	}
	
	/*
	 * Test the add method with a string containing different delimiters example : //;\n1;2
	 */	
	@Test
	public void testCustomDelimiter() {
	    assertEquals(3, stringCalculator.add("//;\n1;2"));
	}
	
	/*
	 * Test for negative numbers and if negative numbers are present then throw the exception
	 */
	@Test
	public void testNegativeNumbersThrowsException() {
	    // Use assertThrows to check if an exception is thrown
	    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
	    	stringCalculator.add("1,-2,3,-4");
	    });

	    // Check the exception message contains the negative numbers
	    assertEquals("negative numbers not allowed: [-2, -4]", exception.getMessage());
	}
	
	/*
	 * Numbers greater than 1000 should be ignored, so "2,1001" should return 2
	 */
	@Test
	public void testIgnoreNumbersGreaterThan1000() {
	    StringCalculator calculator = new StringCalculator();
	    assertEquals(2, calculator.add("2,1001"));
	}
}
