/**
 * 
 */
package com.assignments.stream.udemy.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 28-Sep-2020
 */
public class StreamFlatMapEx {

	public static List<String> printStudentActivities() {

		List<String> studentActivities = StudentDataBase.getAllStudents()
				.stream()

				.map(Student::getActivities)

				.flatMap(List::stream).distinct().sorted()
				.collect(Collectors.toList());

		return studentActivities;

	}

	public static Set<String> printStudentActivitiesSet() {

		Set<String> studentActivities = StudentDataBase.getAllStudents()
				.stream()

				.map(Student::getActivities)

				.flatMap(List::stream).distinct().sorted()
				.collect(Collectors.toSet());

		return studentActivities;

	}

	public static long countStudentActivities() {

		long noOfActivities = StudentDataBase.getAllStudents().stream()

				.map(Student::getActivities)

				.flatMap(List::stream).distinct().count();

		return noOfActivities;

	}

	public static void main(String[] args) {

		System.out.println(printStudentActivities());
		System.out.println("");
		System.out.println(printStudentActivitiesSet());
		System.out.println("");
		System.out.println(countStudentActivities());
	}

}
