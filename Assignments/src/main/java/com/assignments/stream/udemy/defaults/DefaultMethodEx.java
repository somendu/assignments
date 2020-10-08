/**
 * 
 */
package com.assignments.stream.udemy.defaults;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 05-Oct-2020
 */
public class DefaultMethodEx {

	public static void main(String[] args) {

		List<String> namesList = StudentDataBase.getAllStudents().stream()
				.map(Student::getName).collect(Collectors.toList());

		// List<String> namesList = Arrays.asList("Adam", "Dan", "Maria",
		// "Bobby");

		Collections.sort(namesList);

		System.out.println("Sorted List using Collections.sort" + namesList);

		namesList.sort(Comparator.naturalOrder());

		System.out.println(
				"Sorted List using Comparator.naturalOrder" + namesList);

		namesList.sort(Comparator.reverseOrder());

		System.out.println(
				"Sorted List using Comparator.reverseOrder" + namesList);
	}

}
