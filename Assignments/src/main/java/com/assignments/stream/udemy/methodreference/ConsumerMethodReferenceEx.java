/**
 * 
 */
package com.assignments.stream.udemy.methodreference;

import java.util.function.Consumer;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 27-Sep-2020
 */
public class ConsumerMethodReferenceEx {

	static Consumer<Student> c1 = p -> System.out.println(p);

	static Consumer<Student> c2 = System.out::println;

	static Consumer<Student> c3 = Student::printListOfActivities;

	public static void main(String[] args) {

		System.out.println("With Lambda");
		StudentDataBase.getAllStudents().forEach(c1);

		System.out.println("With Method Reference");
		StudentDataBase.getAllStudents().forEach(c2);

		System.out.println("Activities");
		StudentDataBase.getAllStudents().forEach(c3);
	}

}
