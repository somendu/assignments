/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.function.Function;

/**
 * @author Somendu
 *
 * @since 24-Sep-2020
 */
public class FunctionaExample {

	static Function<String, String> function = (name) -> name.toLowerCase();

	static Function<String, String> functionAddSome = (name) -> name
			.toLowerCase().concat("Adding");

	public static void main(String[] args) {

		System.out.println("function here : " + function.apply("TEST"));

		System.out.println("functionAddSome here : "
				+ function.andThen(functionAddSome).apply("FAE"));

		System.out.println("functionAddSome here : "
				+ function.compose(functionAddSome).apply("NOW"));
	}

}
