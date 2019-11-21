/**
 * 
 */
package com.assignments.k1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author somendu
 *
 */
public class OrdinalNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Using String Array : " + ordinalNumberUsingStringArray(67));

		System.out.println("Using String List : " + ordinalNumberUsingStringList(21));

		System.out.println("Using String No Index List : " + ordinalNumberUsingStringListNoIndex(178));

	}

	public static String ordinalNumberUsingStringList(int number) {

		String ordinalString = "";

		List<String> numberSuffixList = new ArrayList<String>(10);

		numberSuffixList.add(0, "th");
		numberSuffixList.add(1, "st");
		numberSuffixList.add(2, "nd");
		numberSuffixList.add(3, "rd");
		numberSuffixList.add(4, "th");
		numberSuffixList.add(4, "th");
		numberSuffixList.add(5, "th");
		numberSuffixList.add(6, "th");
		numberSuffixList.add(7, "th");
		numberSuffixList.add(8, "th");
		numberSuffixList.add(9, "th");

		if (number % 100 == 11 || number % 100 == 12 || number % 100 == 13) {

			ordinalString = number + "th";

		} else if (number == 0) {

			ordinalString = "";

		} else {

			ordinalString = number + numberSuffixList.get(number % 10);

		}

		return ordinalString;
	}

	public static String ordinalNumberUsingStringListNoIndex(int number) {

		String ordinalString = "";

		List<String> numberSuffixList = new ArrayList<String>(10);

		numberSuffixList.add("th");
		numberSuffixList.add("st");
		numberSuffixList.add("nd");
		numberSuffixList.add("rd");
		numberSuffixList.add("th");
		numberSuffixList.add("th");
		numberSuffixList.add("th");
		numberSuffixList.add("th");
		numberSuffixList.add("th");
		numberSuffixList.add("th");
		numberSuffixList.add("th");

		if (number % 100 == 11 || number % 100 == 12 || number % 100 == 13) {

			ordinalString = number + "th";

		} else if (number == 0) {

			ordinalString = "";

		} else {

			ordinalString = number + numberSuffixList.get(number % 10);

		}

		return ordinalString;
	}

	public static String ordinalNumberUsingStringArray(int number) {

		String ordinalString = "";

		String[] numberSuffixArray = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };

		if (number % 100 == 11 || number % 100 == 12 || number % 100 == 13) {

			ordinalString = number + "th";

		} else if (number == 0) {

			ordinalString = "";

		} else {

			ordinalString = number + numberSuffixArray[number % 10];
		}

		return ordinalString;
	}
}
