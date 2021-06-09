/**
 * 
 */
package com.assignments.stream.udemy.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

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

	public static List<String> findList() {

		return StudentDataBase.getAllStudents().stream().map(student -> student.getName().trim())
				.collect(Collectors.toList());

	}

	public static Optional<Student> findFirst() {

		return StudentDataBase.getAllStudents().stream().filter(student -> student.getGender().equalsIgnoreCase("male"))
				.findFirst();
	}

	public static void main(String[] args) {

		// System.out.println("Find Any : " + findAny());

		System.out.println("Find First : " + findList());
	}

}
