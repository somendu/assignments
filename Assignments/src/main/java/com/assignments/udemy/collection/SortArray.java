/**
 * 
 */
package com.assignments.udemy.collection;

import java.util.Arrays;

/**
 * @author Somendu
 *
 * @since 08-Sep-2020
 */
public class SortArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		char[] charArray = { 'f', 'a', 'p', 'e', 'm' };

		Arrays.parallelSort(charArray);

		int mLocation = 0;
		mLocation = Arrays.binarySearch(charArray, 'm');
		System.out.println(charArray);

		System.out.println(mLocation);

	}

}
