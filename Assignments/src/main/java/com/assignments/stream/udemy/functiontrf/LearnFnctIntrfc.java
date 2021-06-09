/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu Maiti
 *
 * @Since 23-Mar-2021
 */
public class LearnFnctIntrfc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Supplier

		String strOne = "1";
		Supplier<String> stringSupplier = () -> {
			return new String("Test");
		};

		System.out.println(stringSupplier.get().concat(" Data"));

		// Predicate
		Predicate<String> stringPredicate = (str) -> str.equalsIgnoreCase(strOne);

		System.out.println(stringPredicate.test("0"));

		Predicate<Student> studentPredicate = student -> (student.getGender().equalsIgnoreCase("male"));

		List<Student> studentList = StudentDataBase.getAllStudents();

//		studentList.forEach(student -> {
//			if (studentPredicate.test(student)) {
//				System.out.println(student);
//			}
//		});

		System.out.println(
				studentList.stream().filter(student -> student.getName().startsWith("A")).collect(Collectors.toList()));

		// Consumer
		Consumer<String> stringConsumer = (str) -> System.out.println(str);

		stringConsumer.accept("Test");

		Function<String, String> studentFunction = string -> string.toLowerCase();

		System.out.println(studentFunction.apply("DATA"));

	}

}
