package com.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The StringCalculator class provides a method to add numbers from a
 * comma-separated string. It supports the following cases:
 * - If the string is empty, it returns 0.
 * - If the string contains one or more numbers, it returns the sum of those numbers.
 */
public class StringCalculator {

	  /**
     * Adds numbers from a string with custom or default delimiters.
     * Supports multiple custom delimiters of any length.
     * Numbers larger than 1000 are ignored.
     * Throws an exception if any negative numbers are found.
   
     * @param numbers a string containing numbers separated by commas or new line(e.g., "1,\n2,3")
     * @return the sum of the numbers in the string, or 0 if the string is empty
     * @throws IllegalArgumentException if the string contains negative numbers
     */
		public int add(String numbers) {
			if (numbers.isEmpty()) {
				return 0;
			}
			 String delimiter = "[,\n]"; // Default delimiters
		     String numPart = numbers;   // The part containing the numbers

		     // Check for custom delimiter(s) in the format //[…]\n
		        if (numbers.startsWith("//")) {
		            if (numbers.charAt(2) == '[') {
		                // Multiple or single custom delimiter in the form //[…]\n
		                Matcher matcher = Pattern.compile("//(\\[.*?\\])+\n(.*)").matcher(numbers);
		                if (matcher.matches()) {
		                    String delimiterPart = matcher.group(1);  // Extract delimiter section
		                    numPart = matcher.group(2);               // Numbers part

		                    // Build regex for multiple custom delimiters
		                    Matcher delimiterMatcher = Pattern.compile("\\[(.*?)\\]").matcher(delimiterPart);
		                    StringBuilder delimiterRegex = new StringBuilder();
		                    while (delimiterMatcher.find()) {
		                        if (delimiterRegex.length() > 0) {
		                            delimiterRegex.append("|");
		                        }
		                        delimiterRegex.append(Pattern.quote(delimiterMatcher.group(1)));
		                    }
		                    delimiter = delimiterRegex.toString();  // Combine all delimiters into one regex
		                }
		            } else {
		                // Single custom delimiter in the form //;\n
		                delimiter = Pattern.quote(numbers.substring(2, 3));  // Extract single delimiter
		                numPart = numbers.substring(4);                      // Part after delimiter
		            }
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
