/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.List;
import java.util.function.Predicate;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 23-Sep-2020
 */
public class PredicateStudentExample {

	static Predicate<Student> psgr = (
			student) -> (student.getGradeLevel() >= 3);

	static Predicate<Student> psgn = (
			student) -> (student.getGender().equalsIgnoreCase("male"));

	public static void filterStudetntbyGrade() {

		List<Student> studentList = StudentDataBase.getAllStudents();

		studentList.forEach(student -> {
			if (psgr.and(psgn).test(student)) {
				System.out.println(student);
			}
		});

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		filterStudetntbyGrade();

	}

}
