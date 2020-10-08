/**
 * 
 */
package com.assignments.stream.udemy.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Somendu
 *
 * @since 30-Sep-2020
 */
public class StreamLimitSkipEx {

	public static Optional<Integer> limitInt(List<Integer> integers) {
		return integers.stream().limit(3).reduce((a, b) -> a + b);
	}

	public static Optional<Integer> skipInt(List<Integer> integers) {
		return integers.stream().skip(3).reduce((a, b) -> a + b);
	}

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(3, 5, 1, 4, 8);

		Optional<Integer> intLimitOptional = limitInt(intList);

		if (intLimitOptional.isPresent()) {
			System.out.println(intLimitOptional.get());
		} else {
			System.out.println("No input passed");
		}

		Optional<Integer> intSkipOptional = skipInt(intList);

		if (intSkipOptional.isPresent()) {
			System.out.println(intSkipOptional.get());
		} else {
			System.out.println("No input passed");
		}
	}

}
