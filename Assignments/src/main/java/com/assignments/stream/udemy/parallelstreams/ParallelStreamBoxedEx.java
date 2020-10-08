/**
 * 
 */
package com.assignments.stream.udemy.parallelstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Somendu
 *
 * @since 02-Oct-2020
 */
public class ParallelStreamBoxedEx {

	public static int sequentialSum(List<Integer> integerList) {

		long startTime = System.currentTimeMillis();

		int sum = integerList.stream().reduce(0, (a, b) -> a + b);

		long duration = System.currentTimeMillis() - startTime;

		System.out.println("Sequential Stream Time: " + duration);
		return sum;
	}

	public static int parallelSum(List<Integer> integerList) {

		long startTime = System.currentTimeMillis();

		int sum = integerList.parallelStream().reduce(0, (a, b) -> a + b);

		long duration = System.currentTimeMillis() - startTime;

		System.out.println("Parallel Stream Time: " + duration);
		return sum;
	}

	public static void main(String[] args) {

		List<Integer> integerList = IntStream.rangeClosed(1, 10000).boxed()
				.collect(Collectors.toList());

		sequentialSum(integerList);

		parallelSum(integerList);
	}

}
