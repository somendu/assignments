package com.assignments.self.ocjp;

public class Prog2 {
	public static void main(String[] args) {
		String[][] strings = { { "1", "0" }, { "Z", "8", "1" }, { "-" } };

		System.out.println(strings[0][0]);
		System.out.println(strings[1][0]);
		System.out.println(strings[0][1]);
		System.out.println(strings[2][0]);
		System.out.println(strings[1][1]);
		System.out.println(strings[1][2]);
		System.out.println(strings[0][1]);

		System.out.print(strings[0][0] + strings[1][0] + strings[0][1] + strings[2][0] + strings[1][1] + strings[1][2]
				+ strings[0][1]);

		// 1Z0-810
	}
}
