/**
 * 
 */
package com.assignments.stream.udemy.methodreference;

import java.util.function.Predicate;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;

/**
 * @author Somendu
 *
 * @since 27-Sep-2020
 */
public class RefactorMethodRefEx {

	static Predicate<Student> studentPredicate = p -> p.getGradeLevel() >= 3;

	static Predicate<Student> studentPredicateRefMeth = RefactorMethodRefEx::greaterThanValue;

	public static boolean greaterThanValue(Student s) {
		return s.getGradeLevel() >= 3;

	}

	public static void main(String[] args) {

		System.out.println(
				studentPredicate.test(StudentDataBase.studentSupplier.get()));

		System.out.println(studentPredicateRefMeth
				.test(StudentDataBase.studentSupplier.get()));

	}

}
