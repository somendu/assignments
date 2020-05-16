/**
 * 
 */
package com.sql.util.rest.sql.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sql.util.rest.sql.dao.SQLUtilDao;
import com.sql.util.rest.sql.service.SqlUtilService;

/**
 * Implementation class for order service
 * 
 * @author Somendu
 * @since Mar 31, 2020
 */
@Service
public class SqlUtilServiceImpl implements SqlUtilService {

	@Autowired
	private SQLUtilDao sqlUtilDao;

	private final String insertAppendQuery = "INSERT INTO employees("
			+ "first_name, last_name, email, phone_number, hire_date, job_id, salary,manager_id,department_id)";

	@Override
	public List<String> createInsertScripts(List<String> firstNames) {

		List<String> queryList = new ArrayList<String>();

		for (String string : firstNames) {

			String insertQuery = "";
			int dataCount = sqlUtilDao.runSelectQuery("", string);

			if (dataCount == 0) {
				insertQuery = insertAppendQuery + "Values (" + string
						+ ",'Maiti','som@s.com','9004030800',sysdate-10,'AC_MGR',13000,101,110);";
				queryList.add(insertQuery);
			}

		}

		return queryList;
	}

}
