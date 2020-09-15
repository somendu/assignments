/**
 * 
 */
package com.assignments.udemy.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author Somendu
 *
 * @since 08-Sep-2020
 */
public class DateTimeFormatterSample {

	public static void p(Object o) {
		System.out.println(o);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LocalDate nowDate = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		p(nowDate.format(dtf));

		DateTimeFormatter dateTimeF = DateTimeFormatter.ofPattern("dd 'for today' yyyy");
		p(nowDate.format(dateTimeF));

		LocalTime localtimeNow = LocalTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		p(localtimeNow.format(timeFormatter));

	}

}
