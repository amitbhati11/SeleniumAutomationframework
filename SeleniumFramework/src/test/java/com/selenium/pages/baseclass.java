package com.selenium.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.selenium.utility.Browserfactory;
import com.selenium.utility.Helper;
import com.selenium.utility.propertyclass;

public class baseclass extends Browserfactory {
	
	public static WebDriver driver;
	public propertyclass pc;
	Helper hp;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	
	public void beforestart() throws IOException {
		Reporter.log(" starting setup");
		pc=new propertyclass();
		hp=new Helper();
		String repath="C:\\Users\\Admin_SRV\\eclipse-workspace\\SeleniumFramework\\Reports\\Project_"+hp.getcurrenttime()+"_report.html";
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(repath));
		report=new ExtentReports();
		
		report.attachReporter(extent);
		
		Reporter.log(" successfully setup");
		
		
	}
	@Parameters("browser")	
	@BeforeClass
	
	public void startbrowser(String browser) {
		Reporter.log("browser starting setup");
		driver=Browserfactory.startapplication(driver,browser,pc.getappurl());
		Reporter.log("Browser successfully setup");
	}
	
	@AfterMethod
	
	public void aftermethod(ITestResult result) throws IOException {
		 Reporter.log("test is starting");
		if(result.getStatus()==ITestResult.FAILURE) {
		//hp.capturesceenshot(driver);
			logger.fail("test failed",MediaEntityBuilder.createScreenCaptureFromPath(hp.capturesceenshot(driver)).build());
			
	}else if(result.getStatus()==ITestResult.SUCCESS) {
		//hp.capturesceenshot(driver);
		logger.pass("test passed",MediaEntityBuilder.createScreenCaptureFromPath(hp.capturesceenshot(driver)).build());
	}
	Reporter.log("report are generated");
		report.flush();
	}

}