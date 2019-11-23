/**
 * 
 */
package com.assignments.pg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author somendu
 *
 */
public class DaysLater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(daysLaterArray("Thursday", 22));

	}

	public static String daysLater(String weekDay, int n) {

		String returnString = "Wrong Input";

		HashMap<String, Integer> daysMap = new HashMap<String, Integer>();

		daysMap.put("Sunday", 1);
		daysMap.put("Monday", 2);
		daysMap.put("Tuesday", 3);
		daysMap.put("Wednesday", 4);
		daysMap.put("Thursday", 5);
		daysMap.put("Friday", 6);
		daysMap.put("Saturday", 7);

		// Get the count of day
		int positionDay = daysMap.get(weekDay);

		int count = n % 7 + positionDay;

		HashMap<Integer, String> daysReturnMap = new HashMap<Integer, String>();

		daysReturnMap.put(1, "Sunday");
		daysReturnMap.put(2, "Monday");
		daysReturnMap.put(3, "Tuesday");
		daysReturnMap.put(4, "Wednesday");
		daysReturnMap.put(5, "Thursday");
		daysReturnMap.put(6, "Friday");
		daysReturnMap.put(7, "Saturday");

		// If the day key
		returnString = daysReturnMap.get(count);

		return returnString;
	}

	public static String daysLaterArray(String weekDay, int n) {

		String returnString = "";

		List<String> daysList = new ArrayList<String>();

		daysList.add("Sunday");
		daysList.add("Monday");
		daysList.add("Tuesday");
		daysList.add("Wednesday");
		daysList.add("Thursday");
		daysList.add("Friday");
		daysList.add("Saturday");

		int positionDay = daysList.indexOf(weekDay);

		int count = n % 7 + positionDay;

		// If the day key
		returnString = daysList.get(count);

		return returnString;
	}

}
