/**
 * 
 */
package com.assignments.cod1.one;

/**
 * @author somendu
 *
 */
public class BinaryGap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(findBinaryGap(1041));

	}

	private static int findBinaryGap(int N) {

		int maxGap = 0;

		int binaryGap = -1;

		while (N != 0) {

			if ((N % 2) == 1) {

				if (maxGap < binaryGap) {

					maxGap = binaryGap;
				}

				binaryGap = 0;

			} else if (binaryGap != -1) {

				binaryGap++;
			}

			N = N / 2;
		}
		return maxGap;
	}

}
