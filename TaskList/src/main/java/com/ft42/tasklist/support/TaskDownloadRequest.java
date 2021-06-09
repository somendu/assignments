/**
 * 
 */
package com.ft42.tasklist.support;

import lombok.Data;

/**
 * <Description>
 * 
 * @author Somendu
 *
 * @Since 30-May-2020
 */
@Data
public class TaskDownloadRequest {

	private String consName;
	private String dateFrom;
	private String dateTo;
}
