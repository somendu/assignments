/**
 * 
 */
package com.assignments.stream.udemy.parallelstreams;

import lombok.Data;

/**
 * @author Somendu
 *
 * @since 02-Oct-2020
 */
@Data
public class Sum {
	private int total;

	public void printSm(int sum) {
		total += sum;
	}
}
