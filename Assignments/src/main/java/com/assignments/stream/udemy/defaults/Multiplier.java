/**
 * 
 */
package com.assignments.stream.udemy.defaults;

import java.util.List;

/**
 * @author Somendu
 *
 * @since 05-Oct-2020
 */
public interface Multiplier {

	default int sizeList(List<Integer> integerList) {

		System.out.println("Inside Multiplier Interface");
		return integerList.size();
	}

	default int sizeListNew(List<Integer> integerList) {

		System.out.println("sizeListNew Inside Multiplier Interface");
		return integerList.size();
	}

	static boolean isEmpty(List<Integer> integerList) {
		return integerList != null && integerList.size() >= 0;
	}

	static boolean isEmptyNew(List<Integer> integerList) {
		return integerList != null && integerList.size() >= 0;
	}

	int multiply(List<Integer> multiplyList);
}
