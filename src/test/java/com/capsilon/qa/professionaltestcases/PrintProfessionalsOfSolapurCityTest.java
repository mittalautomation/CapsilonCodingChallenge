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


public class PrintProfessionalsOfSolapurCityTest extends TestBase {
	

	@Test(description="Question3.3 : Print the professionals names having Solapur as their city")
	public void professionalNamesOfSolapur() throws ParserConfigurationException, SAXException, IOException {
		TestBase.readXml();
		NodeList nodeList = document.getElementsByTagName(Constants.PROFESSIONAL);
		System.out.print("Professionals names having Solapur as their city are : ");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				if (eElement.getElementsByTagName(Constants.CITY).item(0).getTextContent().equals(Constants.SOLAPUR_CITY)) {
					System.out.print(eElement.getElementsByTagName(Constants.NAME).item(0).getTextContent() + "  ");
				}
			}

		}System.out.println();

	}

}
