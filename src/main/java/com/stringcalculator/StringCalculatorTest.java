package com.stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	/*
	 * first test for empty string
	 */
	@Test
	public void testEmptyString() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(0,stringCalculator.add(""));
	}
	
}
