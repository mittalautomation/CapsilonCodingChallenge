package com.capsilon.qa.studentresulttestcases;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

import com.capsilon.qa.base.Constants;
import com.capsilon.qa.base.TestBase;

public class PrintTopperPhysicsTest extends TestBase{
	
	@Test(description="Question4.3 : Print the topper in Physics.")
	public void topperInPhysics() throws IOException {
		TestBase.readExcel();
		double max = 0;
		int index1 = 0;
		Row row1 = null;
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		for (int i = 0; i < columnCount + 1; i++) {
			Cell c = sheet.getRow(0).getCell(i);
			if (c.getCellType() == CellType.STRING) {
				if (c.getStringCellValue().equals(Constants.PHYSICS)) {
					index1 = c.getColumnIndex();
					max = sheet.getRow(1).getCell(i).getNumericCellValue();
					for (int j = 1; j < rowCount + 1; j++) {
						Row row = sheet.getRow(j);
						if (row.getCell(index1).getCellType() == CellType.NUMERIC) {
							if (max < row.getCell(index1).getNumericCellValue()) {
								max = row.getCell(index1).getNumericCellValue();
								row1 = sheet.getRow(j);
							}

						}
					}
					break;
				}

			}
		}
		System.out.println("maximum marks in physics is : " + max);
		System.out.println("Topper in physics is : " + row1.getCell(0).getStringCellValue());
		workbook.close();

	}

}
