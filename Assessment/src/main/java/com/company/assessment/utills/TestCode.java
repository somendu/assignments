/**
 * 
 */
package com.company.assessment.utills;

import org.json.JSONObject;

/**
 * @author somendu
 *
 */
public class TestCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String trackString = "{\"109347263\":\"COLLECTING\",\"123456891\":\"COLLECTING\"}";

		JSONObject jsonObject = new JSONObject(trackString);

		System.out.println(jsonObject);

	}

}
