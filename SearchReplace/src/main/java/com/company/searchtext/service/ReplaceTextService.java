/**
 * 
 */
package com.company.searchtext.service;

/**
 * 
 * Factory pattern common class
 * 
 * @author somendu
 *
 */
public class ReplaceTextService {

	/**
	 * Method for replacing the text
	 * 
	 * @param actualString
	 * @param searchString
	 * @param replaceString
	 * @return
	 */
	public String replaceText(String actualString, String searchString, String replaceString) {

		actualString = actualString.replaceAll(searchString, replaceString);

		return actualString;
	}

}
