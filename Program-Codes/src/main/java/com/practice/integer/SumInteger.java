/**
 * 
 */
package com.practice.integer;

/**
 * Sum of Integers
 * 
 * @author Somendu Maiti
 *
 * @since 14-Jun-2023
 */
public class SumInteger {

	public static void main(String[] args) throws IntegerAboveNineException {

		String[] stringArray = new String[] { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
				"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen" };

		SumInteger sumInteger = new SumInteger();
		int a = 7;
		int b = 2;
		int sum = 0;

		if (a > 9 || a < 1 || b > 9 || b < 1)
			throw new IntegerAboveNineException("Please Enter Digits between 1 and 9 Only");

		sum = sumInteger.sum(a, b);

		System.out
				.println("Sum of " + stringArray[a - 1] + " and " + stringArray[b - 1] + " is " + stringArray[sum - 1]);

	}

	public int sum(int a, int b) {
		int sum = a + b;
		return sum;
	}

}
