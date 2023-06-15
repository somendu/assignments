/**
 * 
 */
package com.practice.javastdinandstdout1;

import java.util.HashMap;

/**
 * Sum of Integers
 * 
 * @author Somendu Maiti
 *
 * @since 14-Jun-2023
 */
public class SumIntegerHashMap {

	public static void main(String[] args) {

		HashMap<Integer, String> stringMap = new HashMap<Integer, String>();
		stringMap.put(1, "one");
		stringMap.put(2, "two");
		stringMap.put(3, "three");
		stringMap.put(4, "four");
		stringMap.put(5, "five");
		stringMap.put(6, "six");
		stringMap.put(7, "seven");
		stringMap.put(8, "eight");
		stringMap.put(9, "nine");
		stringMap.put(10, "ten");
		stringMap.put(11, "eleven");
		stringMap.put(12, "twelve");
		stringMap.put(13, "thirteen");
		stringMap.put(14, "fourteen");
		stringMap.put(15, "fifteen");
		stringMap.put(16, "sixteen");
		stringMap.put(17, "seventeen");
		stringMap.put(18, "eighteen");

		SumIntegerHashMap sumInteger = new SumIntegerHashMap();
		int a = 4;
		int b = 5;
		int sum = sumInteger.sum(a, b);

		System.out.println("Sum of " + stringMap.get(a) + " and " + stringMap.get(b) + " is " + stringMap.get(sum));

	}

	public int sum(int a, int b) {
		int sum = a + b;
		return sum;
	}

}
