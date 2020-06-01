package com.ft42.tasklist;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TestTaskList {

	@Test
	public void testString() {

		String name = "Somendu Maiti";

		String result = name.substring(0, name.lastIndexOf(" "));

		assertEquals("Somendu", result);
	}

	@Test
	public void testDateTimeStamp() {

		Timestamp timestamp = Timestamp.valueOf("2018-12-12 01:02:03.123456789");
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

		String timestampAsString = formatter.format(timestamp.toLocalDateTime());
		assertEquals("2018-12-12", timestampAsString);
	}
}
