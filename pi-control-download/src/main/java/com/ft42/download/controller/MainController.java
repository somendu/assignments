package com.ft42.download.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Somendu
 *
 * @since 21-Jul-2020
 */
@RestController
@RequestMapping("/api")
public class MainController {
	/**
	 * Simple REST method without params
	 * 
	 * @return String representing the greeting
	 * @throws IOException
	 */
	@RequestMapping(value = "/download/{fileName}", method = RequestMethod.GET)
	public ResponseEntity<Resource> download(@PathVariable String fileName)
			throws IOException {

		// File file = new File("C:\\FortyTwo42\\Workspaces\\" + fileName);

		// TODO - THis need to have absolute path
		File file = new File("/weblogic/Oracle/download/" + fileName);

		Path path = Paths.get(file.getAbsolutePath());
		ByteArrayResource resource = new ByteArrayResource(
				Files.readAllBytes(path));

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=" + file.getName());
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
	}

}
