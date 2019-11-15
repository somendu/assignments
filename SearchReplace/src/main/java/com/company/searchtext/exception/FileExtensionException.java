/**
 * 
 */
package com.company.searchtext.exception;

/**
 * 
 * File Extension Exception
 * 
 * @author somendu
 *
 */
public class FileExtensionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param errorMessage
	 */
	public FileExtensionException(String errorMessage) {
		super("Either Source or Target File Extension is Invalid");
	}

}
