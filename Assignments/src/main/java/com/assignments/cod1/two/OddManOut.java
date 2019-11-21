/**
 * 
 */
package com.assignments.cod1.two;

/**
 * @author somendu
 *
 */
public class OddManOut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int A[] = { 3, 5, 7, 3, 9, 5, 9 };
		System.out.println(getOddMan(A));

	}

	private static int getOddMan(int[] a) {

		int oddMan = 0;

		for (int count = 0; count < a.length; count++) {

			oddMan = oddMan ^ a[count];
		}

		return oddMan;
	}

}
