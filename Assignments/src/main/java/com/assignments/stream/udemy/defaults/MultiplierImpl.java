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
public class MultiplierImpl implements Multiplier {

	@Override
	public int multiply(List<Integer> multiplyList) {

		return multiplyList.stream().reduce(1, (x, y) -> x * y);
	}

	@Override
	public int sizeList(List<Integer> integerList) {

		System.out.println("Inside MultiplierImpl Class");
		return integerList.size();
	}

}
