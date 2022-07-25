package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage {

	WebDriver driver;
	
	By usname=By.id("name");
	By uspwd=By.id("password");
	By lbtn=By.id("login");
	By logut=By.id("logout");
	public loginpage(WebDriver driver) {
		this.driver=driver;
		}
		public void  user_name(String username) {
		driver.findElement(usname).sendKeys(username);
	}
	public void user_pass(String password) {
		driver.findElement(uspwd).sendKeys(password);
	}
	public void loginbtn() throws InterruptedException {
		driver.findElement(lbtn).click();
		Thread.sleep(4000);
	//	driver.findElement(logut).click();
	}
	
}
