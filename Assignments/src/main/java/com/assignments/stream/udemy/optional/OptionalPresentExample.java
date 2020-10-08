/**
 * 
 */
package com.assignments.stream.udemy.optional;

import java.util.Optional;

/**
 * @author Somendu
 *
 * @since 03-Oct-2020
 */
public class OptionalPresentExample {

	public static void main(String[] args) {

		// is Present
		Optional<String> optional = Optional.ofNullable("hello Optional");
		System.out.println(optional.isPresent());

		// if Present
		optional.ifPresent(s -> System.out.println(s));

	}

}
