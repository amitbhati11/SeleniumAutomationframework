package com.selenium.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class propertyclass {
	
	Properties pp;
	public  propertyclass() throws IOException {
		
		String path="C:\\Users\\Admin_SRV\\eclipse-workspace\\SeleniumFramework\\Configfiles\\file.properties";
		File src=new File(path);
		FileInputStream fis=new FileInputStream(src);
		pp=new Properties();
		pp.load(fis);
	}
	
	public String getbrowser() {
		
		return pp.getProperty("Browser");
	}
	public String getappurl() {
		return pp.getProperty("Url");
	}

}
