package com.ft42.communic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/email")
	@ApiOperation(value = "Email Api", notes = "The Email api result", response = String.class)
	public ResponseEntity<?> insertEmail(@RequestParam(name = "pricing", required = false) String requestString) {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		String response = "Email Api Called";

		resultMap.put(response, response);

		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);

	}

}
