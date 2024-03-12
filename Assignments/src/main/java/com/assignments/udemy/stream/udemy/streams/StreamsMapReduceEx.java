/**
 * 
 */
package com.assignments.udemy.stream.udemy.streams;

import com.assignments.udemy.stream.udemy.Student;
import com.assignments.udemy.stream.udemy.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 29-Sep-2020
 */
public class StreamsMapReduceEx {

	private static int noOfNotebooks() {

		int noOfNotebooks = StudentDataBase.getAllStudents().stream()

				// .filter(student -> student.getGradeLevel() >= 3)

				.filter(student -> student.getGender().equalsIgnoreCase("female"))

				.map(Student::getNoteBooks)

				// .reduce(0, (a, b) -> (a + b));

				.reduce(0, Integer::sum);

		return noOfNotebooks;

	}

	public static void main(String[] args) {

		System.out.println("No of Notebooks: " + noOfNotebooks());
	}

}
