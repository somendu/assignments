/**
 * 
 */
package com.ft42.communic.service.impl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ft42.communic.config.CommunicProperties;
import com.ft42.communic.service.SMSService;

import lombok.RequiredArgsConstructor;

/**
 * Implementation class for SMS Service
 * 
 * @author somendu
 *
 */
@Service
@RequiredArgsConstructor
public class SMSServiceImpl implements SMSService {

	private final RestTemplate restTemplate;

	private final CommunicProperties communicProperties;

	@Override
	public JSONObject insertSMSDetails(String insertSMSDetailsReq) throws ParseException {

		JSONParser jsonParser = new JSONParser();
		JSONObject smsDetailJsonObject = (JSONObject) jsonParser.parse(insertSMSDetailsReq);

		JSONObject smsDetailsResponseJson = new JSONObject();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<JSONObject> emailEntityRequest = new HttpEntity<JSONObject>(smsDetailJsonObject, httpHeaders);

		String smsUrl = communicProperties.getServer() + ":" + communicProperties.getPort()
				+ communicProperties.getSmsService();

//		String smsUrl = "https://10.0.45.87:1443/SMSService/InsertSMSDetails";

		smsDetailsResponseJson = restTemplate.postForObject(smsUrl, emailEntityRequest, JSONObject.class);

		return smsDetailsResponseJson;

	}

}
