package com.assignments.self.arrays;

public class Traverse {

	// Function to check the array for elements in
	// given range
	public static boolean check_elements(int arr[], int alpha) {
		// Range is the no. of elements that are
		// to be checked
//		int range = B - A;

		// Traversing the array
		for (int i = 0; i < 360; i++) {

			// If an element is in range
			if (Math.abs(arr[i]) == alpha) {

				int z = Math.abs(arr[i]);
				if (arr[z] > 0) {
					arr[z] = arr[z] * -1;
				}
			}
		}

		// Checking whether elements in range 0-range
		// are negative
		int count = 0;

		for (int i = 0; i <= alpha && i < 360; i++) {

			// Element from range is missing from array
			if (arr[i] > 0)
				return false;
			else
				count++;
		}

		if (count != (alpha + 1))
			return false;

		// All range elements are present
		return true;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		// Defining Array and size
		int arr[] = { 18, 43, 15, 220, 109, 120, 320 };

		// True denotes all elements were present
		if (check_elements(arr, 30))
			System.out.println("Yes");

		// False denotes any element was not present
		else
			System.out.println("No");
	}

}
