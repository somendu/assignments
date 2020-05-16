/**
 * 
 */
package com.sql.util.rest.sql.service;

import java.util.List;

/**
 * 
 * SQl Service class
 * 
 * @author Somendu
 * @since Apr 2, 2020
 */
public interface SqlUtilService {

	public List<String> createInsertScripts(List<String> firstNames);
}
