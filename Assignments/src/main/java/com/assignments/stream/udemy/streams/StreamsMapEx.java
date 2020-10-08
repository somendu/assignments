/**
 * 
 */
package com.assignments.stream.udemy.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 28-Sep-2020
 */
public class StreamsMapEx {

	public static List<String> nameList = StudentDataBase.getAllStudents()
			.stream()

			.map(Student::getName)

			.map(String::toUpperCase)

			.collect(Collectors.toList());

	public static Set<String> namesSet = StudentDataBase.getAllStudents()
			.stream()

			.map(Student::getName)

			.map(String::toLowerCase)

			.collect(Collectors.toSet());
	public static void main(String[] args) {

		System.out.println(nameList);
		System.out.println(namesSet);
	}

}
