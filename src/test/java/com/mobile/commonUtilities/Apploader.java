package com.mobile.commonUtilities;

import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import PageFactory.Login;
import io.appium.java_client.MobileElement;

public class Apploader {
	
	 public static AndroidDriver<MobileElement> driver;
	 public static String propertyFile="config.properties";
	 public static Login loginPage;

	 public static WebDriverWait wait;

	 @BeforeSuite(alwaysRun=true)
	  public void setup() throws IOException
	 {
		 
		 if(driver==null)
		 {
			 commonUtil.loadConfig(propertyFile);
			 commonUtil.setCapabilities();
		
			driver= commonUtil.getDriver();
		    loginPage=new Login(driver);
		     wait=new WebDriverWait(driver,30);
		 }
		 
	 }
	
	 
	 
	
	@AfterSuite(alwaysRun=true)
	 public void tearDown()
	 {
		//driver.quit();
		 
		 
	 }
	 
  


	
	
	
	}
