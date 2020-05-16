/**
 * 
 */
package com.ft42.communic.service;

import java.io.IOException;

import org.json.JSONObject;

/**
 * 
 * Shipment Service
 * 
 * @author somendu
 *
 */
public interface ShipmentService {

	/**
	 * Calling shipment api
	 * 
	 * @param shipments
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public JSONObject getShipments(String shipments) throws IOException, InterruptedException;
}
