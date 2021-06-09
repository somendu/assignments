/**
 * 
 */
package com.assignments.self.sj;

/**
 * @author Somendu Maiti
 *
 * @Since 25-Apr-2021
 */
public class StaticTest {

	static int x = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(x);

	}

	static {
		System.out.println(x + " ");
	}

}
