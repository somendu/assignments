/**
 * 
 */
package com.assignments.self.ds;

import java.util.Stack;

/**
 * @author somendu
 *
 */
public class ReverseNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int number = 39997;
		System.out.println(reverse_number(number));

	}

	// Stack to maintain order of digits
	static Stack<Integer> st = new Stack<>();

	// Function to push digits into stack
	static void push_digits(int number) {
		while (number != 0) {
//			System.out.println(number);
			st.push(number % 10);
			number = number / 10;
		}

		System.out.println(st);
	}

	// Function to reverse the number
	static int reverse_number(int number) {
		// Function call to push number's
		// digits to stack
		push_digits(number);
		int reverse = 0;
		int i = 1;

		// Popping the digits and forming
		// the reversed number
		while (!st.isEmpty()) {

			reverse = reverse + (st.peek() * i);
			st.pop();
			i = i * 10;
		}

		// Return the reversed number formed
		return reverse;
	}
}
