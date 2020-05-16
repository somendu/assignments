/**
 * 
 */
package com.sql.util.rest.sql.dao;

/**
 * DAO Layer interface
 * 
 * @author Somendu
 * @since Mar 31, 2020
 */
public interface SQLUtilDao {

	public int runSelectQuery(String tableName, String parameter);
}
