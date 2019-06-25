package com.capsilon.qa.studentresulttestcases;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

import com.capsilon.qa.base.Constants;
import com.capsilon.qa.base.TestBase;

public class PrintStudentFailTest extends TestBase {
	
	@Test(description="Question4.1 : Read this file and print how many Students are from Failed. Also print their Names")
	public void failedStudents() throws IOException {
		TestBase.readExcel();
		int count = 0;
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.print("Failed students are : ");
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if (row.getCell(j).getCellType() == CellType.STRING) {
					if (row.getCell(j).getStringCellValue().equals(Constants.FAILED)) {
						count++;
						System.out.print( row.getCell(0).getStringCellValue()+", ");
					}
				} else {
					continue;
				}
			}

		}
		System.out.println();
		System.out.println("Count of failed students are : " + count);
		workbook.close();
	}


}
