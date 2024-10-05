package com.stringcalculator;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers.isEmpty())
			return 0;

		return Integer.parseInt(numbers); // Handles single number input
	}

}
