/**
 * 
 */
package com.assignments.self.string;

/**
 * @author somendu
 *
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String string = "THISISNEW";

		System.out.println(reverse(string));

	}

	private static String reverse(String string) {

		StringBuffer stringBuffer = new StringBuffer();

		char[] mainString = string.toCharArray();

		stringBuffer.append(mainString);

		stringBuffer = stringBuffer.reverse();

		return stringBuffer.toString();
	}

}
