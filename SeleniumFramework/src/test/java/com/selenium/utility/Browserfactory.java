package com.selenium.utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browserfactory {
	public WebDriver driver;
	
	public static WebDriver  startapplication(WebDriver driver,String browser,String appurl) {
		if(browser.contains("Chrome")) {
			String cpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", cpath);
			driver=new ChromeDriver();
		}else if(browser.contains("Firefox")) {
			String gpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\SeleniumFramework\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",gpath);
			driver=new FirefoxDriver();
		}else {
			System.out.println("browser is not compatible");
		}
		driver.get(appurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		return driver;
		
		
	}
	
	

}
