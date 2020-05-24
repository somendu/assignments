package com.ft42.communic.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * Email Service
 * 
 * @author somendu
 *
 */
public interface EmailService {

	/**
	 * 
	 * @param insertEmailDetailsReq
	 * @return
	 * @throws ParseException
	 */
	public JSONObject insertEmailDetails(String insertEmailDetailsReq) throws ParseException;

}
