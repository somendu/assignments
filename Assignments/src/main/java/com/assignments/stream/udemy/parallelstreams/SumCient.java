/**
 * 
 */
package com.assignments.stream.udemy.parallelstreams;

import java.util.stream.IntStream;

/**
 * @author Somendu
 *
 * @since 02-Oct-2020
 */
public class SumCient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Sum sum = new Sum();

		IntStream.rangeClosed(1, 10000).parallel().forEach(sum::printSm);

		// 26069743
		// 31270059

		System.out.println(sum.getTotal());
	}

}
