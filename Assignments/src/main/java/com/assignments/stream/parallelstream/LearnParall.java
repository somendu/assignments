/**
 * 
 */
package com.assignments.stream.parallelstream;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Somendu
 *
 * @since 15-Sep-2020
 */
public class LearnParall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism()); // 3

		Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream()
				.filter(s -> {
					System.out.format("filter: %s [%s]\n", s,
							Thread.currentThread().getName());
					return true;
				}).map(s -> {
					System.out.format("map: %s [%s]\n", s,
							Thread.currentThread().getName());
					return s.toUpperCase();
				}).sorted((s1, s2) -> {
					System.out.format("sort : %s <> %s [%s]\n", s1, s2,
							Thread.currentThread().getName());
					return s1.compareTo(s2);
				})

				.forEach(s -> System.out.format("forEach: %s [%s]\n", s,
						Thread.currentThread().getName()));
	}

}
