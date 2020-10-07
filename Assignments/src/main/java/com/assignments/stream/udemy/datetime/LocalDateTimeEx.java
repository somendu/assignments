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
 * @since 07-Oct-2020
 */
public class LocalDateTimeEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		var localDateTime = LocalDateTime.now();
		System.out.println("Local Date Time : " + localDateTime);

		var localDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.now());

		System.out.println(
				"LocalDate.now(), LocalTime.now() : " + localDateTime1);

		// convertin localdate, localtime to localdatetime and viceversa
		var localDate = LocalDate.of(2020, 12, 03);
		var localDateTime2 = localDate.atTime(01, 21);
		System.out.println("LocalDate : " + localDateTime2);

		var localTime = LocalTime.of(01, 21);
		var localDateTime3 = localTime.atDate(localDate);
		System.out.println("localTime : " + localDateTime3);

	}

}
