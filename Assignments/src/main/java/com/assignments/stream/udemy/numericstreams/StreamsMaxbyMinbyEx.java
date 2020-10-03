/**
 * 
 */
package com.assignments.stream.udemy.numericstreams;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 01-Oct-2020
 */
public class StreamsMaxbyMinbyEx {

	public static Optional<Student> minBy() {

		return StudentDataBase.getAllStudents().stream().collect(
				Collectors.minBy(Comparator.comparing(Student::getGpa)));
	}

	public static Optional<Student> maxBy() {

		return StudentDataBase.getAllStudents().stream().collect(
				Collectors.maxBy(Comparator.comparing(Student::getGpa)));
	}
	public static void main(String[] args) {

		System.out
				.println("Student with least Grade : " + minBy().get().getName()
						+ " with Grade : " + minBy().get().getGpa());

		System.out.println(
				"Student with highest Grade : " + maxBy().get().getName()
						+ " with Grade : " + maxBy().get().getGpa());
	}

}
