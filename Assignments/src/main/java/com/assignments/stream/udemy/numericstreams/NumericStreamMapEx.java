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
public class NumericStreamMapEx {

	public static List<Integer> mapToObj() {

		return IntStream.rangeClosed(1, 10).mapToObj(Integer::new)
				.collect(Collectors.toList());

		// return IntStream.rangeClosed(1, 10).mapToObj((i) -> {
		// return new Integer(i);
		// }).collect(Collectors.toList());

	}

	public static long mapToLong() {

		return IntStream.rangeClosed(1, 10).mapToLong((i) -> (i)).sum();

	}

	public static double mapToDouble() {

		return IntStream.rangeClosed(1, 10).mapToDouble((i) -> (i)).sum();

	}

	public static void main(String[] args) {

		System.out.println("Map to Obj : " + mapToObj());

		System.out.println("Map to Long : " + mapToLong());

		System.out.println("Map to DOuble : " + mapToDouble());
	}

}
