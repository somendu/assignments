package com.assignments.self.stream;

import java.util.stream.IntStream;

public class LimitStream {

	public static void main(String args[]) {

		var string = "";

		Object[] objectArray = new Object[5];

		IntStream.iterate(0, i -> i + 1).limit(5).filter(i -> i % 2 == 0).forEach(System.out::print);

		IntStream.iterate(0, i -> i + 1).peek(System.out::print).filter(i -> i % 2 == 0).limit(3)
				.forEach(System.out::print);

	}

}
