/**
 * 
 */
package com.assignments.stream.udemy.datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author Somendu
 *
 * @since 07-Oct-2020
 */
public class DurationEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		var localTime = LocalTime.of(12, 8, 22);
		var localTime2 = LocalTime.of(2, 8, 22);

		var minutes = localTime2.until(localTime, ChronoUnit.MINUTES);
		System.out.println("Dif : " + minutes);

		Duration duration = Duration.between(localTime2, localTime);
		System.out.println("Duration : " + duration.toMinutes());

	}

}
