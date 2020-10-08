/**
 * 
 */
package com.assignments.stream.udemy.defaults;

/**
 * @author Somendu
 *
 * @since 05-Oct-2020
 */
public interface Interface1 {

	default void methodA() {
		System.out.println("Inside Method A " + Interface1.class);
	}
}
