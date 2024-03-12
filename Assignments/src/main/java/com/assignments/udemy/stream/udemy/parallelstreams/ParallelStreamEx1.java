package com.assignments.udemy.stream.udemy.parallelstreams;

import java.util.List;
import java.util.stream.Collectors;

import com.assignments.udemy.stream.udemy.Student;
import com.assignments.udemy.stream.udemy.StudentDataBase;

public class ParallelStreamEx1 {

	public static List<String> printStudentActivities() {

		long startTime = System.currentTimeMillis();
		List<String> studentActivities = StudentDataBase.getAllStudents().stream()

				.map(Student::getActivities)

				.flatMap(List::stream).distinct().sorted().collect(Collectors.toList());

		long endTime = System.currentTimeMillis();

		System.out.println("Sequential Runing time : " + (endTime - startTime));

		return studentActivities;

	}

	public static List<String> printParallelStudentActivities() {
		long startTime = System.currentTimeMillis();
		List<String> studentActivities = StudentDataBase.getAllStudents().stream().parallel()

				.map(Student::getActivities)

				.flatMap(List::stream).distinct().sorted().collect(Collectors.toList());

		long endTime = System.currentTimeMillis();

		System.out.println("Parallel Runing time : " + (endTime - startTime));

		return studentActivities;

	}

	public static void main(String[] args) {

		printStudentActivities();
		printParallelStudentActivities();

	}

}
