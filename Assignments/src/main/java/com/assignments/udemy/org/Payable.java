/**
 * 
 */
package com.assignments.udemy.org;

/**
 * @author Somendu
 *
 * @since 06-Sep-2020
 */
public interface Payable {

	public default String payNow(String str, String str2) {

		var string = str;
		return string + " " + str2;
	}

	public abstract double raiseSalary(double percentage);

}
