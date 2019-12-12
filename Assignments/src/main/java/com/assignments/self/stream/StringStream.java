package com.assignments.self.stream;

import java.util.Arrays;

public class StringStream {

	public static void main(String[] args) {

		String[] names = { "Ran", "Ali", "Roh", "Aka", "Som", "Jam", "Ivy" };

		Arrays.stream(names).filter(x -> x.startsWith("R")).sorted().forEach(System.out::println);
	}
}
