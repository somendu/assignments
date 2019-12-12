package com.assignments.self.stream;

import java.util.stream.Stream;

public class StartStream {

	public static void main(String[] args) {

//		IntStream.range(1, 10).skip(5).forEach(x -> System.out.println(x));
//		System.out.println("");

//		IntStream.range(0, 30).filter(i -> i % 2 == 0).skip(10).forEach(x -> System.out.println(x));
//		System.out.println("");

//		int printInt = IntStream.range(1, 10).sum();
//		System.out.println(printInt);

		Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst().ifPresent(x -> System.out.println(x));

	}
}
