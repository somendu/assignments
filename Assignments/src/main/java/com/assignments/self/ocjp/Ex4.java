package com.assignments.self.ocjp;

class Capacitor {
	int[] array = { 1, 2, 3 };
}

class Pc {
	Capacitor cap;
}

public class Ex4 {
	public static void main(String[] args) {
		Capacitor c = new Capacitor();
		Pc p = new Pc();
		Pc p1 = p;
		p1 = null;
		p = null;
		// line 14 }}

		double i = 0;

		int doub = (int) i;

		char[] charArray = { 'A', 'B', '1', '2', '@' };
		System.out.println(charArray[charArray.length - 1]);

	}
}