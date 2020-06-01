/**
 * 
 */
package com.ft42.tasklist.dao;

import java.util.Map;

/**
 * @author Somendu
 *
 * @since 30-May-2020
 */
public interface TaskListAddDao {

	public int insertTaskList(Map<String, Object> taskListMap);

	public int insertTaskBatch(Map<String, Object> taskListMap);
}
