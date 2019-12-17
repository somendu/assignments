/**
 * 
 */
package com.assignments.self.codeclinic.location;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

/**
 * @author somendu
 *
 */
public class LocationFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String location = "";
		JSONObject jsonObject = null;
		String mapLink = "";

		location = getLocation("2601:246:5100:3440:1cab:f37b:418f:2d34");
		jsonObject = new JSONObject(location);

		mapLink = "https://www.google.com/maps/?q=" + jsonObject.getString("loc");

		System.out.println("Your City : " + jsonObject.getString("city"));
		System.out.println("Your Country : " + jsonObject.getString("country"));
		System.out.println("Your Location : " + mapLink);
		System.out.println("Your Time Zone : " + jsonObject.getString("timezone"));
		System.out.println("Your Region : " + jsonObject.getString("region"));

	}

//	 Data {country=NL, loc=51.9225,4.4792, hostname=ip-213-127-67-119.ip.prioritytelecom.net, 
	// city=Rotterdam, org=AS6830 Liberty Global B.V., timezone=Europe/Amsterdam,
	// ip=213.127.67.119,
	// postal=3012, readme=https://ipinfo.io/missingauth, region=South Holland}

	public static String getLocation(String ip) {

		URL url;
		String respoonse = "";

		if (!ip.equals(""))
			ip = "/" + ip;

		try {

			String a = "https://ipinfo.io" + ip + "/json";

			url = new URL(a);

			URLConnection urlConnection = url.openConnection();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String inputLine;

			while ((inputLine = bufferedReader.readLine()) != null) {
				respoonse = respoonse + inputLine;
			}

			bufferedReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return respoonse;
	}

}
