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


public class PrintSalemenOfThaneCityTest extends TestBase {
	

	@Test(description="Question3.4 : Print the number of salesman having Thane as their City")
	public void noOfSalesmanOfThane() throws ParserConfigurationException, SAXException, IOException {
		TestBase.readXml();
		int count = 0;
		NodeList nodeList = document.getElementsByTagName(Constants.SALESMAN);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				if (eElement.getElementsByTagName(Constants.CITY).item(0).getTextContent().equals(Constants.THANE_CITY)) {
					count++;
				}
			}

		}
		System.out.println("Number of salesman having Thane as their city is: " + count);

	}


}
