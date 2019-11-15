package com.company.searchtext;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.company.searchtext.exception.FileExtensionException;
import com.company.searchtext.exception.FileTypeException;
import com.company.searchtext.service.ReadFileService;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * The class to execute reading file and further inner methods
 * 
 * @author somendu
 *
 */

@Accessors(chain = true)
public class SearchReplace implements Runnable {
	public static int DEFAULT_BUFFER_SIZE = 100;

	@Getter
	@Setter
	private String fileType;

	@Getter
	@Setter
	private String searchString;

	@Getter
	@Setter
	private String replaceString;

	@Getter
	@Setter
	private String sourceFile;

	@Getter
	@Setter
	private String targetFile;

	private ReadFileService readFileService = new ReadFileService();

	public SearchReplace() {

	}

	@Override
	public void run() {
		try {

			long startTime = System.currentTimeMillis();

			readFileService.readFile(sourceFile, fileType, searchString, replaceString, targetFile);

			long endTime = System.currentTimeMillis();

			NumberFormat formatter = new DecimalFormat("#0.00000");

			System.out.println("Execution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds");

		} catch (IOException | XPathExpressionException | ParserConfigurationException | SAXException
				| TransformerException | InterruptedException e) {
			e.printStackTrace();
		}

		// User Generated Exceptions
		catch (FileExtensionException | FileTypeException e) {
			e.printStackTrace();
		}
	}

}
