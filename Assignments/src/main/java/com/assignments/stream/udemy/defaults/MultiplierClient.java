/**
 * 
 */
package com.assignments.stream.udemy.defaults;

import java.util.Arrays;
import java.util.List;

/**
 * @author Somendu
 *
 * @since 05-Oct-2020
 */
public class MultiplierClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Multiplier multiplier = new MultiplierImpl();

		// int[] gradeArray =
		// StudentDataBase.getAllStudents().stream().mapToInt(Student::getGradeLevel).toArray();

		List<Integer> integerList = Arrays.asList(1, 3, 5);

		System.out.println("Result : " + multiplier.multiply(integerList));

		System.out.println(
				"Integer List size : " + multiplier.sizeListNew(integerList));

		System.out.println(
				"Static Method isEmpty : " + Multiplier.isEmpty(integerList));
	}

}
