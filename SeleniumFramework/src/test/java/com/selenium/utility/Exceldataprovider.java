package com.selenium.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class Exceldataprovider {
	
	WebDriver driver;
	Exceldata ed;
	
	@DataProvider(name="testdata")
	
	public Object [][] dataprovide() throws IOException{
		String xlpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\SeleniumFramework\\Datafiles\\loginDataprovider.xlsx";
		String sheetname="Sheet1";
		     Object   data [][]= getstringdata(xlpath, sheetname);
		      return data;
	}
	
	
	
	
	public Object[][]  getstringdata(String xlpath,String sheetname) throws IOException{
		ed=new Exceldata(xlpath,sheetname);
		
		int Rownum=ed.rownum();
	int Colnum=ed.colnum();
	
	           Object data [][]=new Object[Rownum-1][Colnum];
	           
	           for(int i=1;i<Rownum-1;i++) {
	        	   for(int j=0;j<Colnum;j++) {
	        		   
	        		      data[i-1][j]=  ed.getcellstringdata(i, j);
	        	   }
	           }    return data;
		
	}
	

}
