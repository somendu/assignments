/**
 * 
 */
package com.ft42.tasklist.dao;

import java.util.List;
import java.util.Map;

/**
 * Download Data dao
 * 
 * @author Somendu
 *
 * @since 30-May-2020
 */
public interface TaskDownloadDao {

	/**
	 * Download Data
	 * 
	 * @param taskDownloadMap
	 * @return
	 */
	public List<Map<String, Object>> getDownloadDataList(Map<String, Object> taskDownloadMap);

}
