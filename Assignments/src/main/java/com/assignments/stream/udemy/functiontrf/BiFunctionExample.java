/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 26-Sep-2020
 */
public class BiFunctionExample {

	static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (
			studentList, studentPredicate) -> {

		Map<String, Double> studentMap = new HashMap<>();

		studentList.forEach(student -> {

			if (studentPredicate.test(student)) {
				studentMap.put(student.getName(), student.getGpa());
			}

		});
		return studentMap;

	};

	static BiFunction<List<Student>, Predicate<Student>, Map<String, String>> binfunctionGender = (
			studentList, studentPredicate) -> {

		Map<String, String> genderMap = new HashMap<>();

		studentList.forEach(student -> {
			if (studentPredicate.test(student)) {
				genderMap.put(student.getName(), student.getGender());
			}

		});
		return genderMap;
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(biFunction.apply(StudentDataBase.getAllStudents(),
				PredicateStudentExample.psgr));

		System.out.println(biFunction.apply(StudentDataBase.getAllStudents(),
				PredicateStudentExample.psgn));

	}

}
