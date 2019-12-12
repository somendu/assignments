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

		// Printing before
		System.out.println("Before");
		for (int counter = 0; counter < intArray.length; counter++) {

			System.out.println(intArray[counter]);
		}

		System.out.println("");

		// Call method to insert element in particular position
		intArray = insertElement(intArray, 2, 10);

		// Printing After
		System.out.println("After");
		for (int counter = 0; counter < intArray.length; counter++) {

			System.out.println(intArray[counter]);
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
		// intArray = new int[intArray.length + 1];

		// Insert first elements
//		for (int innnerCount = 0; innnerCount < position; innnerCount++) {
//			modArray[innnerCount] = intArray[innnerCount];
//		}

		// Remaining element loop
		for (int remainCount = position; remainCount <= intArray.length; remainCount++) {

			// Take the position of new element
			intArray[position] = element;

			// insert remaining elements
			intArray[remainCount] = intArray[remainCount + 1];
		}

		return intArray;

	}

}
