/**
 * 
 */
package com.assignments.self.ocjp;

/**
 * @author somendu
 *
 */
class Person {
	Person() {
		System.out.print("CP ");
	}

	static {
		System.out.print("SP ");
	}
}

class Manager extends Person {
	Manager() {
		System.out.print("CT ");
	}

	{
		System.out.print("IT ");
	}
}

class Program {
	public static void main(String[] args) {
		Person p1 = new Manager();
	}
}