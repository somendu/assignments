/**
 * 
 */
package com.assignments.self.chegg;

/**
 * @author Somendu
 *
 * @since 08-Oct-2020
 */
public class Main {

	public static void main(String args[]) {

		IntList a = new IntList(null);

		IntList b = a.cons(2);

		IntList c = b.cons(1);

		IntList d = c.cons(3);

		int x = a.length() + b.length() + c.length() + d.length();

		a.print();

		b.print();

		c.print();

		d.print();

		System.out.println(x);

		// IntList.sort(a, b, c, d);

	}

}
