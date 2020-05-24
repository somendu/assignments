/**
 * 
 */
package com.ft42.communic.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * SMS Service
 * 
 * @author somendu
 *
 */
public interface SMSService {

	/**
	 * 
	 * @param insertSMSDetailsReq
	 * @return
	 */
	public JSONObject insertSMSDetails(String insertSMSDetailsReq) throws ParseException;
}
