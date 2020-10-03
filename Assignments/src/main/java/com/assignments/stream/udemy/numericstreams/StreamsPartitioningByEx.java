/**
 * 
 */
package com.assignments.stream.udemy.numericstreams;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import com.assignments.stream.udemy.data.Student;
import com.assignments.stream.udemy.data.StudentDataBase;;

/**
 * @author Somendu
 *
 * @since 01-Oct-2020
 */
public class StreamsPartitioningByEx {

	public static void partitioning1() {

		Predicate<Student> stuentPredicate = (student -> student.getGender()
				.equalsIgnoreCase("female"));

		Map<Boolean, List<Student>> studentListMap = StudentDataBase
				.getAllStudents().stream()
				.collect(partitioningBy(stuentPredicate));

		System.out.println(studentListMap);
	}

	public static void partitioning2() {

		Predicate<Student> stuentPredicate = (student -> student.getGender()
				.equalsIgnoreCase("female"));

		Map<Boolean, Set<Student>> studentListMap = StudentDataBase
				.getAllStudents().stream()
				.collect(partitioningBy(stuentPredicate, toSet()));

		System.out.println(studentListMap);
	}

	public static void main(String[] args) {

		// partitioning1();
		partitioning2();
	}

}
