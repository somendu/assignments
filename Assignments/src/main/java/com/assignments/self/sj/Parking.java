/**
 * 
 */
package com.assignments.self.sj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @Since 19-Apr-2021
 */
public class Parking {

	private static String vehicle_type = "";
	private static String in_time = "";
	private static String out_time = "";
	private static double totalCharge = 0.0;

	public static void main(String[] args) {

		Parking parking = new Parking();

		// Input the user values

		// Call parking.computeParking()

		// Pass the value from above to parking.total_collection()

	}

	private boolean validateTime(String time) {
		String regex = "([01]?[0-9]|2[0-3]) [0-5][0-9]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(time);
		return m.matches();
	}

	private boolean validateVehicleTpe(String vehicle_type) {
		if (vehicle_type == "C" || vehicle_type == "T") {
			return true;
		} else
			return false;
	}

	private double compute_parking(String vehicle_type, String in_time, String out_time) throws Exception {

		if (validateVehicleTpe(vehicle_type) && validateTime(in_time) && validateTime(out_time)) {
			// Calculate the time difference

			in_time = "15 30";
			out_time = "24 09";

			// Compute parking

		} else
			throw new Exception("Error in Input");

		return 0;
	}

	private static double total_collection(Double parkingCharge) {

		totalCharge = totalCharge + parkingCharge;

		return totalCharge;
	}
}
