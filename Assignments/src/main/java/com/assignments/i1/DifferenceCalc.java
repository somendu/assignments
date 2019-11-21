/**
 * 
 */
package com.assignments.i1;

import java.util.HashMap;

/**
 * @author somendu
 *
 */
public class DifferenceCalc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] A = { 4, 6, 2, 2, 6, 6, 1 };

		System.out.println(getMaximum(A));

	}

	public static int getMaximum(int[] A) {

		int max = 0;

		HashMap<Integer, int[]> hm = new HashMap<Integer, int[]>();

		for (int counter = 0; counter < A.length; counter++) {

			if (!hm.containsKey(A[counter])) {

				hm.put(A[counter], new int[] { counter, -1 });

			} else {

				int[] val = (int[]) hm.get(A[counter]);

				val[1] = counter;

				hm.put(A[counter], val);

				if (max < val[1] - val[0]) {

					max = val[1] - val[0];
				}
			}

		}

		return max;

	}

}
