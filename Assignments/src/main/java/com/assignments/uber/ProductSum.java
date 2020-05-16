/**
 * 
 */
package com.assignments.uber;

/**
 * @author somendu
 *
 */
public class ProductSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductSum productSum = new ProductSum();

		productSum.getProdSum(12);
	}

	public int getProdSum(int n) {

		int product = 0;
		int sum = 0;

		int result = 0;

		int countDigits = 0;

		while (n != 0) {
			n /= 10;
			++countDigits;
		}

		int multiplier = 1;
		for (int i = 1; i < countDigits; i++) {
			multiplier *= 10;
		}

		int lastDigit = n % multiplier;

		System.out.println(countDigits);
		System.out.println(multiplier);
		System.out.println(lastDigit);

//		if (n < 10) {
//			result = n - n;
//		} else if (n >= 10 && n <= 99) {
//
//			int lastDigit = n % 10;
//
//			int firstDigit = n / 10;
//
//			product = lastDigit * firstDigit;
//			sum = lastDigit + firstDigit;
//
//			result = product - sum;
//
//		} else if (n >= 100 && n <= 999) {
//
//			// 123
//			int lastDigitFor = n % 100;
//			int secondLastDigit = lastDigitFor / 10;
//			int lastDigit = lastDigitFor % 10;
//			int firstDigit = n / 100;
//
//			product = lastDigit * secondLastDigit * firstDigit;
//			sum = lastDigit + secondLastDigit + firstDigit;
//
//			result = product - sum;
//
//		}else if (n >= 1000 && n <= 9999) {
//
//			// 1234
//			int lastDigitFor = n % 1000;
//			int thirdLastDigit = lastDigitFor / 100;
//			int lastDigit = lastDigitFor % 100;
//			int firstDigit = n / 1000;
//
////			product = lastDigit * secondLastDigit * firstDigit;
////			sum = lastDigit + secondLastDigit + firstDigit;
//
//			result = product - sum;
//
//		}

		return result;
	}

}
