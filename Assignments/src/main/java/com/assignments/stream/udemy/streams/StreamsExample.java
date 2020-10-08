/**
 * 
 */
package com.assignments.stream.udemy.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 28-Sep-2020
 */
public class StreamsExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<String, List<String>> activitymap = StudentDataBase.getAllStudents()
				.stream().collect(Collectors.toMap(Student::getName,
						Student::getActivities));

		Predicate<Student> studentGrade = student -> student
				.getGradeLevel() >= 3;

		Predicate<Student> studentGender = student -> student.getGender()
				.equalsIgnoreCase("male");

		Map<String, List<String>> activityFiltermap = StudentDataBase
				.getAllStudents().stream()

				.peek(student -> System.out.println(student))

				.filter(studentGrade)

				.peek(student -> System.out
						.println(student + "Inside studentGrade "))

				.filter(studentGender).collect(Collectors
						.toMap(Student::getName, Student::getActivities));

		System.out.println(activitymap);

		System.out.println(activityFiltermap);
	}

}
