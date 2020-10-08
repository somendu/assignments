/**
 * 
 */
package com.assignments.stream.udemy.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.assignments.stream.udemy.data.Student;

/**
 * @author Somendu
 *
 * @since 29-Sep-2020
 */
public class StreamMinMaxEx {

	public static int findMaxValue(List<Student> noteBookCountList) {

		int maxNoteBookCount = noteBookCountList.stream()
				.map(student -> student.getNoteBooks())

				// .reduce(0, Integer::max);
				.reduce(0, (a, b) -> a > b ? a : b);

		return maxNoteBookCount;
	}

	public static Optional<Integer> findMaxvalueOptional(
			List<Integer> intList) {

		return intList.stream().reduce((a, b) -> a > b ? a : b);
	}

	public static Optional<Integer> findMinvalueOptional(
			List<Integer> intList) {

		return intList.stream().reduce((a, b) -> a < b ? a : b);
	}

	public static void main(String[] args) {

		// System.out.println("Max Notebook count : "
		// + findMaxValue(StudentDataBase.getAllStudents()));

		// List<Integer> intList = new ArrayList<>();

		List<Integer> intList = Arrays.asList(2, 3, 6, 32, 12, 54);

		if (findMaxvalueOptional(intList).isPresent()) {

			System.out.println(
					"Max Value is : " + findMaxvalueOptional(intList).get());
		} else {
			System.out.println("List is empty");
		}

		if (findMinvalueOptional(intList).isPresent()) {

			System.out.println(
					"Min Value is : " + findMinvalueOptional(intList).get());
		} else {
			System.out.println("List is empty");
		}

	}

}
