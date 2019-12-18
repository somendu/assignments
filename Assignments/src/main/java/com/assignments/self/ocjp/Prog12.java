package com.assignments.self.ocjp;

public class Prog12 {
	public static void main(String args[]) {
		int _6 = 6;

		// if loop was having 2 statement with an else below. compilation fails
		if (_6 > 6) {
			System.out.print(">6");
			System.out.print(" or ");
		} else {
			System.out.print("<6");
		}
	}
}
