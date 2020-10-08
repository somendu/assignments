package com.assignments.stream.udemy.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionsVsStreams {

	public static void main(String[] args) {

		ArrayList<String> namesList = new ArrayList<String>();

		namesList.add("Data");
		namesList.add("Entity");
		namesList.add("OneNF");

		// namesList.remove(2);

		System.out.println(namesList);

		long count = namesList.stream().count();

		System.out.println(count);

		Stream<String> stringStream = namesList.stream();

		stringStream.forEach(System.out::println);
		// stringStream.forEach(System.out::println);

	}

}
