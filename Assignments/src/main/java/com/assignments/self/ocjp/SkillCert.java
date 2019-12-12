package com.assignments.self.ocjp;

class Skillcert {
	public static void main(String args[]) {
		A ab = new B();
//insert here 
		System.out.println(A.j);
	}
}

class A {
	protected int x = 10;
	static int j = 21;
}

class B extends A {
}
