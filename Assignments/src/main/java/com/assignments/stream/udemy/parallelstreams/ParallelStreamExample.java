/**
 * 
 */
package com.assignments.stream.udemy.parallelstreams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * @author Somendu
 *
 * @since 02-Oct-2020
 */
public class ParallelStreamExample {

	public static long checkPerformance(Supplier<Integer> supplier,
			int numberOfTimes) {

		long startTime = System.currentTimeMillis();

		for (int i = 0; i <= numberOfTimes; i++) {
			supplier.get();
		}
		long endTime = System.currentTimeMillis();

		return endTime - startTime;
	}

	public static int sum_sequential_stream() {

		return IntStream.rangeClosed(1, 100000).sum();

	}

	public static int sum_parallel_stream() {

		return IntStream.rangeClosed(1, 100000).parallel().sum();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(Runtime.getRuntime().availableProcessors());

		System.out.println(
				"sequential call performance time  : " + checkPerformance(
						ParallelStreamExample::sum_sequential_stream, 20));
		System.out
				.println("parallel call performance time : " + checkPerformance(
						ParallelStreamExample::sum_parallel_stream, 20));

	}

}
