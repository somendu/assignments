/**
 * 
 */
package com.company.assessment.service.impl;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.company.assessment.service.AsyncService;
import com.company.assessment.service.PricingService;
import com.company.assessment.service.ShipmentService;
import com.company.assessment.service.TrackService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Implementation class for async service
 * 
 * @author somendu
 *
 */
@Service
@RequiredArgsConstructor
public class AsyncServiceImpl implements AsyncService {

	@Autowired
	private PricingService pricingService;

	@Autowired
	private TrackService trackService;

	@Autowired
	private ShipmentService shipmentService;

	@Async("shipmentsExecutor")
	@Override
	public CompletableFuture<JSONObject> getShipments(String shipments) throws IOException, InterruptedException {

		var shipmentRecords = shipmentService.getShipments(shipments);

		return CompletableFuture.completedFuture(shipmentRecords);
	}

	@Async("pricingExecutor")
	@Override
	public CompletableFuture<JSONObject> getPricing(String pricing) throws IOException, InterruptedException {

		var pricingRecordds = pricingService.getPricing(pricing);

		return CompletableFuture.completedFuture(pricingRecordds);
	}

	@Async("trackExecutor")
	@Override
	public CompletableFuture<JSONObject> getTrack(String track) throws IOException, InterruptedException {

		var trackRecords = trackService.getTrack(track);

		return CompletableFuture.completedFuture(trackRecords);
	}

}
