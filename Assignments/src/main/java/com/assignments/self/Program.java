/**
 * 
 */
package com.assignments.self;

/**
 * @author somendu
 *
 */
class Program {
	static {
		x = 10;
		y = 5;
	}
	final static int x;
	final static int y;

	public static void main(String args[]) {
		try {
			Program pr = new Program();
			int c = pr.x / y;
			System.out.print(c);
		} catch (ArithmeticException E) {
			System.out.print("Arithmetic Exception");
		}
	}
}
