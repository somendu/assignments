/**
 * 
 */
package com.assignments.stream;

import java.util.stream.Stream;

/**
 * @author Somendu
 *
 * @since 12-Sep-2020
 */
public class StreamOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Stream.of("d2", "a2", "b1", "b3", "c")
		// .filter(s -> {
		// System.out.println("filter: " + s);
		// return true;
		// });
		//
		// Stream.of("d2", "a2", "b1", "b3", "c")
		// .filter(s -> {
		// System.out.println("filter: " + s);
		// return true;
		// })
		// .forEach(s -> System.out.println("forEach: " + s));

		// Stream.of("a11", "d35", "f81", "p03", "q21", "e43", "c")
		// .filter(s -> { System.out.println("filter: " + s);;
		// return s.equalsIgnoreCase("a11");
		// })
		// .anyMatch(s -> {
		// s.equalsIgnoreCase("p03");
		// return s.startsWith("A");
		// });

		// Stream.of("a11", "d35", "f81", "a03", "q21", "e43", "c")
		// .map(s -> { System.out.println("map: " + s);;
		// return s.toUpperCase();API
		// })
		// .anyMatch(s -> {
		// s.equalsIgnoreCase("anyMatch: " + s);
		// return s.startsWith("A");
		// });

		Stream.of("d2", "a2", "b1", "b3", "c").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("A");
		}).forEach(s -> System.out.println("forEach: " + s));
	}

}
