/**
 * 
 */
package com.assignments.stream.udemy.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 28-Sep-2020
 */
public class StreamsComparatorEx {

	public static List<Student> sortStudentsByName() {

		return StudentDataBase.getAllStudents().stream().sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
	}

	public static List<Student> sortStudentsByGpa() {

		return StudentDataBase.getAllStudents().stream().sorted(Comparator.comparing(Student::getGpa))
				.collect(Collectors.toList());

	}

	public static List<Student> sortStudentsByGpaDesc() {

		return StudentDataBase.getAllStudents().stream().sorted(Comparator.comparing(Student::getGpa).reversed())
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {

		System.out.println("Sorted by Name: ");
		System.out.println(sortStudentsByName());

		System.out.println("Sorted by GPA: ");
		System.out.println(sortStudentsByGpa());

		System.out.println("Sorted by GPA Desc: ");
		System.out.println(sortStudentsByGpaDesc());

	}

}
