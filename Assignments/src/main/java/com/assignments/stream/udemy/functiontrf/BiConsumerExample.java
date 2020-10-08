/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.List;
import java.util.function.BiConsumer;

import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 23-Sep-2020
 */
public class BiConsumerExample {

	public static void printStudentNameAndActivities() {

		var studentList = StudentDataBase.getAllStudents();

		BiConsumer<String, List<String>> studentConsumer = (name,
				activities) -> System.out
						.println("Name : " + name + " does " + activities);

		studentList.forEach(student -> {

			if (student.getGender().equals("male"))

				studentConsumer.accept(student.getName(),
						student.getActivities());
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BiConsumer<String, String> biConsumerString = (a, b) -> System.out
				.println("String a : " + a + " , String b: " + b);

		biConsumerString.accept("data", "here");

		BiConsumer<Integer, Integer> biConsumerIntegerMul = (a, b) -> System.out
				.println("Multiplication is : " + a * b);

		BiConsumer<Integer, Integer> biConsumerIntegerDiv = (a, b) -> System.out
				.println("Division is : " + a / b);

		biConsumerIntegerMul.andThen(biConsumerIntegerDiv).accept(15, 3);

		printStudentNameAndActivities();

	}

}
