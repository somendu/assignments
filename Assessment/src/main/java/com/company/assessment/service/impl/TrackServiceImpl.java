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
import com.company.assessment.service.TrackService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Implementation class for track service
 * 
 * @author somendu
 *
 */
@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

	private final RestTemplate restTemplate;

	private final AssessProperties assessApi;

	// Store the value in static (as a queue)
	private static final List<String> trackList = new ArrayList<String>();

	@Override
	public JSONObject getTrack(String track) throws IOException, InterruptedException {

		// Storing for keeping in queue
		String[] trackArray = track.split(",");

		for (String string : trackArray) {
			if (!string.equalsIgnoreCase("")) {
				trackList.add(string);
			}
		}

		JSONObject jsonObject = new JSONObject();

		// Need to pass the comma (,) separated value
		String result = trackList.stream().map(s -> String.valueOf(s)).collect(Collectors.joining(","));

		if (trackArray.length >= 5 || trackList.size() >= 5)

		{
			var tracking = restTemplate.getForObject(
					assessApi.getServer() + ":" + assessApi.getPort() + assessApi.getTrack() + "?q=" + result,
					String.class);

			jsonObject = new JSONObject(tracking);

			// Since cap of 5 so clear the list when more than 5 values
			trackList.clear();
		}

		return jsonObject;
	}

}
