/**
 * 
 */
package com.assignments.stream.udemy.lambdas;

import java.util.function.Consumer;

/**
 * @author Somendu
 *
 * @since 28-Sep-2020
 */
public class LambdaVariable {

	public static void main(String[] args) {

		int i = 0;

		Consumer<Integer> cons = (i1) -> {
			System.out.println(i1.intValue());

		};

		cons.accept(4);
	}

}
