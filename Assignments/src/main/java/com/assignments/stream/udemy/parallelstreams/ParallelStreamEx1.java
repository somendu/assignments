package com.assignments.stream.udemy.parallelstreams;

import java.util.List;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

public class ParallelStreamEx1 {

	public static List<String> printStudentActivities() {

		long startTime = System.currentTimeMillis();
		List<String> studentActivities = StudentDataBase.getAllStudents()
				.stream()

				.map(Student::getActivities)

				.flatMap(List::stream).distinct().sorted()
				.collect(Collectors.toList());

		long endTime = System.currentTimeMillis();

		System.out.println("Sequential Runing time : " + (endTime - startTime));

		return studentActivities;

	}

	public static List<String> printParallelStudentActivities() {
		long startTime = System.currentTimeMillis();
		List<String> studentActivities = StudentDataBase.getAllStudents()
				.stream().parallel()

				.map(Student::getActivities)

				.flatMap(List::stream).distinct().sorted()
				.collect(Collectors.toList());

		long endTime = System.currentTimeMillis();

		System.out.println("Parallel Runing time : " + (endTime - startTime));

		return studentActivities;

	}

	public static void main(String[] args) {

		printStudentActivities();
		printParallelStudentActivities();

	}

}
