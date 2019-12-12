package com.assignments.self.ocjp;

class Sup {
	protected void method() {
		System.out.print("Sup");
	}
}

public class Sub extends Sup {
	// override method () here
	public final void method() {
		System.out.println("here");
	}

	public static void main(String args[]) {
		Sup sub = new Sub();
		sub.method();

		int i = 0XE;
	}
}
