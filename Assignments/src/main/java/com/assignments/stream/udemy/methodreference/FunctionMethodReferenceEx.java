/**
 * 
 */
package com.assignments.stream.udemy.methodreference;

import java.util.function.Function;

/**
 * @author Somendu
 *
 * @since 27-Sep-2020
 */
public class FunctionMethodReferenceEx {

	static Function<String, String> toUpperCaseLambda = (s) -> s.toUpperCase();

	static Function<String, String> toUpperCaseMethodReference = String::toUpperCase;

	public static void main(String[] args) {

		System.out.println(toUpperCaseLambda.apply("data"));

		System.out.println(toUpperCaseMethodReference.apply("data"));

	}

}
