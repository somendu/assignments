package com.assignments.self.linkclass;

public class StringArrayTest {

	public static void main(String[] args) {

		String text = "Our highest priority is to satisfy the customer through early and continuous delivery\n"
				+ "of valuable software."
				+ "Welcome changing requirements, even late in development. Agile processes harness change for the customer's competitive advantage.";

		String[] textSentence = text.split("\\.");

		System.out.println(textSentence.length);

		// How Many Words

		String[] wordsArray = text.split(" ");

		System.out.println(wordsArray.length);

		// How Many characters
		System.out.println(text.length());

	}

}
