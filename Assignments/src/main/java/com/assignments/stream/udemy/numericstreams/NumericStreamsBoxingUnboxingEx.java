/**
 * 
 */
package com.assignments.stream.udemy.numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Somendu
 *
 * @since 01-Oct-2020
 */
public class NumericStreamsBoxingUnboxingEx {

	public static List<Integer> boxing() {

		return IntStream.rangeClosed(1, 10).boxed()
				.collect(Collectors.toList());
	}

	public static int unBoxing(List<Integer> integerList) {

		return integerList.stream().mapToInt(Integer::intValue).sum();
	}

	public static void main(String[] args) {

		System.out.println("List of Integers Boxing: " + boxing());

		List<Integer> integerList = boxing();
		System.out
				.println("Sum of Integers Unboxing: " + unBoxing(integerList));

	}

}
