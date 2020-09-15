/**
 * 
 */
package com.ft42.tasklist.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ft42.tasklist.dao.TaskListAddDao;

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
public class TaskListAddDaoImpl implements TaskListAddDao {

	private static String INSERT_TASKLIST_SQL = "INSERT INTO taskList "
			+ "(c_cons_name, t_task_input_date, c_task_list, i_status, c_input_user, t_input_date) "
			+ "VALUES (?,?,?,1,?,sysdate)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertTaskList(Map<String, Object> taskListMap) {

		int insertCount = jdbcTemplate.update(INSERT_TASKLIST_SQL, (String) taskListMap.get("consName"),
				(Date) taskListMap.get("taskDate"), (String) taskListMap.get("taskList"),
				(String) taskListMap.get("firstName"));

		return insertCount;

	}

	@Override
	public int insertTaskBatch(Map<String, Object> taskListMap) {
		int[] insertCount = jdbcTemplate.batchUpdate(INSERT_TASKLIST_SQL, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, (String) taskListMap.get("consName"));
				ps.setDate(2, (Date) taskListMap.get("taskDate"));
				ps.setString(3, (String) taskListMap.get("taskList"));
				ps.setString(4, (String) taskListMap.get("firstName"));
			}

			@Override
			public int getBatchSize() {
				return taskListMap.size();
			}
		});
		return insertCount.length;
	}
}
