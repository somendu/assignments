/**
 * 
 */
package com.ft42.tasklist.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.core.io.ByteArrayResource;

import com.ft42.tasklist.support.TaskDownloadRequest;

/**
 * Tasklist Download Request
 * 
 * @author Somendu
 *
 */
public interface TaskDownloadService {

	/**
	 * Download Task List
	 * 
	 * @param taskDownloadRequest
	 * @return
	 */
	public ByteArrayResource downloadExcel(TaskDownloadRequest taskDownloadRequest)
			throws IOException, FileNotFoundException;

}
