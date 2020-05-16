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
import com.company.assessment.service.ShipmentService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Implementation class for shipment service
 * 
 * @author somendu
 *
 */
@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

	private final RestTemplate restTemplate;

	private final AssessProperties assessApi;

	// Store the value in static (as a queue)
	private static final List<String> shipmentsList = new ArrayList<String>();

	@Override
	public JSONObject getShipments(String shipments) throws IOException, InterruptedException {

		// Storing for keeping in queue
		String[] shipmentArray = shipments.split(",");

		for (String string : shipmentArray) {
			if (!string.equalsIgnoreCase("")) {
				shipmentsList.add(string);
			}
		}

		JSONObject jsonObject = new JSONObject();

		// Need to pass the comma (,) separated value
		String result = shipmentsList.stream().map(s -> String.valueOf(s)).collect(Collectors.joining(","));

		if (shipmentArray.length >= 5 || shipmentsList.size() >= 5)

		{
			var shipmentObjects = restTemplate.getForObject(
					assessApi.getServer() + ":" + assessApi.getPort() + assessApi.getShipments() + "?q=" + result,
					String.class);

			jsonObject = new JSONObject(shipmentObjects);

			// Since cap of 5 so clear the list when more than 5 values
			shipmentsList.clear();
		}

		return jsonObject;
	}

}
