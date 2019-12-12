package com.assignments.self.linkclass;

public class StringOps {

	public static void main(String[] args) {

		String p = "    Panda";
		String f = "  Fish  ";
		String h = "Horse      ";
		String c = "  Cat";

		String nothing = "";

		String[] stringArray = { p, f, h, c, nothing };

		for (String s : stringArray) {
//			System.out.println(s + s.length());
			s = s.trim();
//			System.out.println(s + s.length());
			System.out.println(reverseString(s));
		}

	}

	public static String reverseString(String string) {

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = string.length() - 1; i >= 0; i--) {
			stringBuilder.append(string.charAt(i));
		}

		return stringBuilder.toString();
	}

}
