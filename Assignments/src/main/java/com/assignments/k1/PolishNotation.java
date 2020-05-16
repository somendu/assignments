/**
 * 
 */
package com.assignments.k1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author somendu
 *
 */
public class PolishNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(polishNotationUsingStack("5 1 2 + 4 * + 3 -"));

		System.out.println(polishNotationUsingDeque("5 1 2 + 4 * + 3 -"));

		System.out.println(polishNotationUsingDequeIfElse("5 1 2 + 4 * + 3 -"));

	}

	public static double polishNotationUsingStack(String expr) {

		String[] stringTokenArray = expr.split(" ");
		double finalOutput = 0.0;
		if (expr.length() == 0) {
			return finalOutput;
		}

		String operations = "+-*/";

		Stack<String> stringStack = new Stack<String>();

		for (String stringToken : stringTokenArray)

		{
			if (!operations.contains(stringToken)) {
				stringStack.push(stringToken);
			} else {
				double first = Double.valueOf(stringStack.pop());
				double second = Double.valueOf(stringStack.pop());

				int charIndex = operations.indexOf(stringToken);

				switch (charIndex) {
				case 0:
					stringStack.push(String.valueOf(first + second));
					break;
				case 1:
					stringStack.push(String.valueOf(second - first));
					break;
				case 2:
					stringStack.push(String.valueOf(first * second));
					break;
				case 3:
					stringStack.push(String.valueOf(second / first));
					break;

				}
			}
		}

		finalOutput = Double.valueOf(stringStack.pop());

		return finalOutput;
	}

	public static double polishNotationUsingDeque(String expr) {

		String[] stringTokenArray = expr.split(" ");

		double finalOutput = 0.0;

		if (expr.length() == 0) {

			return finalOutput;

		}

		String operations = "+-*/";

		Deque<String> stringStack = new ArrayDeque<String>();

		for (String stringToken : stringTokenArray)

		{
			if (!operations.contains(stringToken)) {

				stringStack.push(stringToken);

			} else {

				double first = Double.valueOf(stringStack.pop());

				double second = Double.valueOf(stringStack.pop());

				int charIndex = operations.indexOf(stringToken);

				switch (charIndex) {
				case 0:
					stringStack.push(String.valueOf(first + second));
					break;
				case 1:
					stringStack.push(String.valueOf(second - first));
					break;
				case 2:
					stringStack.push(String.valueOf(first * second));
					break;
				case 3:
					stringStack.push(String.valueOf(second / first));
					break;

				}
			}
		}

		finalOutput = Double.valueOf(stringStack.pop());

		return finalOutput;
	}

	public static double polishNotationUsingDequeIfElse(String expr) {

		String[] stringTokenArray = expr.split(" ");

		double finalOutput = 0.0;

		if (expr.length() == 0) {

			return finalOutput;

		}

		String operations = "+-*/";

		Deque<String> stringStack = new ArrayDeque<String>();

		for (String stringToken : stringTokenArray)

		{
			if (!operations.contains(stringToken)) {

				stringStack.push(stringToken);

			} else {

				double first = Double.valueOf(stringStack.pop());

				double second = Double.valueOf(stringStack.pop());

				int charIndex = operations.indexOf(stringToken);

				if (charIndex == 0) {

					stringStack.push(String.valueOf(first + second));

				} else if (charIndex == 1) {

					stringStack.push(String.valueOf(second - first));

				} else if (charIndex == 2) {

					stringStack.push(String.valueOf(first * second));

				} else if (charIndex == 3) {

					stringStack.push(String.valueOf(second / first));
				}
			}
		}

		finalOutput = Double.valueOf(stringStack.pop());

		return finalOutput;
	}

}
