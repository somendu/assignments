/**
 * 
 */
package com.assignments.stream.udemy.numericstreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author Somendu
 *
 * @since 01-Oct-2020
 */
public class NumericStreamRangeEx {

	public static void main(String[] args) {

		System.out.println(
				"IntStream Range Count : " + IntStream.range(1, 50).count());
		IntStream.range(1, 50)
				.forEach((value) -> System.out.print(value + ","));

		System.out.println();

		System.out.println("IntStream Range Closed Count: "
				+ IntStream.rangeClosed(1, 50).count());
		IntStream.rangeClosed(1, 50)
				.forEach((value) -> System.out.print(value + ","));

		System.out.println();

		System.out.println(
				"LongStream Range Count : " + LongStream.range(1, 50).count());
		LongStream.range(1, 50)
				.forEach((value) -> System.out.print(value + ","));

		System.out.println();

		System.out.println("LongStream Range Closed Count: "
				+ LongStream.rangeClosed(1, 50).count());
		LongStream.rangeClosed(1, 50)
				.forEach((value) -> System.out.print(value + ","));

		System.out.println();

		System.out.println("DoubleStream Range Count : "
				+ LongStream.range(1, 50).asDoubleStream().count());
		LongStream.range(1, 50).asDoubleStream()
				.forEach((value) -> System.out.print(value + ","));

		System.out.println();

		System.out.println("DoubleStream Range Closed Count: "
				+ LongStream.rangeClosed(1, 50).asDoubleStream().count());
		LongStream.rangeClosed(1, 50).asDoubleStream()
				.forEach((value) -> System.out.print(value + ","));

	}

}
