package page.ddt;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;


public class Excel {
	
	static String filePath = System.getProperty("user.dir") + "/resources/testdata.xlsx";

	public static String read(String sheetName, int rowNumber, int columnNumber) {
		
        String value = null;

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                Row row = sheet.getRow(rowNumber);
                if (row != null) {
                    Cell cell = row.getCell(columnNumber);
                    if (cell != null) {
                        value = cell.toString();  // Convert the cell value to string
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
	}
	
	public static void write() {
		
	}
	

}
