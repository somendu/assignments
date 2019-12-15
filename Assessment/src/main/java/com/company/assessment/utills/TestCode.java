/**
 * 
 */
package com.company.assessment.utills;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author somendu
 *
 */
public class TestCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> pricingList = new ArrayList<String>();

		pricingList.add("Q");
		pricingList.add("R");
		pricingList.add("S");

//		JSONObject jsonObject = new JSONObject(trackString);

		String result = pricingList.stream().map(s -> String.valueOf(s)).collect(Collectors.joining(","));

		System.out.println(result);

	}

}
