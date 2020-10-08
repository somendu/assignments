/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.Comparator;

/**
 * @author Somendu
 *
 * @since 22-Sep-2020
 */
public class ComparatorLambdaExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Before java 8
		 */
		Comparator<Integer> comparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o1.compareTo(o2);

			}

		};

		System.out.println(
				"Result of comparator is : " + comparator.compare(2, 2));

		/**
		 * Java 8
		 */

		Comparator<Integer> compareLambda = (Integer a, Integer b) -> a
				.compareTo(b);

		System.out.println("Result of comparatorLambda is : "
				+ compareLambda.compare(2, 7));

		Comparator<Integer> compareLambda1 = (a, b) -> a.compareTo(b);

		System.out.println("Result of compareLambda1 is : "
				+ compareLambda1.compare(2, 7));
	}

}
