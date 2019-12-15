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

		Map<String, Object> resultMap = new HashMap<String, Object>();

		CompletableFuture<JSONObject> pricingCompletable = new CompletableFuture<JSONObject>();
		CompletableFuture<JSONObject> trackCompletable = new CompletableFuture<JSONObject>();
		CompletableFuture<JSONObject> shipmentCompletable = new CompletableFuture<JSONObject>();

		try {

			if (pricing != null) {
				pricingCompletable = asyncService.getPricing(pricing);
				resultMap.put("pricing", pricingCompletable.get().toMap());
			}

			if (track != null) {
				trackCompletable = asyncService.getTrack(track);
				resultMap.put("track", trackCompletable.get().toMap());
			}

			if (shipments != null) {
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
