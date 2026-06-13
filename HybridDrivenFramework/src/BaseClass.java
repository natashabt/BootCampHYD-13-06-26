package com.FrameworkPages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Utility.BrowserFactory;
import Utility.ConfiqDataProvider;
import Utility.ExcelDataProvider;
import Utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public Utility.ExcelDataProvider excel;
	public ConfiqDataProvider confiq;
	
	@BeforeSuite //if we have more than one test cases the we can use BeforeSuite
	public void SetUp() {
		excel = new ExcelDataProvider();
		confiq = new ConfiqDataProvider();
	}
	
	@BeforeClass
	public void BrowserTest() {
		driver = BrowserFactory.BrowserOptions(driver, confiq.getBrowser(), confiq.getAppURL());
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			Helper.capturedScreenShot(driver);
		}
	}

}
