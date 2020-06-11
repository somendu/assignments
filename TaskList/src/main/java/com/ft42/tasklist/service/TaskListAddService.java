/**
 * 
 */
package com.ft42.tasklist.service;

import java.util.Map;

import com.ft42.tasklist.support.TaskRequest;

/**
 * 
 * Service layer interface for the controller
 * 
 * @author somendu
 *
 */
public interface TaskListAddService {

	/**
	 * Insert Task
	 * 
	 * @param taskRequest
	 * @return
	 */
	public Map<String, Object> insertTaskList(TaskRequest taskRequest);
}
