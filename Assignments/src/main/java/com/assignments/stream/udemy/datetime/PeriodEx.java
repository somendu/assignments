/**
 * 
 */
package com.assignments.stream.udemy.datetime;

import java.time.LocalDate;

/**
 * @author Somendu
 *
 * @since 07-Oct-2020
 */
public class PeriodEx {

	public static void main(String[] args) {

		var localDate = LocalDate.of(2020, 12, 30);
		var localDate2 = LocalDate.of(2020, 07, 10);

		var localDate3 = localDate2.until(localDate);

		System.out.println("Days : " + localDate3.getDays());
		System.out.println("getMonths : " + localDate3.getMonths());
		System.out.println("getYears : " + localDate3.getYears());

	}

}
