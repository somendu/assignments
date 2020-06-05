/**
 * 
 */
package com.ft42.tasklist.dao.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ft42.tasklist.dao.TaskDownloadDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Somendu
 *
 * @since 30-May-2020
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TaskDownloadDaoImpl implements TaskDownloadDao {

	private static String downloadListQuery = "SELECT t_task_input_date taskInputDate, c_task_list taskList, c_cons_name consName "
			+ "FROM tasklist WHERE t_task_input_date BETWEEN ? AND ? AND c_cons_name = ? ORDER BY t_task_input_date, i_task_id";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getDownloadDataList(Map<String, Object> taskDownloadMap) {

		List<Map<String, Object>> downloadMapList = jdbcTemplate.queryForList(downloadListQuery,
				(Date) taskDownloadMap.get("dateFrom"), (Date) taskDownloadMap.get("dateTo"),
				taskDownloadMap.get("consName"));

		return downloadMapList;
	}

}
