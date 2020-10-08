/**
 * 
 */
package com.assignments.stream.udemy.optional;

import java.util.Optional;

import com.assignments.stream.udemy.data.Bike;
import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 03-Oct-2020
 */
public class OptionalMapFlatMapEx {

	// filter
	public static void optionalFilter() {

		Optional<Student> studentOtional = Optional
				.ofNullable(StudentDataBase.studentDaveSupplier.get());

		studentOtional.filter(student -> student.getGpa() <= 3.5)
				.ifPresentOrElse(student -> System.out.println(student),
						new Runnable() {

							@Override
							public void run() {
								System.out.println("Empty");

							}
						});
		// .ifPresent(student -> System.out.println(student));

	}

	// map
	public static void optionalMapFilter() {

		Optional<Student> studentOtional = Optional
				.ofNullable(StudentDataBase.studentDaveSupplier.get());

		if (studentOtional.isPresent()) {
			Optional<String> studentString = studentOtional.filter(
					student -> student.getGender().equalsIgnoreCase("female"))
					.map(Student::getName);

			System.out.println(studentString.get());

		}

	}

	// FlatMAp

	public static void optionalFlatMapFilter() {

		Optional<Student> studentOtional = Optional
				.ofNullable(StudentDataBase.studentAdamSupplier.get());

		Optional<String> studentString = studentOtional
				.filter(student -> student.getGpa() >= 3.5)
				.flatMap(Student::getBike)

				.map(Bike::getName);

		System.out.println(studentString.get());

	}

	public static void main(String[] args) {

		// optionalFilter();
		// optionalMapFilter();
		optionalFlatMapFilter();

	}

}
