/**
 * 
 */
package com.assignments.lab;

/**
 * @author somen
 *
 */
public class CurrencyMinimum2 {

	// function to count and
	// print currency notes
	public static void countCurrency(int amount) {
		int[] notes = new int[] { 123, 18, 12, 5 };
		int[] noteCounter = new int[4];

		// count notes using Greedy approach
		for (int i = 0; i < 4; i++) {
			if (amount >= notes[i]) {
				noteCounter[i] = amount / notes[i];
				amount = amount % notes[i];
			}
		}

		// Print notes
		System.out.println("Currency Count ->");
		for (int i = 0; i < 4; i++) {
			if (noteCounter[i] != 0) {
				System.out.println(notes[i] + " : " + noteCounter[i]);
			}
		}
	}

	// driver function
	public static void main(String argc[]) {
		int amount = 158;
		countCurrency(amount);
	}

}
