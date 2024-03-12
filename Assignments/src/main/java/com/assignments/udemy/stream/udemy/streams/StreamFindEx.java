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
 * @since 30-Sep-2020
 */
public class StreamFindEx {

	public static Optional<Student> findAny() {

		return StudentDataBase.getAllStudents().stream().filter(student -> student.getGender().equalsIgnoreCase("male"))
				.findAny();
	}

	public static Optional<Student> findFirst() {

		return StudentDataBase.getAllStudents().stream().filter(student -> student.getGender().equalsIgnoreCase("male"))
				.findFirst();
	}

	public static void main(String[] args) {

		System.out.println("Find Any : " + findAny());

		System.out.println("Find First : " + findFirst());
	}

}
