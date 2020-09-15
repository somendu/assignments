/**
 * 
 */
package com.assignments.stream.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author Somendu
 *
 * @since 14-Sep-2020
 */
public class Foo {
	String name;
	List<Bar> bars = new ArrayList<>();

	Foo(String name)

	{
		this.name = name;
	}

	public static void main(String[] args) {

		List<Foo> fooList = new ArrayList<>();

		IntStream.range(3, 6)
				.forEach(num -> fooList.add(new Foo("Foo " + num)));

		fooList.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(
				new Bar("Bar" + i + " <- " + Optional.ofNullable(f.name)))));

		// fooList.stream().flatMap(f -> f.bars.stream())
		// .forEach(b -> System.out.println(b.name));

		IntStream.range(1, 4).mapToObj(i -> new Foo("Foo" + i))
				.peek(f -> IntStream.range(1, 4)
						.mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
						.forEach(f.bars::add))
				.flatMap(f -> f.bars.stream())
				.forEach(b -> System.out.println(b.name));

	}
}

class Bar {

	String name;

	Bar(String name) {
		this.name = name;
	}

}