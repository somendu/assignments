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
public class OptionalOfEmptyNullableEx {

	public static Optional<String> ofNullable() {

		Optional<String> stringOptional = Optional.ofNullable(null);

		return stringOptional;
	}

	public static Optional<String> of() {

		Optional<String> stringOptional = Optional.of(null);

		return stringOptional;
	}

	public static Optional<String> empty() {

		return Optional.empty();
	}

	public static void main(String[] args) {

		System.out.println(ofNullable().isPresent());
		// System.out.println(of().isPresent());

		System.out.println(empty().isPresent());
	}

}
