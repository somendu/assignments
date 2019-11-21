/**
 * 
 */
package com.assignments.self;

/**
 * @author somendu
 *
 */
public class MissingElem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] A = { 3, 2, 4, 6, 1, 8, 5 };

//		System.out.println("missingElementNew : " + missingElementNew(A));
		System.out.println("getMissingNumber : " + getMissingNumber(A));

	}

	public static int missingElement(int[] A) {

		int next = A.length + 1;

		System.out.println(next);

		int missingElem = ((next + 1) * next) / 2;

		System.out.println(missingElem);

		for (int arrayElem : A) {
			missingElem = missingElem - arrayElem;

			System.out.println("in the loop : " + missingElem);
		}

		return missingElem;
	}

	private static int getMissingNumber(int[] numbers) {

		int totalCount = numbers.length + 1;

		int expectedSum = totalCount * ((totalCount + 1) / 2);
		int actualSum = 0;
		for (int i : numbers) {
			actualSum += i;
		}
		return expectedSum - actualSum;
	}

	public static int missingElementNew(int[] A) {

		// Check size
		int size = A.length + 1;

		System.out.println(size);

		// Init missing element
		int missingElem = ((size + 1) * size);

		//
//		int product = 0;
		for (int arrayElem : A) {

			missingElem = missingElem - (arrayElem * 2);
		}

		missingElem = missingElem / 2;

		return missingElem;
	}

}
