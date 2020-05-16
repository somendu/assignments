/**
 * 
 */
package com.sql.util.rest.sql.dao.impl;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sql.util.rest.sql.dao.SQLUtilDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementation class for Order DAO
 * 
 * @author Somendu
 * @since Mar 31, 2020
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SQLUtilDaoImpl implements SQLUtilDao {

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	private final String selectQuery = "SELECT count(1) AS count FROM Employees WHERE first_name = ?";

	@Override
	public int runSelectQuery(String tableName, String parameter) {

		Map<String, Object> queryMap = jdbcTemplate.queryForMap(selectQuery, parameter);

		return ((BigDecimal) queryMap.get("count")).intValue();
	}

}
