/**
 * 
 */
package com.assignments.udemy.stream.udemy.streams;

import java.util.Optional;

import com.assignments.udemy.stream.udemy.Student;
import com.assignments.udemy.stream.udemy.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 28-Sep-2020
 */
public class StreamStudentReduceEx {

	public static Optional<Student> getHighestGPA() {
		Optional<Student> studentOptional = StudentDataBase.getAllStudents().stream()
				.reduce((s1, s2) -> (s1.getGpa() > s2.getGpa()) ? s1 : s2);

		return studentOptional;
	}

	public static void main(String[] args) {

		if (getHighestGPA().isPresent()) {
			System.out.println(getHighestGPA().get());
		}

	}

}
