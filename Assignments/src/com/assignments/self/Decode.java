/**
 * 
 */
package com.assignments.self;

/**
 * @author somendu
 *
 */
public class Decode {

	static int decodeVariations(String S) {

		String[] sArray = S.split("");

		int length = sArray.length;

		// Store result
		int countArray[] = new int[length + 1];

		countArray[0] = 1;

		countArray[1] = 1;

		// Starts with 0 then should return 0
		if (Integer.parseInt(sArray[0]) == Integer.parseInt("0")) {
			return 0;
		}

		for (int i = 2; i <= length; i++) {
			countArray[i] = 0;

			// When last digit is not 0
			if (Integer.parseInt(sArray[i - 1]) > Integer.parseInt("0"))
				countArray[i] = countArray[i - 1];

			// Second last digit smaller than 2
			// Last digit smaller than 7
			if (Integer.parseInt(sArray[i - 2]) == Integer.parseInt("1")
					|| Integer.parseInt(sArray[i - 2]) == Integer.parseInt("2")
							&& Integer.parseInt(sArray[i - 1]) < Integer.parseInt("7"))
				countArray[i] += countArray[i - 2];
		}

		return countArray[length];

	}

	public static void main(String[] args) {
		System.out.println(decodeVariations("1262"));
	}

}
