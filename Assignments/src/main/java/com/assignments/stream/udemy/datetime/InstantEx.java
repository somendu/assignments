/**
 * 
 */
package com.assignments.stream.udemy.datetime;

import java.time.Instant;

/**
 * @author Somendu
 *
 * @since 07-Oct-2020
 */
public class InstantEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		var instant = Instant.now();

		System.out.println("Instant : " + instant);

		System.out.println(
				"Instant.getEpochSecond() : " + instant.getEpochSecond());

	}

}
