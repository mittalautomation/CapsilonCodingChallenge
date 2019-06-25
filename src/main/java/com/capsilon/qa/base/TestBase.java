package com.capsilon.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class TestBase {


	public static File file;
	public static FileInputStream inputStream;
	public static HSSFWorkbook workbook;
	public	static Sheet sheet;
	public static Document document;
	public static void readExcel() throws IOException
	{
		 file = new File("./src/main/resource/Student_Result.xls");
		 inputStream = new FileInputStream(file);
		 workbook = new HSSFWorkbook(inputStream);
		 sheet = workbook.getSheet("Sheet1");
	}
	
	public static void readXml() throws ParserConfigurationException, SAXException, IOException
	{
		file = new File("./src/main/resource/Professionals.xml");
		DocumentBuilderFactory dbBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbBuiler = dbBuilderFactory.newDocumentBuilder();
		 document = dbBuiler.parse(file);
		document.getDocumentElement().normalize();
	}
	

}
