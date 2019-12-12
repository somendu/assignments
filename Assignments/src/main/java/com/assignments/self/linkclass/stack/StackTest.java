package com.assignments.self.linkclass.stack;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {

		Stack<String> stringStack = new Stack<String>();

		String card1 = "Jack : Diamond";
		String card2 = "8 : Aces";
		String card3 = "2 : Clubs";
		String card4 = "5 : Hearts";

		stringStack.push(card1);
		stringStack.push(card2);
		stringStack.push(card3);
		stringStack.push(card4);

		System.out.println(stringStack);

		System.out.println("Top : " + stringStack.peek());

		System.out.println("Size : " + stringStack.size());

		while (!stringStack.empty()) {
			System.out.println("Removed: " + stringStack.pop());
		}

	}

}
