/**
 * 
 */
package com.ft42.communic.service.impl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ft42.communic.config.CommunicProperties;
import com.ft42.communic.service.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Implementation class for async service
 * 
 * @author somendu
 *
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

	@Autowired
	private final RestTemplate restTemplate;

	@Autowired
	private final CommunicProperties communicProperties;

	@Override
	public JSONObject insertEmailDetails(String insertEmailDetailsReq) throws ParseException {

		log.debug("String Here : " + insertEmailDetailsReq);

		JSONParser jsonParser = new JSONParser();
		JSONObject emailDetailJsonObject = (JSONObject) jsonParser.parse(insertEmailDetailsReq);

		JSONObject emailDetailsResponseJson = new JSONObject();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<JSONObject> emailEntityRequest = new HttpEntity<JSONObject>(emailDetailJsonObject, httpHeaders);

		String emailUrl = communicProperties.getServer() + ":" + communicProperties.getPort()
				+ communicProperties.getEmailService();

		emailDetailsResponseJson = restTemplate.postForObject(emailUrl, emailEntityRequest, JSONObject.class);

		return emailDetailsResponseJson;

	}

}
