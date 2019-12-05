package com.assignments.self;

class Prog2 {
	int x = 013;

	public static void main(String[] args) {
		Prog2 pr = new Prog2();
		pr.go(22);
	}

	void go(int i) {
		System.out.print(i / x);
	}
}
