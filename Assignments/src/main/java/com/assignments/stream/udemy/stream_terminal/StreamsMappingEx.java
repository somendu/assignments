/**
 * 
 */
package com.assignments.stream.udemy.stream_terminal;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 01-Oct-2020
 */
public class StreamsMappingEx {

	public static void main(String[] args) {

		List<String> namesList = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.mapping(Student::getName,
						Collectors.toList()));

		System.out.println("Names List : " + namesList);

		Set<String> namesSet = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.mapping(Student::getName,
						Collectors.toSet()));

		System.out.println("Names Set : " + namesSet);

	}

}
