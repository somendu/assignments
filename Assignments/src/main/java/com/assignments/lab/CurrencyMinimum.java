/**
 * 
 */
package com.assignments.lab;

/**
 * @author somen
 *
 */
public class CurrencyMinimum {

	// function to count and
	// print currency notes
	public static void countCurrency(int amount) {
		int[] notes = new int[] { 10, 5, 1 };
		int[] noteCounter = new int[3];

		// count notes using Greedy approach
		for (int i = 0; i < 3; i++) {
			if (amount >= notes[i]) {
				noteCounter[i] = amount / notes[i];
				amount = amount % notes[i];
			}
		}

		// Print notes
		System.out.println("Currency Count ->");
		for (int i = 0; i < 3; i++) {
			if (noteCounter[i] != 0) {
				System.out.println(notes[i] + " : " + noteCounter[i]);
			}
		}
	}

	// driver function
	public static void main(String argc[]) {
		int amount = 12;
		countCurrency(amount);
	}

}
