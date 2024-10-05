package com.stringcalculator;


/**
 * The StringCalculator class provides a method to add numbers from a
 * comma-separated string. It supports the following cases:
 * - If the string is empty, it returns 0.
 * - If the string contains one or more numbers, it returns the sum of those numbers.
 */
public class StringCalculator {

	  /**
     * Adds numbers from a comma and new line separated string.
     * 
     * @param numbers a string containing numbers separated by commas or new line(e.g., "1,\n2,3")
     * @return the sum of the numbers in the string, or 0 if the string is empty
     */
		public int add(String numbers) {
			if (numbers.isEmpty()) {
				return 0;
			}
			
			// Split the string by commas or new lines
			String[] numbersArray = numbers.split("[,\n]");
			int sumOfNumbers = 0;
			
			// Loop through each number, trim whitespace, and add to sum
			for (String number : numbersArray) {
				sumOfNumbers += Integer.parseInt(number.trim());//trim any trailing whitespace
			}
			return sumOfNumbers; // Return the total sum of the numbers
		}

}
