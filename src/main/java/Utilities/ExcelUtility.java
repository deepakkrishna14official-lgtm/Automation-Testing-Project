package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	 private Workbook workbook;
	    private Sheet sheet;

	    // =========================================================
	    // CONSTRUCTOR
	    // =========================================================

	    public ExcelUtility(String filePath, String sheetName) {

	        try {

	            FileInputStream file = new FileInputStream(filePath);

	            workbook = new XSSFWorkbook(file);

	            sheet = workbook.getSheet(sheetName);

	            file.close();

	        } catch (IOException e) {

	            e.printStackTrace();

	            throw new RuntimeException(
	                    "Unable to open Excel file: " + filePath
	            );
	        }
	    }

	    // =========================================================
	    // GET ROW COUNT
	    // =========================================================

	    public int getRowCount() {

	        int lastRow = sheet.getLastRowNum();

	        int actualRowCount = 0;

	        for (int i = 0; i <= lastRow; i++) {

	            Row row = sheet.getRow(i);

	            if (row != null && row.getCell(0) != null) {

	                String value =
	                        row.getCell(0).toString().trim();

	                if (!value.isEmpty()) {
	                    actualRowCount++;
	                }
	            }
	        }

	        return actualRowCount;
	    }
	    
	    

	    // =========================================================
	    // GET COLUMN COUNT
	    // =========================================================

	    public int getColumnCount() {

	        return sheet.getRow(0).getPhysicalNumberOfCells();
	    }

	    // =========================================================
	    // GET CELL DATA
	    // =========================================================

	    public String getCellData(int rowNumber, int columnNumber) {

	        Row row = sheet.getRow(rowNumber);

	        if (row == null) {
	            return "";
	        }

	        Cell cell = row.getCell(columnNumber);

	        if (cell == null) {
	            return "";
	        }

	        DataFormatter formatter = new DataFormatter();

	        return formatter.formatCellValue(cell).trim();
	    }

	    // =========================================================
	    // CLOSE WORKBOOK
	    // =========================================================

	    public void closeWorkbook() {

	        try {

	            workbook.close();

	        } catch (IOException e) {

	            e.printStackTrace();
	        }
	    }
	}


