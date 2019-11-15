/**
 * 
 */
package com.shadow.text.service;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * XML Service for reading XML
 * 
 * @author somendu
 *
 */
public class XMLService {

	private ReplaceTextService replaceTextService = new ReplaceTextService();

	// java -jar build/libs/SearchReplace.jar --fileType xml --searchString test
	// --replaceString the --sourceFile sample.xml --targetFile Result.xml

	/**
	 * Reading the XML file
	 * 
	 * @param sourceFile
	 * @param fileType
	 * @param searchString
	 * @param replaceString
	 * @param targetFile
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws XPathExpressionException
	 * @throws TransformerException
	 */
	public void readXMLFile(String sourceFile, String fileType, String searchString, String replaceString,
			String targetFile) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException,
			TransformerException {

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(sourceFile));

		XPath xPath = XPathFactory.newInstance().newXPath();

		// get nodelist having attribute contain test
		NodeList searchNodeList = (NodeList) xPath.evaluate("//*[contains(attribute::*,'" + searchString + "')]", doc,
				XPathConstants.NODESET);

		for (int attribNodeCount = 0; attribNodeCount < searchNodeList.getLength(); attribNodeCount++) {

			Node searchNode = searchNodeList.item(attribNodeCount).getAttributes().item(0);

			String nodeValue = searchNode.getNodeValue();

			searchNode.setNodeValue(replaceTextService.replaceText(nodeValue, searchString, replaceString));

		}

		// Creating the result XML File
		Transformer xformer = TransformerFactory.newInstance().newTransformer();

		xformer.transform(new DOMSource(doc), new StreamResult(new File(targetFile)));

	}

}
