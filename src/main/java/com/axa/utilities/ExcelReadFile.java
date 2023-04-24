package com.axa.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReadFile {
    private  XSSFWorkbook workbook;
    private  XSSFSheet sheet;
    private Map<String,Integer> columnsHeaders;

    public ExcelReadFile(String fileName) {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/" + fileName;
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Test file not found" + e.getMessage());
            System.exit(0);
        }
    }

    public int getColNum(String sheetName) {
        int numberOfColumns = 0;
        try {
            numberOfColumns = workbook.getSheet(sheetName).getRow(0).getLastCellNum();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return numberOfColumns;
    }

    public int getRowNum(String sheetName) {
        int numberOfRows = 0;
        try {
            numberOfRows = workbook.getSheet(sheetName).getLastRowNum() + 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return numberOfRows;
    }

    public String getDataFromExcelByColumnNumber(String sheetName, int row, int column) {
        sheet = workbook.getSheet(sheetName);
        String data = null;
        try {
            data = sheet.getRow(row).getCell(column).getStringCellValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        data = (data == null) ? "" : data;
        return data;
    }

    public Object[][] getTestDataFromExcelFile(String sheetName) {
        int testCaseStartRow = 1;
        int testCaseStartColumn = 0;
        int numberOfRows = getRowNum(sheetName);
        int numberOfColumns = getColNum(sheetName);
        String excelFileDataDrivenData[][] = new String[numberOfRows
                - testCaseStartRow][numberOfColumns];
        for (int i = testCaseStartRow; i <= (numberOfRows - testCaseStartRow); i++) {
            for (int j = testCaseStartColumn; j < (numberOfColumns + testCaseStartColumn); j++) {
                excelFileDataDrivenData[i - testCaseStartRow][j
                        - testCaseStartColumn] = getDataFromExcelByColumnNumber(
                        sheetName, i, j);
            }
        }

        return excelFileDataDrivenData;

    }

    public String getCellDataByColumnHeader(String sheetName, int row, String columnName){
        sheet = workbook.getSheet(sheetName);
        getAllHeaderColumnsValues();
        String data = null;
        try {
            data = sheet.getRow(row).getCell(columnsHeaders.get(columnName)).getStringCellValue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        data = (data == null) ? "" : data;
        return data;
    }

    public void getAllHeaderColumnsValues(){
        columnsHeaders=new HashMap<>();
        int totalNumOfColumns= sheet.getRow(0).getLastCellNum();
        for(int i=0;i<totalNumOfColumns;i++){
            columnsHeaders.put(sheet.getRow(0).getCell(i).getStringCellValue(), i);
        }
    }
}