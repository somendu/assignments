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
public class OptionalOrElseExample {

	// orElse
	public static String optionalOrElse() {

		Optional<Student> studentOptional = Optional
				.ofNullable(StudentDataBase.studentAdamSupplier.get());

		// Optional<Student> studentOptional = Optional.ofNullable(null);

		String name = studentOptional.map(Student::getName).orElse("Default");

		return name;
	}

	// orElseGet

	public static String optionalOrElseGet() {

		Optional<Student> studentOptional = Optional
				.ofNullable(StudentDataBase.studentAdamSupplier.get());

		// Optional<Student> studentOptional = Optional.ofNullable(null);

		String name = studentOptional.map(Student::getName)
				.orElseGet(() -> "default");

		return name;
	}

	// orElseThrow

	public static String optionalOrElseThrow() {

		// Optional<Student> studentOptional = Optional
		// .ofNullable(StudentDataBase.studentAdamSupplier.get());

		Optional<Student> studentOptional = Optional.ofNullable(null);

		String name = studentOptional.map(Student::getName)
				.orElseThrow(() -> new RuntimeException("No data Available"));

		return name;
	}

	public static void main(String[] args) {

		System.out.println("orElse " + optionalOrElse());

		System.out.println("orElseGet " + optionalOrElse());

		System.out.println("orElseGet " + optionalOrElseThrow());
	}

}
