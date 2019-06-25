package com.capsilon.qa.studentresulttestcases;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

import com.capsilon.qa.base.Constants;
import com.capsilon.qa.base.TestBase;

public class PrintSubjectHighestMarkTest extends TestBase {
	
	@Test(description="Question4.2 : Print the subject having the highest marks for Sanket")
	public void highestMarks() throws IOException {
		TestBase.readExcel();
		double max = 0;
		Row row1 = sheet.getRow(0);
		Cell c = null;
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				if (row.getCell(j).getCellType() == CellType.NUMERIC) {
					break;
				}
				if (row.getCell(j).getStringCellValue().equals(Constants.SANKET)) {
					max = row.getCell(j + 1).getNumericCellValue();
					for (int k = j; k < row.getLastCellNum(); k++) {
						if (row.getCell(k).getCellType() == CellType.NUMERIC) {
							if (max < row.getCell(k).getNumericCellValue()) {
								c = row.getCell(k);
								max = c.getNumericCellValue();
							}

						}

					}

				}

			}
		}
		System.out.println("Maximum marks is : " + max);
		int index = c.getColumnIndex();
		System.out.println("Subject having highest marks for SANKET is : " + row1.getCell(index).getStringCellValue());
		workbook.close();
	}

}
