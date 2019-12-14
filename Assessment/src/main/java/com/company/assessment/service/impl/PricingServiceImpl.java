/**
 * 
 */
package com.company.assessment.service.impl;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.company.assessment.config.AssessApi;
import com.company.assessment.service.PricingService;

import lombok.RequiredArgsConstructor;

/**
 * Implementation class for Pricing Service
 * 
 * @author somendu
 *
 */
@Component
@RequiredArgsConstructor
public class PricingServiceImpl implements PricingService {

	private final RestTemplate restTemplate;

	private final AssessApi assessApi;

	@Override
	public JSONObject getPricing(String pricing) throws IOException, InterruptedException {

		var pricingString = restTemplate.getForObject(
				assessApi.getServer() + ":" + assessApi.getPort() + assessApi.getPricing() + "?q=" + pricing,
				String.class);

		JSONObject jsonObject = new JSONObject(pricingString);

		return jsonObject;
	}

}
