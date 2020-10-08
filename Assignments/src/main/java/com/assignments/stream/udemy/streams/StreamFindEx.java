/**
 * 
 */
package com.assignments.stream.udemy.streams;

import java.util.Optional;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 30-Sep-2020
 */
public class StreamFindEx {

	public static Optional<Student> findAny() {

		return StudentDataBase.getAllStudents().stream()
				.filter(student -> student.getGender().equalsIgnoreCase("male"))
				.findAny();
	}

	public static Optional<Student> findFirst() {

		return StudentDataBase.getAllStudents().stream()
				.filter(student -> student.getGender().equalsIgnoreCase("male"))
				.findFirst();
	}
	public static void main(String[] args) {

		System.out.println("Find Any : " + findAny());

		System.out.println("Find First : " + findFirst());
	}

}
