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
	 * Supports multiple custom delimiters of any length. Numbers larger than 1000 are ignored.
	 * Throws an exception if any negative numbers are found.
	 * 
	 * @param numbers a string containing numbers separated by commas or newline(e.g., "1,\n2,3")
	 * @return the sum of the numbers in the string, or 0 if the string is empty
	 * @throws IllegalArgumentException if the string contains negative numbers
	 */
	public int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}

		// Define default delimiter for commas and newlines
		String delimiter = "[,\n]";
		String numPart = numbers; // Part of the string that contains the numbers

		// Check if a custom delimiter is specified
		if (numbers.startsWith("//")) {
			int newlineIndex = numbers.indexOf("\n");
			String delimiterPart = numbers.substring(2, newlineIndex);
			numPart = numbers.substring(newlineIndex + 1);

			// Handle multiple delimiters in the format //[delim1][delim2]...
			Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(delimiterPart);
			StringBuilder delimiterRegex = new StringBuilder();
			while (matcher.find()) {
				if (delimiterRegex.length() > 0) {
					delimiterRegex.append("|");
				}
				delimiterRegex.append(Pattern.quote(matcher.group(1)));
			}

			// If there are no delimiters in square brackets, it's a single character
			// delimiter
			if (delimiterRegex.length() == 0) {
				delimiter = Pattern.quote(delimiterPart);
			} else {
				delimiter = delimiterRegex.toString();
			}
		}

		// Split the string by the given delimiter(s)
		String[] numberArray = numPart.split(delimiter);
		int sum = 0;
		List<Integer> negativeNumbers = new ArrayList<>();

		// Iterate through the split string and sum up the numbers
		for (String num : numberArray) {
			if (num.trim().isEmpty()) {
				continue;
			}

			int parsedNum = Integer.parseInt(num.trim());

			// Check for negative numbers and store them
			if (parsedNum < 0) {
				negativeNumbers.add(parsedNum);
			}

			// Ignore numbers greater than 1000
			if (parsedNum <= 1000) {
				sum += parsedNum;
			}
		}

		// If there are any negative numbers, throw an exception
		if (!negativeNumbers.isEmpty()) {
			throw new IllegalArgumentException("negative numbers not allowed: " + negativeNumbers);
		}

		return sum;
	}
}
