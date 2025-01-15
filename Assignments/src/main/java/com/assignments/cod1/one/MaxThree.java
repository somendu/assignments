/**
 * 
 */
package com.assignments.cod1.one;

/**
 * @author somendu
 *
 */
public class MaxThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = 4;
		int b = 7;
		int c = 6;

		int max = 0;

		max = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);

		System.out.println("Max of Three : " + max);

	}

}
