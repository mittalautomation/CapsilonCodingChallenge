package com.capsilon.qa.studentresulttestcases;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

import com.capsilon.qa.base.Constants;
import com.capsilon.qa.base.TestBase;

public class PrintStudentEqualMarksMathsTest extends TestBase {
	
	@Test(description="Question4.4 : Print the names of students who have equal marks in Maths")
	public void equalMarksInMaths() throws IOException {
		TestBase.readExcel();
		int index1 = 0;
		Row row2 = null,row3=null;
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		for (int i = 0; i < columnCount + 1; i++) {
			Cell c = sheet.getRow(0).getCell(i);
			if (c.getCellType() == CellType.STRING) {
				if (c.getStringCellValue().equals(Constants.MATHS)) {
					index1 = c.getColumnIndex();
					for (int j = 1; j < rowCount + 1; j++) {
					Row row = sheet.getRow(j);
						if (row.getCell(index1).getCellType() == CellType.NUMERIC) {
							for (int k = j + 1; k < rowCount + 1; k++) {
								Row row1=sheet.getRow(k);
								if (row.getCell(index1).getNumericCellValue() == row1.getCell(index1).getNumericCellValue()) {
									row2 = sheet.getRow(k);
									row3 = sheet.getRow(j);
							}
							
							}

						}
					}
					break;

				}

			}

		}
		System.out.println("Equals marks in maths is : " + row2.getCell(0).getStringCellValue()+" and "+row3.getCell(0).getStringCellValue());
		workbook.close();

	}

}
	
