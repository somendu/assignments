/**
 * 
 */
package com.assignments.stream.udemy.numericstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Somendu
 *
 * @since 30-Sep-2020
 */
public class NumericStreamsExample {

	public static int sumOfNumbers(List<Integer> integerList) {

		return integerList.stream().reduce(0, (a, b) -> a + b);
	}

	public static int sumOfNumbersIntStream() {

		// int sum = IntStream.of(1, 2, 3, 4, 5, 6).reduce(0, (a, b) -> a + b);

		int sum = IntStream.rangeClosed(1, 6).sum();

		return sum;
	}

	public static void main(String[] args) {

		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);

		System.out.println("Sum of N Numbers: " + sumOfNumbers(integerList));

		System.out.println(
				"Sum of N Numbers using IntStream: " + sumOfNumbersIntStream());

	}

}
