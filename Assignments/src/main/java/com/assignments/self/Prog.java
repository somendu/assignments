/**
 * 
 */
package com.assignments.self;

/**
 * @author somendu
 *
 */
class A {
	static void method() {
		System.out.print(" A B");
	}
}

class B extends A {
	protected static void method() {
		System.out.print(" C D");
	}
}

class Prog {
	public static void main(String[] args) {
		A a = new B();
		a.method();
	}
}
