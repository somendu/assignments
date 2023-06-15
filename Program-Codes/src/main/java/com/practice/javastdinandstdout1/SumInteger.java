/**
 * 
 */
package com.practice.javastdinandstdout1;

/**
 * Sum of Integers
 * 
 * @author Somendu Maiti
 *
 * @since 14-Jun-2023
 */
public class SumInteger {

	public static void main(String[] args) {

		String[] stringArray = new String[] { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
				"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen" };

		SumInteger sumInteger = new SumInteger();
		int a = 4;
		int b = 5;
		int sum = sumInteger.sum(a, b);

		System.out
				.println("Sum of " + stringArray[a - 1] + " and " + stringArray[b - 1] + " is " + stringArray[sum - 1]);

	}

	public int sum(int a, int b) {
		int sum = a + b;
		return sum;
	}

}
