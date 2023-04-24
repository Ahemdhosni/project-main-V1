package com.axa.utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class StaticProvider {

    @DataProvider(name = "RequestAQuotationSheetData1")
    public Object[][] createRequestData1() throws IOException {
        ExcelReadFile requestAQuotationExcelFile = new ExcelReadFile(Constants.REQUEST_EXCEL_FILE_NAME);
        Object[][] requestAQuotationData = requestAQuotationExcelFile.getTestDataFromExcelFile("RequestAQuotation_id>>2");
        return requestAQuotationData;
    }

    @DataProvider(name = "RequestAQuotationSheetData2")
    public Object[][] createRequestData2() throws IOException {
        ExcelReadFile requestAQuotationExcelFile = new ExcelReadFile(Constants.REQUEST_EXCEL_FILE_NAME);
        Object[][] requestAQuotationData = requestAQuotationExcelFile.getTestDataFromExcelFile("RequestAQuotation_id>>3");
        return requestAQuotationData;
    }





}
