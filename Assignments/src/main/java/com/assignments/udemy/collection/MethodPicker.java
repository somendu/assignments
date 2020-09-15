/**
 * 
 */
package com.assignments.udemy.collection;

/**
 * @author Somendu
 *
 * @since 09-Sep-2020
 */
public class MethodPicker {

	// Method B
	public void pickMe(long x) {
		System.out.println("long");
	}

	// Method C
	public void pickMe(Integer x) {
		System.out.println("Integer");
	}

	// Method D
	public void pickMe(int... x) {
		System.out.println("int...");
	}

	// Method E
	public void pickMe(long... x) {
		System.out.println("long...");
	}

	// Method A
	public void pickMe(int x) {
		System.out.println("int");
	}

	public static void main(String[] args) {
		MethodPicker mp = new MethodPicker();
		int x = 5;
		mp.pickMe(x);
	}
}