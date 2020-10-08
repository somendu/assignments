/**
 * 
 */
package com.assignments.stream.udemy.optional;

import java.util.Optional;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 03-Oct-2020
 */
public class OptionalExample {

	public static String getStudentName() {

		Student student = StudentDataBase.studentAdamSupplier.get();
		// Student student = null;

		if (student != null) {
			return student.getName();
		}

		return "";

	}

	public static Optional<String> getStudentNameOptional() {

		// Optional<Student> studentOptional = Optional.ofNullable(null);

		Optional<Student> studentOptional = Optional
				.ofNullable(StudentDataBase.studentAdamSupplier.get());

		if (studentOptional.isPresent()) {
			return studentOptional.map(Student::getName);
		}
		return Optional.empty();

	}

	public static void main(String[] args) {

		// String studentName = getStudentNameOptional();
		//
		// if (studentName != "") {
		// System.out.println("Student Name is " + studentName
		// + " with Length : " + studentName.length());
		// } else {
		// System.out.println("Null ");
		// }

		Optional<String> stringOptional = getStudentNameOptional();

		if (stringOptional.isPresent()) {
			System.out.println("Student Name is " + stringOptional.get()
					+ " with Length : " + stringOptional.get().length());
		}
	}

}
