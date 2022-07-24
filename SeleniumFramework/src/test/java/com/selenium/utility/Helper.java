package com.selenium.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public String capturesceenshot(WebDriver driver) throws IOException {
		String path="C:\\Users\\Admin_SRV\\eclipse-workspace\\SeleniumFramework\\Screenshots\\Project_"+getcurrenttime()+"_login.png";
		
		           File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		           
		           FileUtils.copyFile(src, new File(path));
		        return path;   
	}
	
	public String getcurrenttime() {
		DateFormat currentformat=new SimpleDateFormat("MM-dd-yy-HH-mm-ss");
		
		Date  dformat=new Date();
		
	   return  currentformat.format(dformat);
	     
	}

}
