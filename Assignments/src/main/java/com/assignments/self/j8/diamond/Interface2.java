/**
 * 
 */
package com.assignments.self.j8.diamond;

/**
 * @author Somendu
 *
 * @since 06-Aug-2020
 */
@FunctionalInterface
public interface Interface2 {

	void method2();

	default void log(String str) {
		System.out.println("I2 logging::" + str);
	}

}