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

public class PrintStudentsFromPuneTest extends TestBase{
	
	@Test(description="Question3.1 : Read this file and print how many Students are from Pune. Also print their PINs")
	public void countStudentsFromPune() throws ParserConfigurationException, SAXException, IOException {
		TestBase.readXml();
		NodeList nodeList = document.getElementsByTagName(Constants.STUDENT);
		int count = 0;
		System.out.print("PINS for Pune Students are ");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				if (eElement.getElementsByTagName("city").item(0).getTextContent().equals(Constants.PUNE_CITY)) {
					count++;
					System.out.print(eElement.getElementsByTagName(Constants.PIN).item(0).getTextContent() + " ");
				}
			}
		}
		System.out.println();
		System.out.println("Total students from pune are : " + count);

	}
}
