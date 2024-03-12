/**
 * 
 */
package com.assignments.udemy.stream.udemy.numericstreams;

import java.util.stream.Collectors;

import com.assignments.udemy.stream.udemy.Student;
import com.assignments.udemy.stream.udemy.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 01-Oct-2020
 */
public class StreamsSumAvgEx {

	public static int sumNoteBooks() {
		return StudentDataBase.getAllStudents().stream().collect(Collectors.summingInt(Student::getNoteBooks));
	}

	public static double avgNoteBooks() {
		return StudentDataBase.getAllStudents().stream().collect(Collectors.averagingInt(Student::getNoteBooks));
	}

	public static void main(String[] args) {

		System.out.println("Sum of Notebooks : " + sumNoteBooks());

		System.out.println("Average of Notebooks : " + avgNoteBooks());
	}

}
