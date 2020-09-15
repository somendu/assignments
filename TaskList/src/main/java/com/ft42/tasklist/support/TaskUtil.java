/**
 * 
 */
package com.ft42.tasklist.support;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Somendu
 *
 * @since 05-Jun-2020
 */
public class TaskUtil {

	public static Date getDateToSQLDate(String dateString) {

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = new java.util.Date();
		try {
			date = sdf1.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date sqlDate = new Date(date.getTime());

		return sqlDate;

	}

	public static String getSQLDateToDate(Timestamp taskInputTimestamp) {

		Date sqlDate = new Date(taskInputTimestamp.getTime());
		sqlDate.setTime(taskInputTimestamp.getTime());
		DateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf1.format(sqlDate);

		return formattedDate;

	}
}
