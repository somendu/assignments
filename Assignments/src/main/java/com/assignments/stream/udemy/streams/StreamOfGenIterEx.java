/**
 * 
 */
package com.assignments.stream.udemy.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Somendu
 *
 * @since 30-Sep-2020
 */
public class StreamOfGenIterEx {

	public static void main(String[] args) {

		Stream<String> stringStream = Stream.of("Som", "Maiti", "Data");

		stringStream.forEach(System.out::println);

		Stream.iterate(1, x -> x * 2).limit(10).forEach(System.out::println);

		System.out.println("Random Int Below ");

		Supplier<Integer> integerSupplier = new Random()::nextInt;
		Stream.generate(integerSupplier).limit(5).forEach(System.out::println);

	}

}
