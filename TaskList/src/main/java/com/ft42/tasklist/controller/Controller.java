package com.ft42.tasklist.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ft42.tasklist.service.TaskDownloadService;
import com.ft42.tasklist.service.TaskListAddService;
import com.ft42.tasklist.support.TaskDownloadRequest;
import com.ft42.tasklist.support.TaskRequest;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Controller Class for creating end points
 * 
 * @author somendu
 *
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Controller {

	@Autowired
	private final TaskListAddService taskListAddService;

	@Autowired
	private final TaskDownloadService taskDownloadService;

	// Insert Task List
	@PostMapping("/insertTaskList")
	public String insertTaskList(@RequestBody TaskRequest taskRequest) {

		return taskListAddService.insertTaskList(taskRequest);
	}

	// Insert Task List
	@PostMapping("/downloadTaskList")
	public ResponseEntity<ByteArrayResource> downloadTaskList(@RequestBody TaskDownloadRequest taskDownloadRequest)
			throws FileNotFoundException, IOException {

		String fileName = taskDownloadRequest.getConsName();

		if (fileName.contains(" ")) {
			fileName = taskDownloadRequest.getConsName().substring(0,
					taskDownloadRequest.getConsName().lastIndexOf(" "));
		}

		ByteArrayOutputStream outputStream = taskDownloadService.downloadExcel(taskDownloadRequest);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "force-download"));
		header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName + ".xlsx");

		outputStream.flush();

		return new ResponseEntity<>(new ByteArrayResource(outputStream.toByteArray()), header, HttpStatus.CREATED);

	}

}
