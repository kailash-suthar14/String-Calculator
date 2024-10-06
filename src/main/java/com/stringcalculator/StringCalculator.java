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

	    // Check for custom delimiter header and strip it (but ignore delimiters)
	    if (numbers.startsWith("//")) {
	        int newlineIndex = numbers.indexOf("\n");
	        numbers = numbers.substring(newlineIndex + 1);  // Ignore the delimiters part and get numbers
	    }

	    // Remove all non-numeric characters but keep negative sign and digits
	    String sanitizedNumbers = numbers.replaceAll("[^\\d-]+", " "); // Replace any non-digit with space

	    String[] numbersArray = sanitizedNumbers.trim().split("\\s+");  // Split by whitespace
	    int sumOfNumbers = 0;

	    List<Integer> negativeNumbers = new ArrayList<>();  // List to store negative numbers

	    // Loop through each number and sum them up
	    for (String numStr : numbersArray) {
	        if (numStr.isEmpty()) {
	            continue;
	        }

	        int parsedNum = Integer.parseInt(numStr);

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

	    return sumOfNumbers;
	}

}
