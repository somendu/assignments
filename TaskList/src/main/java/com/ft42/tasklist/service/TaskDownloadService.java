/**
 * 
 */
package com.ft42.tasklist.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	public ByteArrayOutputStream downloadExcel(TaskDownloadRequest taskDownloadRequest)
			throws IOException, FileNotFoundException;

}
