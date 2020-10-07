/**
 * 
 */
package com.assignments.stream.udemy.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Somendu
 *
 * @since 07-Oct-2020
 */
public class DateToLocalDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Util.date
		 */

		Date date = new Date();

		System.out.println("Date : " + date);

		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();

		System.out.println("LocalDate : " + localDate);

		Date date1 = Date.from(localDate.atTime(LocalTime.now())
				.atZone(ZoneId.systemDefault()).toInstant());

		System.out.println("date1 : " + date1);

		/**
		 * SQL Date
		 */
		java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

		System.out.println("sqlDate : " + sqlDate);

		sqlDate.toLocalDate();

		System.out.println("sqlDate.toLocalDate() : " + sqlDate.toLocalDate());

	}

}
