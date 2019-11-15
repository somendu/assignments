/**
 * 
 */
package com.shadow.text.exception;

/**
 * 
 * @author somendu
 *
 */
public class FileTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 * 
	 * @param errorMessage
	 */
	public FileTypeException(String errorMessage) {
		super("File Type is not Text or XML");
	}

}
