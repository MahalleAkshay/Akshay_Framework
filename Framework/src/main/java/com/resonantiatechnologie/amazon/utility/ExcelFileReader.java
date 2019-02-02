package com.resonantiatechnologie.amazon.utility;

import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	public Object[][] excleFileReader() throws IOException {
		XSSFWorkbook workBook = new XSSFWorkbook(Constants.pomexcelFilePath);
		XSSFSheet sheet = workBook.getSheet("login");
		int lastRowNum = sheet.getLastRowNum();
		Object[][] content = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];

		for (int i = 1; i < lastRowNum + 1; i++) {
			Row row = sheet.getRow(i);
			int lastCellNum = row.getLastCellNum();
			for (int j = 0; j < lastCellNum; j++) {
				Cell cell = row.getCell(j);
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					content[i - 1][j] = String.valueOf(cell.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_STRING:
					content[i - 1][j] = cell.getStringCellValue();
					break;
				default:
					System.out.println("Invalid data in Cell");
					break;

				}

			}
		}
		return content;
	}
}
