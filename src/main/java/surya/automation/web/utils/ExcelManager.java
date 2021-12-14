package surya.automation.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	private static Workbook excelWorkBook = null;
	private static Sheet sheet = null;
	private static Row row = null;
	private static Cell cell = null;

	public static Map<Integer, List<String>> readExcel(String excelPath, String sheetName) throws IOException {

		Map<Integer, List<String>> excelData = new HashMap<Integer, List<String>>();

		// Create an object of FileInputStream class to read excel file.
		FileInputStream inputStream = new FileInputStream(excelPath);

		// Create workbook instance based on the extension type.
		excelWorkBook = WorkbookFactory.create(inputStream);

		// Read sheet data inside the workbook by its name.
		sheet = excelWorkBook.getSheet(sheetName);

		Iterator<Row> iterator = sheet.iterator();
		int rowCount = 0;

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();

			Iterator<Cell> cellIterator = nextRow.cellIterator();
			List<String> list = new ArrayList<String>();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String cellValue = cell.getStringCellValue();
				list.add(cellValue);
			}

			excelData.put(rowCount, list);
			rowCount++;
		}

		excelWorkBook.close();
		inputStream.close();

		return excelData;
	}

	public void writeExcel(String excelPath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {

	}

}
