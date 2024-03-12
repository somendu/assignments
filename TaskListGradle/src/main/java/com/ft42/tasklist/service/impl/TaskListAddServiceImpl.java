/**
 * 
 */
package com.ft42.tasklist.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ft42.tasklist.dao.TaskListAddDao;
import com.ft42.tasklist.service.TaskListAddService;
import com.ft42.tasklist.support.TaskRequest;
import com.ft42.tasklist.support.TaskUtil;

/**
 * @author admin
 *
 */
@Service
public class TaskListAddServiceImpl implements TaskListAddService {

	@Autowired
	private TaskListAddDao taskListAddDao;

	@Override
	public Map<String, Object> insertTaskList(TaskRequest taskRequest) {

		Map<String, Object> taskListMap = new HashMap<String, Object>();

		// Convert String to Date
		String taskDateString = taskRequest.getTaskDate();
		Date taskDate = TaskUtil.getDateToSQLDate(taskDateString);// converting string into sql date.

		// Use the first name to input user
		String firstName = taskRequest.getConsName();

		if (firstName.contains(" ")) {
			firstName = taskRequest.getConsName().substring(0, taskRequest.getConsName().lastIndexOf(" "));
		}

		taskListMap.put("consName", taskRequest.getConsName());
		taskListMap.put("taskDate", taskDate);
		taskListMap.put("taskList", taskRequest.getTaskList());
		taskListMap.put("firstName", firstName);

		int insertReturn = taskListAddDao.insertTaskList(taskListMap);
		System.out.println("Insert Retunr : " + insertReturn);

		String resultReturn = "Data Inserted for : " + (String) taskListMap.get("consName");

		Map<String, Object> returnMap = new HashMap<String, Object>();

		returnMap.put("insertSuccess", resultReturn);

		return returnMap;
	}

}
