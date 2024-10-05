package com.stringcalculator;


/**
 * The StringCalculator class provides a method to add numbers from a
 * comma-separated string. It supports the following cases:
 * - If the string is empty, it returns 0.
 * - If the string contains one or more numbers, it returns the sum of those numbers.
 */
public class StringCalculator {

	  /**
     * Adds numbers from a comma-separated string.
     * 
     * @param numbers a string containing numbers separated by commas (e.g., "1,2,3")
     * @return the sum of the numbers in the string, or 0 if the string is empty
     */
		public int add(String numbers) {
			if (numbers.isEmpty()) {
				return 0;
			}
			String[] numbersArray = numbers.split(",");
			int sumOfNumbers = 0;
			for (String number : numbersArray) {
				sumOfNumbers += Integer.parseInt(number);
			}
			return sumOfNumbers;
		}

}
