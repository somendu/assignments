package com.assignments.self;

import java.util.ArrayList;
import java.util.List;

public class DuplicateFinder {

	static int[] findDuplicates(int[] arr1, int[] arr2) {
		// your code goes here

		// Declare a list that will later turn out to be array
		List<Integer> changedList = new ArrayList<Integer>();

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					changedList.add(arr1[i]);
				}
			}
		}

		// Sol 1
		// Put all integers in 1 List
		// Compare within the single Arraylist
		// if duplicate not found
		// create new array List and return as int[]

		// Sol 2
		// Create a hashmap
		// put (key, value)
		// arr1[0] = 1

		// put (0, 1)
		// create the map

		// traverse through the map to finds duploicate
		// if duplicate not found
		// create new array List and return as int[]

		int[] changedListArray = new int[changedList.size()];

		for (int count = 0; count < changedListArray.length; count++) {
			changedListArray[count] = changedList.get(count);
		}

		return changedListArray;
	}

	public static void main(String[] args) {

		// This is the case when array size are equal
		// O( X * N)

		// O (M * N )

		// Using hashmap
		// O[M + N]
	}

}