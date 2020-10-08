/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.function.Predicate;

/**
 * @author Somendu
 *
 * @since 23-Sep-2020
 */
public class PredicateExample {

	static Predicate<Integer> intPredicate2 = (i) -> {
		return i % 2 == 0;
	};

	static Predicate<Integer> intPredicate5 = (i) -> {
		return i % 5 == 0;
	};

	public static void testPredicateAnd() {
		System.out.println("Predicate 'AND' result for 10 is : "
				+ intPredicate2.and(intPredicate5).test(10));
		System.out.println("Predicate 'AND' result for 9 is : "
				+ intPredicate2.and(intPredicate5).test(9));
	}

	public static void testPredicateOr() {
		System.out.println("Predicate 'OR' result for 10 is : "
				+ intPredicate2.or(intPredicate5).test(10));
		System.out.println("Predicate 'OR' result for 9 is : "
				+ intPredicate2.or(intPredicate5).test(8));
	}

	public static void testPredicateNegate() {
		System.out.println("Predicate 'NEGATE' result for 10 is : "
				+ intPredicate2.or(intPredicate5).negate().test(10));
		System.out.println("Predicate 'NEGATE' result for 9 is : "
				+ intPredicate2.or(intPredicate5).negate().test(8));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// System.out.println(intPredicate2.test(4));
		testPredicateAnd();
		testPredicateOr();
		testPredicateNegate();
	}

}
