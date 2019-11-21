/**
 * 
 */
package com.assignments.cod1.seven;

import java.util.Stack;

/**
 * @author somendu
 *
 */
public class Brackets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getCount("([)()]"));

	}

	public static int getCount(String bracketString) {

		int length = bracketString.length();

		Stack<String> bracketStack = new Stack<String>();

		String[] stringTokenArray = bracketString.split("");

		for (int count = 0; count < length; count++) {
			if (stringTokenArray[count] == "(" || (stringTokenArray[count] == "{")
					|| (stringTokenArray[count] == "[")) {
				bracketStack.push(stringTokenArray[count]);
			} else if (bracketStack.size() == 0) {
				return 0;
			}

			String peek = bracketStack.peek();

			if (((peek == "(") && (stringTokenArray[count] == ")"))
					|| ((peek == "{") && (stringTokenArray[count] == "}"))
					|| ((peek == "[") && (stringTokenArray[count] == "]"))) {
				bracketStack.pop();
			} else {
				return 0;
			}
		}

		return (bracketStack.size() == 0 ? 1 : 0);
	}
}
