/**
 * 
 */
package com.company.assessment.service;

import java.io.IOException;

import org.json.JSONObject;

/**
 * Pricing Service
 * 
 * @author somendu
 *
 */
public interface PricingService {

	/**
	 * Pricing Api Call
	 * 
	 * @param pricing
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public JSONObject getPricing(String pricing) throws IOException, InterruptedException;
}
