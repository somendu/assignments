/**
 * 
 */
package com.assignments.stream.udemy.numericstreams;

import java.util.stream.IntStream;

/**
 * @author Somendu
 *
 * @since 01-Oct-2020
 */
public class NumericStreamAggregateExample {

	public static void main(String[] args) {

		int sum = IntStream.rangeClosed(1, 50).sum();

		System.out.println("Sum of 50 Numbers: " + sum);

		int max = IntStream.rangeClosed(1, 50).max().getAsInt();

		int min = IntStream.rangeClosed(1, 50).min().getAsInt();

		double average = IntStream.rangeClosed(1, 50).average().getAsDouble();

		System.out.println("Max: " + max + " " + " Min: " + min);

		System.out.println("Average : " + average);

	}

}
