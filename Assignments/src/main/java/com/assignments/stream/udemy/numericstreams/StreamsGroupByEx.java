/**
 * 
 */
package com.assignments.stream.udemy.numericstreams;

import static java.util.stream.Collectors.groupingBy;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;
/**
 * @author Somendu
 *
 * @since 01-Oct-2020
 */
public class StreamsGroupByEx {

	public static void groupStudentByGender() {

		Map<String, List<Student>> studentgenderMap = StudentDataBase
				.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGender));

		List<Student> femaleStudentList = studentgenderMap.get("female");

		System.out.println("Female Student Names: ");

		for (Student student : femaleStudentList) {
			System.out.println(student.getName() + " ");
		}

		List<Student> maleStudentList = studentgenderMap.get("male");

		System.out.println("Male Student Names: ");

		for (Student student : maleStudentList) {
			System.out.println(student.getName() + " ");
		}

	}

	public static void groupStudentByGrade() {

		Map<String, List<Student>> studentGradeMap = StudentDataBase
				.getAllStudents().stream().collect(
						Collectors.groupingBy(student -> student.getGpa() >= 3.8
								? "OUTSTANDING"
								: "AVERAGE"));

		List<Student> outstandingStudentList = studentGradeMap
				.get("OUTSTANDING");

		System.out.println("Outstanding Student Names: ");

		for (Student student : outstandingStudentList) {
			System.out.println(student.getName() + " " + student.getGpa());
		}

		List<Student> averageStudentList = studentGradeMap.get("AVERAGE");

		System.out.println("Average Student Names: ");

		for (Student student : averageStudentList) {
			System.out.println(student.getName() + " " + student.getGpa());
		}

	}

	public static void twoLevelGrouping_1() {

		Map<Integer, Map<String, List<Student>>> studentGradeMap = StudentDataBase
				.getAllStudents().stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel,
						Collectors.groupingBy(student -> student.getGpa() >= 3.8
								? "OUTSTANDING"
								: "AVERAGE")));

		System.out.println(studentGradeMap);
	}

	public static void twoLevelGrouping_2() {

		Map<Object, Integer> studentGradeMap = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(
						(student -> student.getGpa() >= 3.9),
						Collectors.summingInt(Student::getNoteBooks)));

		System.out.println(studentGradeMap);
	}

	public static void twoLevelGrouping_3() {
		LinkedHashMap<Object, Integer> noteBookMap = StudentDataBase
				.getAllStudents().stream()
				.collect(groupingBy(
						student -> student.getGender().equalsIgnoreCase("male"),
						LinkedHashMap::new,
						Collectors.summingInt(Student::getNoteBooks)));

		System.out.println(noteBookMap);
	}

	public static void calculateTopGPA() {

		Map<Integer, Student> studentGPATopMap =

				StudentDataBase.getAllStudents().stream()
						.collect(Collectors.groupingBy(Student::getGradeLevel,
								Collectors.collectingAndThen(
										Collectors.maxBy(Comparator
												.comparing(Student::getGpa)),
										Optional::get)));

		System.out.println(studentGPATopMap);
	}

	public static void calculateLeastGPA() {

		Map<Integer, Student> studentGPALeastMap =

				StudentDataBase.getAllStudents().stream()
						.collect(Collectors.groupingBy(Student::getGradeLevel,
								Collectors.collectingAndThen(
										Collectors.minBy(Comparator
												.comparing(Student::getGpa)),
										Optional::get)));

		System.out.println(studentGPALeastMap);
	}

	public static void main(String[] args) {

		// groupStudentByGender();

		// groupStudentByGrade();

		// twoLevelGrouping_1();

		// twoLevelGrouping_2();

		// twoLevelGrouping_3();

		// calculateTopGPA();
		calculateLeastGPA();
	}

}
