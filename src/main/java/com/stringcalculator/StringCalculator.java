package com.stringcalculator;

import java.util.ArrayList;
import java.util.List;

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
			 String delimiter = "[,\n]"; // Default delimiters
		     String numPart = numbers;   // The part containing the numbers

			 // Check for custom delimiter
	        if (numbers.startsWith("//")) {
	            int delimiterIndex = numbers.indexOf("\n");
	            delimiter = numbers.substring(2, delimiterIndex);  // Extract custom delimiter
	            numPart = numbers.substring(delimiterIndex + 1);   // Extract the part after the custom delimiter
	        }

	        // Split the numbers by the determined delimiter
	        String[] numbersArray = numPart.split(delimiter);
	        int sumOfNumbers = 0;
			
	        List<Integer> negativeNumbers = new ArrayList<>();  // List to store negative numbers

	        // Loop through each number, trim whitespace, and add to sum, and throw exception for negative numbers
	        for (String number : numbersArray) {
	            int parsedNum = Integer.parseInt(number.trim());  // Parse and trim each number

	            // Check for negative numbers
	            if (parsedNum < 0) {
	                negativeNumbers.add(parsedNum);
	            }

	            // Ignore numbers greater than 1000
	            if (parsedNum <= 1000) {
	            	sumOfNumbers += parsedNum;
	            }
	        }

	        // If there are any negative numbers, throw an exception
	        if (!negativeNumbers.isEmpty()) {
	            throw new IllegalArgumentException("negative numbers not allowed: " + negativeNumbers);
	        }
			return sumOfNumbers; // Return the total sum of the numbers
		}

}
