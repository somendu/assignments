/**
 * 
 */
package com.assignments.self.arrays;

/**
 * @author somendu
 *
 */
public class ArrayPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Insert element at any given position and shift all next element in array

		// Declare an array of fixed size
		int[] intArray = new int[5];

		intArray[0] = 2;
		intArray[1] = 4;
		intArray[2] = 5;
		intArray[3] = 8;
		intArray[4] = 9;

		// Call method to insert element in particular position
		intArray = insertElement(intArray, 2, 10);

		// Printing
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}

	}

	/**
	 * Method for taking the array and creating new array of size+1
	 * 
	 * @param intArray
	 * @param position
	 * @param element
	 * @return
	 */
	private static int[] insertElement(int[] intArray, int position, int element) {

		// Declare size of array as +1
		int[] modArray = new int[intArray.length + 1];

		// Insert first elements
		for (int innnerCount = 0; innnerCount < position; innnerCount++) {
			modArray[innnerCount] = intArray[innnerCount];
		}

		// Remaining element looop
		for (int remainCount = position + 1; remainCount < modArray.length; remainCount++) {

			// Take the position of new elemen
			modArray[position] = element;

			// insert remaning elements
			modArray[remainCount] = intArray[remainCount - 1];
		}

		return modArray;

	}

}
