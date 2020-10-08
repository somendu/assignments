/**
 * 
 */
package com.assignments.stream.udemy.consref;

import java.util.function.Function;
import java.util.function.Supplier;

import com.assignments.stream.udemy.data.Student;

/**
 * @author Somendu
 *
 * @since 27-Sep-2020
 */
public class ConstructorReference {

	static Supplier<Student> studentSupplier = Student::new;

	static Function<String, Student> studentSupplierCons = Student::new;

	public static void main(String[] args) {

		System.out.println(studentSupplier.get());

		System.out.println(studentSupplierCons.apply("Somendu"));
	}

}
