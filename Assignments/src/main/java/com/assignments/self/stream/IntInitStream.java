package com.assignments.self.stream;

import java.util.Arrays;

public class IntInitStream {

	public static void main(String[] args) {

		Arrays.stream(new int[] { 4, 6, 8, 2, 10 }).map(x -> x * x).peek(System.out::println).average()
				.ifPresent(System.out::println);

	}

}
