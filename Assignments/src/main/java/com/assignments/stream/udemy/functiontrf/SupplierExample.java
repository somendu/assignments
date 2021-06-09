/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 26-Sep-2020
 */
public class SupplierExample {

	public static void main(String[] args) {

		Supplier<Student> studentSupplier = () -> {
			return new Student("Adam", 2, 3.6, "male", 10, Arrays.asList("swimming", "basketball", "volleyball"));
		};

		System.out.println(studentSupplier.get());

		System.out.println("");

		Supplier<List<Student>> studentListSupplier = () -> {
			return StudentDataBase.getAllStudents();
		};

		System.out.println(studentListSupplier.get());
	}

}
