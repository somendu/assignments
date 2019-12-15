/**
 * 
 */
package com.company.assessment.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.company.assessment.config.AssessProperties;
import com.company.assessment.service.PricingService;

import lombok.RequiredArgsConstructor;

/**
 * Implementation class for Pricing Service
 * 
 * @author somendu
 *
 */
@Service
@RequiredArgsConstructor
public class PricingServiceImpl implements PricingService {

	private final RestTemplate restTemplate;

	private final AssessProperties assessApi;

	// Store the value in static (as a queue)
	private static final List<String> pricingList = new ArrayList<String>();

	@Override
	public JSONObject getPricing(String pricing) throws IOException, InterruptedException {

		String[] pricingArray = pricing.split(",");

		for (String string : pricingArray) {
			if (!string.equalsIgnoreCase("")) {
				pricingList.add(string);
			}
		}

		JSONObject jsonObject = new JSONObject();

		// Need to pass the comma (,) separated value
		String pricingString = pricingList.stream().map(s -> String.valueOf(s)).collect(Collectors.joining(","));

		if (pricingArray.length >= 5 || pricingList.size() >= 5)

		{
			var pricingStringResult = restTemplate.getForObject(
					assessApi.getServer() + ":" + assessApi.getPort() + assessApi.getPricing() + "?q=" + pricingString,
					String.class);

			jsonObject = new JSONObject(pricingStringResult);
			// Since cap of 5 so clear the list when more than 5 values
			pricingList.clear();

		}

		return jsonObject;
	}

}
