/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 24-Sep-2020
 */
public class FunctionStudentExample {

	static Function<List<Student>, Map<String, Double>> studentFunction = (studentList ->

	{
		Map<String, Double> gpaMap = new HashMap<>();

		studentList.forEach((student -> {

			gpaMap.put(student.getName(), student.getGpa());
		}));

		return gpaMap;

	});

	public static void main(String[] args) {

		System.out.println(
				studentFunction.apply(StudentDataBase.getAllStudents()));

	}

}
