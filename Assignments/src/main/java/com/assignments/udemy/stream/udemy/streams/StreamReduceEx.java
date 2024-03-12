/**
 * 
 */
package com.assignments.udemy.stream.udemy.streams;

import java.util.List;

import com.assignments.udemy.stream.udemy.Student;
import com.assignments.udemy.stream.udemy.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 28-Sep-2020
 */
public class StreamReduceEx {

	public static double performAverage(List<Student> studentList) {

		return studentList.stream().mapToDouble(Student::getGpa).reduce(1, (a, b) -> (a + b));

	}

	public static void main(String[] args) {

		System.out.println("Average Grade: "
				+ performAverage(StudentDataBase.getAllStudents()) / StudentDataBase.getAllStudents().size());
	}

}
