/**
 * 
 */
package com.assignments.self;

import java.util.ArrayList;
import java.util.List;

/**
 * @author somendu
 *
 */
public class StringCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String string = "Testing";

		String stringTwo = "TestingTwo";

		String stringThree = "TestingThree";

		List<String> stringList = new ArrayList<String>();

		stringList.add(string);
		stringList.add(stringTwo);
		stringList.add(stringThree);

		int length = stringList.size();

		System.out.println(reverse(1221));

		string = string.replace('s', 'x');

//		System.out.println(string);

	}

	private static int reverse(int number) {
		int reverse = 0;

		while (number != 0) {
			System.out.println(reverse);
			System.out.println(number);
			System.out.println("");
			reverse = reverse * 10 + number % 10;
			number = number / 10;
		}

		return reverse;
	}

}
