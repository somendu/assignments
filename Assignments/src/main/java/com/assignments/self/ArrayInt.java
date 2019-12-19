/**
 * 
 */
package com.assignments.self;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author somendu
 *
 */
public class ArrayInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] intArray = { 2, 6, 9 };

		System.out.println(Arrays.toString(changeIntArray(intArray)));

	}

	private static int[] changeIntArray(int[] intArray) {

		List<Integer> changedList = new LinkedList<Integer>();

		for (int innerInt : intArray) {

			int changeInt = innerInt + 1;

			changedList.add(changeInt);
		}

		Object[] changedObjectArray = (Object[]) changedList.toArray();

		int[] changedArray = new int[changedObjectArray.length];

		for (int counter = 0; counter < changedArray.length; counter++) {
			changedArray[counter] = (Integer) (changedObjectArray[counter]);
		}

		return changedArray;
	}

}
