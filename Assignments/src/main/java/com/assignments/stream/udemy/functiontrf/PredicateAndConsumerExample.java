/**
 * 
 */
package com.assignments.stream.udemy.functiontrf;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 24-Sep-2020
 */
public class PredicateAndConsumerExample {

	Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
	Predicate<Student> p2 = (s) -> s.getGender().equalsIgnoreCase("male");

	BiPredicate<Integer, String> bip3 = (gradeLevel, gender) -> gradeLevel >= 3
			&& gender.equalsIgnoreCase("female");

	BiConsumer<String, List<String>> studentBiConsumer = (name,
			activities) -> System.out.println(
					"Student Name: " + name + " Activities : " + activities);

	Consumer<Student> studentConsumer = (student) -> {

		if (p1.and(p2).test(student)) {
			studentBiConsumer.accept(student.getName(),
					student.getActivities());
		}
	};

	Consumer<Student> studentConsumer2 = (student) -> {

		if (bip3.test(student.getGradeLevel(), student.getGender())) {
			studentBiConsumer.accept(student.getName(),
					student.getActivities());
		}
	};

	public void printStudentActivities(List<Student> studentList)

	{
		studentList.forEach(studentConsumer);
	}

	public void printStudentActivitiesFemale(List<Student> studentList)

	{
		System.out.println("");
		System.out.println("printStudentActivitiesFemale");
		studentList.forEach(studentConsumer2);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new PredicateAndConsumerExample()
				.printStudentActivities(StudentDataBase.getAllStudents());

		new PredicateAndConsumerExample()
				.printStudentActivitiesFemale(StudentDataBase.getAllStudents());
	}

}
