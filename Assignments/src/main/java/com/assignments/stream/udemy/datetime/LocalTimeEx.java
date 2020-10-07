/**
 * 
 */
package com.assignments.stream.udemy.datetime;

import java.time.LocalTime;

/**
 * @author Somendu
 *
 * @since 06-Oct-2020
 */
public class LocalTimeEx {

	public static void main(String[] args) {

		var localTime = LocalTime.now();
		System.out.println("Localtime : " + localTime);

		var localTime1 = LocalTime.of(23, 23);
		System.out.println("LocalTime.of(23, 23) : " + localTime1);

		var localTime2 = LocalTime.of(23, 23, 34);
		System.out.println("LocalTime.of(23, 23, 34) : " + localTime2);

		var localTime3 = LocalTime.of(23, 23, 34, 222323121);
		System.out
				.println("LocalTime.of(23, 23, 34, 222323121) : " + localTime3);

		/*
		 * Getting values from Local time instance
		 */

		var hour = localTime.getHour();
		System.out.println("Localtime Hour : " + hour);

		var minute = localTime.getMinute();
		System.out.println("Localtime minute : " + minute);

		var second = localTime.getSecond();
		System.out.println("Localtime second : " + second);

		var secondOfTheday = localTime.toSecondOfDay();
		System.out.println("secondOfTheday : " + secondOfTheday);
	}

}
