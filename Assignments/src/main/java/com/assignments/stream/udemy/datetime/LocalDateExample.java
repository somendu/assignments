/**
 * 
 */
package com.assignments.stream.udemy.datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Somendu
 *
 * @since 05-Oct-2020
 */
public class LocalDateExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		var localDate1 = LocalDate.now();

		System.out.println(localDate1);

		LocalDate localDate2 = LocalDate.ofYearDay(1984, 338);
		System.out.println(localDate2);

		LocalDate localDate3 = LocalDate.of(1984, 12, 3);
		System.out.println(localDate3);

		System.out.println("getMonth: " + localDate1.getMonth());
		System.out.println("getMonthValue: " + localDate1.getMonthValue());
		System.out.println("getDayOfMonth: " + localDate1.getDayOfMonth());
		System.out.println("getDayOfYear: " + localDate1.getDayOfYear());

		System.out.println("ChronoField.DAY_OF_WEEK  :"
				+ localDate1.get(ChronoField.DAY_OF_WEEK));

		/**
		 * Modifying local date
		 */

		System.out.println("plusDays : " + localDate1.plusDays(3));
		System.out.println("plusMonths : " + localDate1.plusMonths(2));
		System.out.println("minusDays : " + localDate1.minusDays(4));
		System.out.println("withYear : " + localDate1.withYear(2021));
		System.out.println("with ChronoField : "
				+ localDate1.with(ChronoField.YEAR, 2022));

		System.out.println("With TemporalAdjusters : "
				+ localDate1.with(TemporalAdjusters.firstDayOfMonth()));

		System.out.println(localDate1.minus(1, ChronoUnit.YEARS));

		/**
		 * Additional Support
		 */

		System.out.println("LeapYear : " + localDate1.isLeapYear());
		System.out.println(
				"LeapYear : " + LocalDate.ofYearDay(2021, 01).isLeapYear());

		System.out.println("isEqual : " + localDate1.isEqual(localDate2));

		System.out.println("isAfter : " + localDate2.isAfter(localDate3));

		System.out.println("isBefore : " + localDate3.isBefore(localDate1));

		/**
		 * Unsupported
		 */

		System.out.println("isSupported MINUTES :"
				+ localDate1.isSupported(ChronoUnit.MINUTES));

		System.out.println("isSupported YEARS :"
				+ localDate1.isSupported(ChronoUnit.YEARS));
	}

}
