/**
 * 
 */
package com.assignments.stream.udemy.streams;

import java.util.List;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 28-Sep-2020
 */
public class StreamReduceEx {

	public static double performAverage(List<Student> studentList) {

		return studentList.stream().mapToDouble(Student::getGpa).reduce(1,
				(a, b) -> (a + b));

	}

	public static void main(String[] args) {

		System.out.println("Average Grade: "
				+ performAverage(StudentDataBase.getAllStudents())
						/ StudentDataBase.getAllStudents().size());
	}

}
