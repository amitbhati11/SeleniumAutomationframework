package com.selenium.utility;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Exceldata {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public Exceldata(String xlpath,String sheetname) throws IOException {
		
		workbook=new XSSFWorkbook(xlpath);
		sheet=workbook.getSheet(sheetname);
	}
	
	public int rownum() {
	int rowcount=sheet.getPhysicalNumberOfRows();
	return rowcount;
	}
	public int colnum() {
		int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		return colcount;
	}
	public String getcellstringdata (int rown,int coln ) throws IOException {
		DataFormatter format=new DataFormatter();
		
		String value=format.formatCellValue(sheet.getRow(rown).getCell(coln));
		return value;
	}
	
}
