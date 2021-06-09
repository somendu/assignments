/**
 * 
 */
package com.ft42.tasklist.support;

import lombok.Data;

/**
 * 
 * request body class
 * 
 * @author somendu
 *
 */
@Data
public class TaskRequest {

	private String consName;
	private String taskDate;
	private String taskList;

}
