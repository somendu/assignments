/**
 * 
 */
package com.assignments.stream.udemy.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author Somendu
 *
 * @since 07-Oct-2020
 */
public class TimeZoneEx {

	public static void main(String[] args) {

		var zonedDateTime = ZonedDateTime.now();

		System.out.println("Zoned Date Time : " + zonedDateTime);

		System.out.println("Offset : " + zonedDateTime.getOffset());

		System.out.println("Zone ID : " + zonedDateTime.getZone());

		// System.out.println(ZoneId.getAvailableZoneIds());

		// ZoneId.getAvailableZoneIds().stream()
		// .forEach(zone -> System.out.println(zone));

		System.out.println("Number of Zones : "
				+ ZoneId.getAvailableZoneIds().stream().count());

		System.out.println(
				"Number of Zones : " + ZoneId.getAvailableZoneIds().size());

		System.out.println("Chicago Time : "
				+ ZonedDateTime.now(ZoneId.of("America/Chicago")));

		/*
		 * Convert from local date time, instant to zoned date time
		 */

		var localDateTime3 = LocalDateTime.now();

		System.out.println(localDateTime3);
		var zonedDateTime1 = localDateTime3
				.atZone(ZoneId.of("America/Chicago"));

		System.out.println(zonedDateTime1);

	}

}
