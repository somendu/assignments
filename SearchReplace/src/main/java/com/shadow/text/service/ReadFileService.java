/**
 * 
 */
package com.shadow.text.service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.io.FilenameUtils;
import org.xml.sax.SAXException;

import com.shadow.text.exception.FileExtensionException;
import com.shadow.text.exception.FileTypeException;

/**
 * 
 * Service for reading the file and proceeding for the particular file type
 * 
 * @author somendu
 *
 */
public class ReadFileService {

	private XMLService xmlService = new XMLService();

	private TextService textService = new TextService();

	/**
	 * 
	 * Reading the file and proceeding to respective format of file
	 * 
	 * @param sourceFile
	 * @param fileType
	 * @param searchString
	 * @param replaceString
	 * @param targetFile
	 * @throws FileTypeException
	 * @throws FileExtensionException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws XPathExpressionException
	 * @throws TransformerException
	 * @throws InterruptedException
	 */
	public void readFile(String sourceFile, String fileType, String searchString, String replaceString,
			String targetFile)
			throws FileTypeException, FileExtensionException, IOException, ParserConfigurationException, IOException,
			SAXException, XPathExpressionException, TransformerException, InterruptedException {

		// Initial check for extension for source and target
		if (checkFileExtension(sourceFile) && checkFileExtension(targetFile)) {

			// Calling text file Service
			if ("txt".equalsIgnoreCase(fileType)) {
				textService.readTextFile(sourceFile, fileType, searchString, replaceString, targetFile);
			}

			// Calling XML File Service
			else if ("xml".equalsIgnoreCase(fileType)) {
				xmlService.readXMLFile(sourceFile, fileType, searchString, replaceString, targetFile);
			} else {
				throw new FileTypeException("File Type is incorrect");
			}
		} else {
			throw new FileExtensionException("Either Source or Target File Extension is Invalid");
		}
	}

	/**
	 * Check File Extension
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean checkFileExtension(String fileName) {

		String extension = FilenameUtils.getExtension(fileName);

		if ("txt".equalsIgnoreCase(extension) || "xml".equalsIgnoreCase(extension)) {

			return true;
		}

		return false;
	}
}
