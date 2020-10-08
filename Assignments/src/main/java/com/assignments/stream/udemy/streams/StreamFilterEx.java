/**
 * 
 */
package com.assignments.stream.udemy.streams;

import java.util.List;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 28-Sep-2020
 */
public class StreamFilterEx {

	public static List<Student> filterFemaleStudents() {

		return StudentDataBase.getAllStudents().stream()

				.filter((student -> student.getGender()
						.equalsIgnoreCase("female")))

				.filter(student -> student.getGpa() >= 3.6)

				.collect(Collectors.toList());

	}

	public static void main(String[] args) {

		// System.out.println("Filter Femal : " + filterFemaleStudents());

		filterFemaleStudents().forEach(System.out::println);

	}

}
