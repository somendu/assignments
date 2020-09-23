/**
 * 
 */
package com.assignments.stream.udemy.impdec;

import java.util.stream.IntStream;

/**
 * @author Somendu
 *
 * @since 19-Sep-2020
 */
public class ImpVsDec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Imperative - How Style of Programming
		 * 
		 */

		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			sum += i;
		}

		System.out.println("Sum Using Imperative: " + sum);

		/**
		 * Declarative - What Style of Programming
		 * 
		 */

		sum = IntStream.rangeClosed(0, 100).parallel().sum();

		System.out.println("Sum Using Declarative: " + sum);

	}

}
