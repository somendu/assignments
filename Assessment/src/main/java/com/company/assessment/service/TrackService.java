/**
 * 
 */
package com.company.assessment.service;

import java.io.IOException;

import org.json.JSONObject;

/**
 * 
 * Track Service
 * 
 * @author somendu
 *
 */
public interface TrackService {

	/**
	 * Get Tracking Api return call
	 * 
	 * @param track
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public JSONObject getTrack(String track) throws IOException, InterruptedException;

}
