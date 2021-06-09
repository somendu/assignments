/**
 * 
 */
package com.assignments.stream.udemy.streams;

import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 30-Sep-2020
 */
public class StreamMatchEx {

	public static boolean allMatch() {

		return StudentDataBase.getAllStudents().stream().allMatch(student -> student.getGpa() >= 3.5);
	}

	public static boolean anyMatch() {

		return StudentDataBase.getAllStudents().stream().anyMatch(student -> student.getGpa() == 3.5);
	}

	public static boolean noneMatch() {

		return StudentDataBase.getAllStudents().stream().noneMatch(student -> student.getGpa() >= 3.5);
	}

	public static void main(String[] args) {

		System.out.println("All Match GPA : " + allMatch());

		System.out.println("Any Match GPA : " + anyMatch());

		System.out.println("None Match GPA : " + noneMatch());
	}

}
