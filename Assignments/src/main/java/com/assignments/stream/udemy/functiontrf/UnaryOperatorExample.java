/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.function.UnaryOperator;

/**
 * @author Somendu
 *
 * @since 26-Sep-2020
 */
public class UnaryOperatorExample {

	static UnaryOperator<String> unaryOperatorConcat = (s) -> s.concat(" Data");

	public static void main(String[] args) {

		System.out.println(unaryOperatorConcat.apply("Java"));
	}

}
