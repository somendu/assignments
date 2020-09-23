/**
 * 
 */
package com.assignments.stream.udemy.impdec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Somendu
 *
 * @since 19-Sep-2020
 */
public class ImpVsDec2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> integerList = Arrays.asList(1, 2, 3, 2, 4, 6, 6, 3, 7, 5,
				2, 1);

		/**
		 * Imperative - How Style of Programming
		 * 
		 */

		List<Integer> uniqueList = new ArrayList<>();

		for (int num : integerList) {
			if (!uniqueList.contains(num)) {
				uniqueList.add(num);
			}
		}

		System.out.println("UniqueList using Imperative: " + uniqueList);

		/**
		 * Declarative - What Style of Programming
		 * 
		 */

		uniqueList = integerList.stream().distinct().sorted()
				.collect(Collectors.toList());

		System.out.println("UniqueList using Declarative: " + uniqueList);

	}

}
