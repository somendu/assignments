package com.company.assessment.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.assessment.service.PricingService;
import com.company.assessment.service.ShipmentService;
import com.company.assessment.service.TrackService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Controller Class for creating end points
 * 
 * @author somendu
 *
 */
@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class MainController {

	@Autowired
	private PricingService pricingService;

	@Autowired
	private TrackService trackService;

	@Autowired
	private ShipmentService shipmentService;

	// Sessions Method for Setting Session to Start
	@PostMapping("/aggregation")
	@ApiOperation(value = "Aggregation Api", notes = "Aggregated API Notes", response = ResponseEntity.class)

	/**
	 * Aggregation end point
	 * 
	 * @param pricing
	 * @param track
	 * @param shipments
	 * @return
	 */
	public ResponseEntity<?> getAggregation(@RequestParam(name = "pricing", required = false) String pricing,
			@RequestParam(name = "track", required = false) String track,
			@RequestParam(name = "shipments", required = false) String shipments) {

		// TODO These string will combine to for json
		Map<String, Object> apiMap = new HashMap<String, Object>();

		JSONObject pricingObject = new JSONObject();
		JSONObject trackObject = new JSONObject();
		JSONObject shipmentsObject = new JSONObject();

		try {

			// TODO Call Pricing API using resttemplate
			if (pricing != null) {
				pricingObject = pricingService.getPricing(pricing);
				apiMap.put("pricing", pricingObject.toMap());
			}

			// TODO Call Track API using resttemplate
			if (track != null) {
				trackObject = trackService.getTrack(track);
				apiMap.put("track", trackObject.toMap());

			}

			// TODO Call Shipment API using resttemplate
			// TODO Need to set timer
			if (shipments != null) {
				shipmentsObject = shipmentService.getShipments(shipments);
				apiMap.put("shipments", shipmentsObject.toMap());
			}

		} catch (IOException | InterruptedException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Map<String, Object>>(apiMap, HttpStatus.OK);

	}

}
