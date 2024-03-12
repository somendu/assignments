/**
 * 
 */
package com.assignments.udemy.stream.udemy.functiontrf;

import java.util.List;
import java.util.function.Predicate;

import com.assignments.udemy.stream.udemy.Student;
import com.assignments.udemy.stream.udemy.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 23-Sep-2020
 */
public class PredicateStudentExample {

	static Predicate<Student> psgr = (student) -> (student.getGradeLevel() >= 3);

	static Predicate<Student> psgn = (student) -> (student.getGender().equalsIgnoreCase("male"));

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
