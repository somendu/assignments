/**
 * 
 */
package com.company.assessment.service.impl;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.company.assessment.config.AssessApi;
import com.company.assessment.service.TrackService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Implementation class for track service
 * 
 * @author somendu
 *
 */
@Component
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

	private final RestTemplate restTemplate;

	private final AssessApi assessApi;

	@Override
	public JSONObject getTrack(String track) throws IOException, InterruptedException {

		var tracking = restTemplate.getForObject(
				assessApi.getServer() + ":" + assessApi.getPort() + assessApi.getTrack() + "?q=" + track, String.class);

		JSONObject jsonObject = new JSONObject(tracking);

		return jsonObject;
	}

}
