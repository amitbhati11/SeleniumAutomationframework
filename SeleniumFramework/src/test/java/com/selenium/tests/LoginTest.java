package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.pages.baseclass;
import com.selenium.pages.loginpage;
import com.selenium.utility.Exceldataprovider;

public class LoginTest extends baseclass {
	

	loginpage lp;
	
	@Test(dataProvider="testdata", dataProviderClass=Exceldataprovider.class)
	public void testexecution(String username,String password,String id) throws InterruptedException {
	logger=	report.createTest("login to the project");
		lp=new loginpage(driver);
		logger.info("started test");
		lp.user_name(username);
		lp.user_pass(password);
		lp.loginbtn();
		Thread.sleep(1500);
		driver.navigate().refresh();
		Thread.sleep(500);
	logger.pass("test passed");
	}

}
