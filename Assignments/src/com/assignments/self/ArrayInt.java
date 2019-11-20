/**
 * 
 */
package com.assignments.self;

import java.util.ArrayList;
import java.util.Arrays;
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

		int size = intArray.length;

		List<Integer> changedList = new ArrayList<Integer>();

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
