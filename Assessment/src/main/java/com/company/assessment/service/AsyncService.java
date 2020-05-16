package com.company.assessment.service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import org.json.JSONObject;

/**
 *
 * Async Service
 * 
 * @author somendu
 *
 */
public interface AsyncService {

	/**
	 * Shipment API Call
	 * 
	 * @param shipments
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public CompletableFuture<JSONObject> getShipments(String shipments) throws IOException, InterruptedException;

	/**
	 * Pricing API Call
	 * 
	 * @param pricing
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public CompletableFuture<JSONObject> getPricing(String pricing) throws IOException, InterruptedException;

	/**
	 * Traking API Call
	 * 
	 * @param track
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public CompletableFuture<JSONObject> getTrack(String track) throws IOException, InterruptedException;

}
