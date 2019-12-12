package com.assignments.self.linkclass;

public class StringLiteral {

	public static void main(String[] args) {

		String literal = "hello";

		String obj = new String("hello");

		String otherLiteral = "hello";

		System.out.println(literal == obj);
		System.out.println(literal == otherLiteral);
		System.out.println(literal.equals(obj));
		System.out.println(literal.equals(otherLiteral));

	}

}
