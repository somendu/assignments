package com.company.assessment.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.assessment.service.AsyncService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
@EnableScheduling
public class MainController {

	@Autowired
	private AsyncService asyncService;

	private long startTime = System.currentTimeMillis();

	@PostMapping("/aggregation")
	@ApiOperation(value = "Aggregation Api", notes = "The combined api result", response = ResponseEntity.class)

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
		Map<String, Object> resultMap = new HashMap<String, Object>();

		JSONObject pricingObject = new JSONObject();
		JSONObject trackObject = new JSONObject();
		JSONObject shipmentsObject = new JSONObject();

		CompletableFuture<JSONObject> pricingCompletable = new CompletableFuture<JSONObject>();
		CompletableFuture<JSONObject> trackCompletable = new CompletableFuture<JSONObject>();
		CompletableFuture<JSONObject> shipmentCompletable = new CompletableFuture<JSONObject>();

		try {

			// TODO Call Pricing API using resttemplate
			if (pricing != null) {

//				pricingObject = pricingService.getPricing(pricing);
//				apiMap.put("pricing", pricingObject.toMap());

				pricingCompletable = asyncService.getPricing(pricing);
				resultMap.put("pricing", pricingCompletable.get().toMap());
			}

			// TODO Call Track API using resttemplate
			if (track != null) {
//				trackObject = trackService.getTrack(track);
//				apiMap.put("track", trackObject.toMap());

				trackCompletable = asyncService.getTrack(track);
				resultMap.put("track", trackCompletable.get().toMap());

			}

			// TODO Call Shipment API using resttemplate
			// TODO Need to set timer
			if (shipments != null) {
//				shipmentsObject = shipmentService.getShipments(shipments);
//				apiMap.put("shipments", shipmentsObject.toMap());

				shipmentCompletable = asyncService.getShipments(shipments);
				resultMap.put("shipments", shipmentCompletable.get().toMap());
			}

		} catch (IOException | InterruptedException | ExecutionException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);

	}

	@Scheduled(fixedRate = 5000)
	public void callThread() {

		long diff = (System.currentTimeMillis() - startTime);

		if (diff > 5) {

		}

	}

}
