package com.Framework.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.FrameworkPages.BaseClass;
import com.FrameworkPages.LoginPage;

import Utility.ExcelDataProvider;

public class LoginEasyCalTest extends BaseClass {
	
	@Test
	public void loginApp() throws InterruptedException {
		
		ExcelDataProvider excel = new ExcelDataProvider();
		excel.getStringData("Sheet1", 0, 0);
		
		LoginPage loginHRM = PageFactory.initElements(driver, LoginPage.class);
		loginHRM.login_EasyCal(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));
		Thread.sleep(10000);
	}

}
