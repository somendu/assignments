package com.assignments.self.stream;

import java.util.Arrays;
import java.util.List;

public class ListStream {

	public static void main(String[] args) {

		List<String> peopleList = Arrays.asList("This", "is", "something", "about", "Streams");

		peopleList.stream().map(String::toLowerCase).filter(x -> x.startsWith("t")).forEach(System.out::println);

	}

	private double calculateAngle(double angle, int[] trees) {

		double calAngle = 0;

		// TODDO

		return calAngle;
	}
}
