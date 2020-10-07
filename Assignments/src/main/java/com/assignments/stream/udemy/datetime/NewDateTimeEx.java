/**
 * 
 */
package com.assignments.stream.udemy.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Somendu
 *
 * @since 05-Oct-2020
 */
public class NewDateTimeEx {

	public static void main(String[] args) {

		// Local Date
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		// Local Time
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);

	}

}
