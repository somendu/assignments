package com.ft42.tasklist;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.Test;

import com.ft42.tasklist.support.TaskUtil;

public class TestTaskList {

	@Test
	public void testString() {

		String name = "Somendu Maiti";

		String result = name.substring(0, name.lastIndexOf(" "));

		assertEquals("Somendu", result);
	}

	@Test
	public void testSQLDate() {

		Date date = Date.valueOf("2018-12-12");
		assertEquals(date, TaskUtil.getDateToSQLDate("12-12-2018"));

	}

	@Test
	public void testDateString() {

		Date date = Date.valueOf("2018-09-12");

		Timestamp sqlDateTimestamp = new Timestamp(date.getTime());

		assertEquals("12-09-2018", TaskUtil.getSQLDateToDate(sqlDateTimestamp));

	}
}
