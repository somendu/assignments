package com.assignments.self.sj;

import java.util.Scanner;

public class TrainBasics {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double d, f, g, h, j;
		int t, y;
		boolean r;
		System.out.println("enter your values to compare them with each other");
		d = scan.nextDouble();
		f = scan.nextDouble();
		r = d > f;
		if (!r) {
			System.out.println("second tem is larger than first");
		} else {
			System.out.println("first term is larger than the second term");
		}
		g = d * f;
		System.out.println("here is the product of first and the second term");
		System.out.println(g);
		h = d - f;
		j = f - d;
		System.out.println("This is the integer value when you subtract second term from first");
		System.out.println(h);
		System.out.println("This is the integer value when you subtract first term from second term");
		System.out.println(j);
		if (d == 1 + f) {
			System.out.println("both terms sre having difference of 1");
		} else if (f == d + 1) {
			System.out.println("both terms sre having difference of 1");
		} else {
			System.out.println("numbers have difference which is more than unit value 1");
		}
		System.out.println("Is it true that you want to enter two more values");
		String m = "true";
		{
			m = scan.next();
		}
		if (!m.equalsIgnoreCase("true")) {
			System.out.println("no worries");
		} else {
			System.out.println("enter new values");
			y = scan.nextInt();
			t = scan.nextInt();
		}

		scan.close();
	}
}
