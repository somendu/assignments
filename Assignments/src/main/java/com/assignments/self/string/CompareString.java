/**
 * 
 */
package com.assignments.self.string;

/**
 * @author Admin_8_1
 *
 */
public class CompareString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		var a = 100;
		var b = 11.0;

		// System.out.println(a / b); // result
		// System.out.println(a % b); // reminder
//		System.out.println(Math.abs(a / b));
//		System.out.println(Math.floor(a / b));

		var number = 38749;

		var firstDigit = number / 10000;
		System.out.println(firstDigit);

		var secondDigit = (number % 10000) / 1000;
		System.out.println((secondDigit));

		var thirdDigit = (((number % 10000)) % 1000) / 100;
		System.out.println((thirdDigit));

		var fourthDigit = ((((number % 10000)) % 1000) % 100) / 10;
		System.out.println((fourthDigit));

		var fifthDigit = (((((number % 10000)) % 1000) % 100) % 10);
		System.out.println((fifthDigit));

	}

}
