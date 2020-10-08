/**
 * 
 */
package com.assignments.stream.udemy.defaults;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 05-Oct-2020
 */
public class DefaultMethodsEx2 {

	public static Consumer<Student> studentConsumer = (student -> System.out
			.println(student));

	static Comparator<Student> nameComparator = Comparator
			.comparing(Student::getName);

	static Comparator<Student> gradeComparator = Comparator
			.comparingDouble(Student::getGradeLevel);

	public static void sortByName(List<Student> studentList) {

		System.out.println("After Sort : ");

		Comparator<Student> nameComparator = Comparator
				.comparing(Student::getName);

		studentList.sort(nameComparator);

		studentList.forEach(studentConsumer);

	}

	public static void sortByGrade(List<Student> studentList) {

		System.out.println("After Sort GPA : ");

		Comparator<Student> gradeComparator = Comparator
				.comparingDouble(Student::getGradeLevel);

		studentList.sort(gradeComparator);

		studentList.forEach(studentConsumer);

	}

	public static void compareChaining(List<Student> studentList) {

		System.out.println("After compareChaining : ");

		studentList.sort(gradeComparator.thenComparing(nameComparator));

		studentList.forEach(studentConsumer);

	}

	public static void sortWithNullValues(List<Student> studentList) {

		System.out.println("After sortWithNullValues nullsLast: ");

		Comparator<Student> studentComparator = Comparator
				.nullsLast(nameComparator);

		studentList.sort(studentComparator);

		studentList.forEach(studentConsumer);

	}

	public static void main(String[] args) {

		List<Student> studentList = StudentDataBase.getAllStudents();
		System.out.println("Before Sort : ");
		studentList.forEach(studentConsumer);

		// sortByName(studentList);

		// sortByGrade(studentList);

		// compareChaining(studentList);

		sortWithNullValues(studentList);
	}

}
