/**
 * 
 */
package com.assignments.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Somendu
 *
 * @since 10-Sep-2020
 */
public class StreamLearn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// List<String> stringList = Arrays.asList("som", "maitim", "somum", "abc",
		// "rahul", "style");
		List<String> stringTwoList = Arrays.asList("som", "maiti", "somu", "abc", "rahul", "style");

		List<String> stringList = Arrays.asList("som", "maiti", "somu", "abc", "rahul", "style");

		stringList.stream().filter(str -> str.startsWith("s")).map(String::toUpperCase).sorted()
				.forEach(System.out::println);

		List<String> m_endingList = stringList.stream().filter(str -> str.endsWith("m")).collect(Collectors.toList());

		List<String> m_endingList1 = stringList.stream().filter(str -> str.endsWith("m")).collect(Collectors.toList());

		// System.out.println(m_endingList);

		// stringList.stream().filter(str -> str.endsWith("m"))
		// .map(String::toUpperCase).forEach(System.out::println);

		// Stream.of("som", "maiti", "somu", "abc", "rahul",
		// "style").findFirst().ifPresent(System.out::println);

		// IntStream.range(3, 7).forEach(System.out::println);

		// Arrays.stream(new int[]{1, 2, 3, 4, 5})
		//
		// .map(n -> n)
		//
		// .min()
		//
		// .ifPresent(System.out::println);

		// long count = Stream.of(1, 2, 3, 4, 5)
		//
		// .map(n -> n)
		//
		// .count();
		//
		// System.out.println(count);

		Stream.of("a1", "a2", "a3", "a4", "a5", "a6").map(s -> s.substring(1)).mapToInt(Integer::parseInt)
				.forEach(System.out::println);

		// IntStream.range(1, 4).mapToObj(i -> "a" +
		// i).forEach(System.out::println);

		// Stream.of(1.0, 2.0, 3.0).mapToInt(Double::intValue)
		// .mapToObj(i -> "a" + i).forEach(System.out::println);

		long count = Stream.of(stringList, stringTwoList).count();

		System.out.println(count);

	}

}
