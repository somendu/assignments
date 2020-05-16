package com.assignments.self.ocjp;

public class Prog14 {

	public static void main(String[] args) {
		for (int x = 9; x > 0; x--) {
			for (int y = 8; x > y; y++) {
				System.out.print(x + y);
			}
		}

		int x = 1;
		if (x > 1) {
			System.out.println(">");
		} else if (x < 3) {
			System.out.println("<");
		} else {
			System.out.println("=");
		}

		System.out.println(x > 1 ? ">" : x < 1 ? "<" : "=");
	}

}
