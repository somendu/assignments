package com.assignments.self.ocjp;

public class Program {
	public static void main(String[] args) {
		int a[] = { 1, 2, 053, 4 };
		int b[][] = { { 1, 2, 4 }, { 2, 2, 1 }, { 0, 43, 2 } };

		System.out.println(a[2]);
		System.out.println(b[2][0]);
		System.out.println(b[2][1]);
		System.out.println(b[2][2]);

		System.out.print(a[3] == b[0][2]); // true
		System.out.print(" " + (a[2] == b[2][1]));
	}
}