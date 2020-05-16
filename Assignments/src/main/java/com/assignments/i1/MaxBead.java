package com.assignments.i1;

/**
 * @author somendu
 *
 */
public class MaxBead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MaxBead solutionThree = new MaxBead();

		int[] A = { 5, 4, 0, 3, 1, 6, 2 };

		System.out.println(solutionThree.solution(A));
	}

	public int solution(int[] A) {

		int out = 0;

		int currVal = 0;

		int nextVal = 0;

		if (A.length == 0) {
			return 0;
		}

		StringBuilder key = new StringBuilder();

		for (int i = 0; i < A.length; i++) {

			if (i == 0) {

				key = new StringBuilder();

				key.append(A[0]);

				nextVal = A[0];

				A[0] = -1;

				// out = outPut(nextVal, currVal, key, A);
				while ((nextVal > 0) && !key.toString().contains(Integer.toString(A[nextVal]))) {

					key.append(A[nextVal]);

					currVal = A[nextVal];

					A[nextVal] = -1;

					nextVal = currVal;

					if (out < key.length()) {

						out = key.length();

					}
				}
			}
			if (A[i] > 0) {

				key = new StringBuilder();

				key.append(A[i]);

				nextVal = A[i];

				A[i] = -1;

				// out = outPut(nextVal, currVal, key, A);
				while ((nextVal > 0) && !key.toString().contains(Integer.toString(A[nextVal]))) {

					key.append(A[nextVal]);

					currVal = A[nextVal];

					A[nextVal] = -1;

					nextVal = currVal;

					if (out < key.length()) {

						out = key.length();

					}
				}
			}
		}

		return out;
	}

	private int outPut(int nextVal, int currVal, StringBuilder key, int[] A) {

		int out = 0;
		while ((nextVal > 0) && !key.toString().contains(Integer.toString(A[nextVal]))) {
			key.append(A[nextVal]);
			currVal = A[nextVal];
			A[nextVal] = -1;
			nextVal = currVal;
			if (out < key.length()) {
				out = key.length();
			}
		}
		return out;
	}

}
