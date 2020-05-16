/**
 * 
 */
package com.assignments.cod1.two;

/**
 * @author somendu
 *
 */
public class RotationArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] A = { 3, 6, 7, 8, 7 };
		int K = 3;

		System.out.println(getRotationArray(A, K));

	}

	public static int[] getRotationArray(int[] A, int K) {

		int[] retArray = new int[A.length];

		while (K != 0) {
			K = K % A.length;

			for (int count = 0; count < A.length; count++) {

				int position = (count + K) % A[count];

				retArray[position] = A[count];
			}
		}

		return retArray;
	}

}