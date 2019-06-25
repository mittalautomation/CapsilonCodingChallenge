package com.capsilon.qa.professionaltestcases;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.capsilon.qa.base.Constants;
import com.capsilon.qa.base.TestBase;


public class PrintCitiesOfSalesmenTest extends TestBase{

	
	@Test(description="Question3.2 : Print the cities of all Salesmen.")
	public void printCitiesOfSaleman() throws ParserConfigurationException, SAXException, IOException {
		TestBase.readXml();
		NodeList nodeList = document.getElementsByTagName(Constants.SALESMAN);
		System.out.println("Cities of all salesman are :");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				System.out.print("Salesman id : " + eElement.getAttribute(Constants.ID));
				System.out.println("  " + "City : " + eElement.getElementsByTagName(Constants.CITY).item(0).getTextContent());
			}
		}
	}
	
}
