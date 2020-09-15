/**
 * 
 */
package com.assignments.udemy.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

/**
 * 
 * Date Time
 * 
 * @author Somendu
 *
 * @since 08-Sep-2020
 */
public class DateTimeSample {

	public static void p(Object o) {
		System.out.println(o);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LocalDate nowDate = LocalDate.now();
		p(nowDate);

		LocalDate birthDate = LocalDate.of(1984, Month.DECEMBER, 3);
		p(birthDate);

		LocalDate aWeekFromNow = nowDate.plusWeeks(1);
		p(aWeekFromNow);

		nowDate = nowDate.minusWeeks(1);
		p(nowDate);

		LocalTime nowTime = LocalTime.now();
		p(nowTime);

		LocalTime timeBirth = LocalTime.of(12, 20, 20);
		p(timeBirth);

		LocalTime anHourFromNow = nowTime.plusHours(1);
		p(anHourFromNow);

		LocalTime anHourEarlier = nowTime.minusHours(1);
		p(anHourEarlier);

		LocalDateTime nowDateTime = LocalDateTime.now();
		p(nowDateTime);

		LocalDateTime birthDateTime = LocalDateTime.of(1984, Month.DECEMBER, 03, 03, 55, 00);
		p(birthDateTime);

		Period period = Period.of(3, 5, 12);

		nowDateTime = nowDateTime.minus(period);

		p(nowDateTime);

		nowDateTime = nowDateTime.plus(period);

		p(nowDateTime);

		Period age = Period.between(birthDate, nowDate);
		p(age);
	}

}
