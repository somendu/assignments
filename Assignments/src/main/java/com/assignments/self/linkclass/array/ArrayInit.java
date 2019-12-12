package com.assignments.self.linkclass.array;

import java.util.Arrays;

public class ArrayInit {

	public static void main(String[] args) {

		// Integer Array Declaration
		int[] nums;

		// Declare and Allocate array
		double[] otherNums = new double[5];

		// Allocate initialize
		String[] availPets = { "cat", "dog", "fish" };
		String[] unavlPets = { "bird", "rabbit", "hamster" };

		System.out.println(Arrays.toString(availPets));
		System.out.println(Arrays.toString(unavlPets));

		int indexOfAvl = 2;
		int indexOfUnAvl = 0;

		String availPet = availPets[indexOfAvl];
		String unAvailPet = unavlPets[indexOfUnAvl];

		availPets[indexOfAvl] = unAvailPet;
		unavlPets[indexOfUnAvl] = availPet;

		System.out.println(" ");

		System.out.println(Arrays.toString(availPets));
		System.out.println(Arrays.toString(unavlPets));
	}

	public static boolean isItemInArray(String item, String[] items) {
		for (String string : items) {
			if (string.toLowerCase().equals(item)) {
				return true;
			}
		}

		return false;
	}
}
