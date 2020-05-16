/**
 * 
 */
package com.assignments.self.codeclinic.weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author somendu
 *
 */
public class BPTrend {

	ArrayList<WeatherEntry> collectedData = new ArrayList<>();

	public void readData(String fileName) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");

		try {
			BufferedReader buf = new BufferedReader(new FileReader(fileName));
			String line = null;
			String[] wordsArray;
			boolean skipFirstLine = true;

			while (true) {
				line = buf.readLine();

				if (skipFirstLine) {
					skipFirstLine = false;
					continue;
				}

				if (line == null) {
					break;
				} else {

					wordsArray = line.split("\t");

					// Load Data
					WeatherEntry weatherEntry = new WeatherEntry();

					weatherEntry.setPressure(Float.valueOf(wordsArray[2]));
					weatherEntry.setHumidity(Float.valueOf(wordsArray[4]));
					weatherEntry.setWhen(dateFormat.parse(wordsArray[0]));

					collectedData.add(weatherEntry);

				}
			}
			buf.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public String doCalculation(String from, String to) {

		String result = "";

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Date date1 = null;
		Date date2 = null;

		try {

			date1 = dateFormat.parse(from);
			date2 = dateFormat.parse(to);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		result = "From " + dateFormat.format(date1) + "To " + dateFormat.format(date2) + "\n";

		WeatherEntry y1 = null;
		WeatherEntry y2 = null;
		int index = 0, x1 = 0, x2 = 0;

		for (WeatherEntry entry : collectedData) {

			if ((y1 == null) && entry.getWhen().compareTo(date1) >= 0) {
				y1 = entry;
				x1 = index;
			}

			if (entry.getWhen().compareTo(date2) >= 0) {
				x2 = index;
				y2 = entry;

			}

			index++;
		}

		float slope = (y2.getPressure() - y1.getPressure()) / (x2 - x1);

		result = result + "Pressure Slope is : " + String.format("%6f", slope) + "\n The forecast is: ";

		if (slope < 0)
			result = result + "inclement weather is loosing in";
		if (slope == 0)
			result = result + "cuurent condition persist";
		if (slope > 0)
			result = result + "improving conditions";

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BPTrend bpTrend = new BPTrend();

		bpTrend.readData("fileplace/data.text");

		System.out.println("Read Data Size: " + bpTrend.collectedData.size());

		String from = "2012/01/01 00:30:00";
		String to = "2012/01/01 02:30:00";

		System.out.println(bpTrend.doCalculation(from, to));

	}

}
