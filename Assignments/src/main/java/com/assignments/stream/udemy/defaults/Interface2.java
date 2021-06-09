/**
 * 
 */
package com.assignments.stream.udemy.defaults;

/**
 * @author Somendu
 *
 * @since 05-Oct-2020
 */
public interface Interface2 extends Interface1 {

	default void methodB() {
		System.out.println("Inside Method B");
	}

	default void methodA() {
		System.out.println("Inside Method A " + Interface2.class);
	}

	void methodD();
}