/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.List;
import java.util.function.Consumer;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 23-Sep-2020
 */
public class ConsumerExample {

	static Consumer<Student> consumerStudent = (student) -> System.out
			.println(student);

	static Consumer<Student> consumerStudentName = (student) -> System.out
			.print(student.getName());

	static Consumer<Student> consumerStudentActivities = (student) -> System.out
			.println(student.getActivities());

	static void printStudents() {

		List<Student> studentList = StudentDataBase.getAllStudents();

		studentList.forEach(consumerStudent);

	}

	static void printStudentAndActivities() {

		System.out.println("printStudentAndActivities");

		List<Student> studentList = StudentDataBase.getAllStudents();

		studentList.forEach(
				consumerStudentName.andThen(consumerStudentActivities));

	}

	static void printStudentAndActivitiesUsingCondition() {

		System.out.println("printStudentAndActivitiesUsingCondition");

		List<Student> studentList = StudentDataBase.getAllStudents();

		studentList.forEach((student) -> {
			if (student.getGradeLevel() >= 3
					&& student.getGender().equals("male"))
				consumerStudentName.andThen(consumerStudentActivities)
						.andThen(consumerStudent).accept(student);
		});

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Consumer<String> consumerString = (s) -> System.out
		// .println(s.toLowerCase());
		// consumerString.accept("VALUE HERE");

		// printStudents();
		printStudentAndActivities();
		System.out.println("");
		printStudentAndActivitiesUsingCondition();
	}

}
