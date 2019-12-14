/**
 * 
 */
package com.company.assessment.service.impl;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.company.assessment.config.AssessApi;
import com.company.assessment.service.ShipmentService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Implementation class for shipment service
 * 
 * @author somendu
 *
 */
@Component
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

	private final RestTemplate restTemplate;

	private final AssessApi assessApi;

	@Override
	public JSONObject getShipments(String shipments) throws IOException, InterruptedException {

		var shipmentObjects = restTemplate.getForObject(
				assessApi.getServer() + ":" + assessApi.getPort() + assessApi.getShipments() + "?q=" + shipments,
				String.class);

		JSONObject jsonObject = new JSONObject(shipmentObjects);

		return jsonObject;
	}

}
