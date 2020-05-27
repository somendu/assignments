package com.ft42.communic.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ft42.communic.service.EmailService;
import com.ft42.communic.service.SMSService;
import com.google.gson.JsonObject;

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
public class MainController {

	@Autowired
	private EmailService emailService;

	@Autowired
	private SMSService smsService;

	@PostMapping("/email")
	@ApiOperation(value = "Email Api", notes = "The Email api result", response = JsonObject.class)
	public ResponseEntity<?> insertEmail(@RequestBody String insertEmailDetailsReq) {

		JSONObject InsertEmailDetailsRes = new JSONObject();

		try {
			InsertEmailDetailsRes = emailService.insertEmailDetails(insertEmailDetailsReq);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return new ResponseEntity<JSONObject>(InsertEmailDetailsRes, HttpStatus.OK);

	}

	@PostMapping("/sms")
	@ApiOperation(value = "SMS Api", notes = "The SMS api result", response = JsonObject.class)
	public ResponseEntity<?> insertSMS(@RequestBody String insertSMSDetailsReq) {

		JSONObject insertSMSDetailsRes = new JSONObject();

		try {
			insertSMSDetailsRes = smsService.insertSMSDetails(insertSMSDetailsReq);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<JSONObject>(insertSMSDetailsRes, HttpStatus.OK);
	}
}
