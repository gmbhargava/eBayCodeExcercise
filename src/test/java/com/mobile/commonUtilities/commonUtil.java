package com.mobile.commonUtilities;
/**
 *
 * This is a utility which provides some common methods for appium driver.
 *Author: Bhargava
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.*;
import java.util.HashMap;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class commonUtil {

	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String APP;
	public static Properties property = new Properties();
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static AndroidDriver driver;
	public static URL url;
	public static String SERVER;
	public static String USERNAME;
	public static ExtentReports extent;
	public static String NO_RESET;

	public static void swipeUntilElementFound(MobileElement element){
		while(!element.isDisplayed()){
			swipeDown();
			if(element.isDisplayed()){
				break;
			}
		}
	}
	public static void swipeDown() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> swipeObject = new HashMap<String, String>();
		 swipeObject.put("direction", "down"); //up for swipe
	     swipeObject.put("startX", "90");
	     swipeObject.put("startY", "400");
	     swipeObject.put("endX", "90"); //"90");
	     swipeObject.put("endY", "350"); //"200");
	     swipeObject.put("duration", "2000");
	 //    js.executeScript("mobile: swipe", swipeObject); 
	     js.executeScript("mobile: scroll", swipeObject);


	}
	
	
	
	

	public static void loadConfig(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/Properties/" + fileName);
		property.load(fis);
		PLATFORM_NAME = property.getProperty("platformName");
		System.out.println(PLATFORM_NAME);
		PLATFORM_VERSION = property.getProperty("platform.version");
		System.out.println(PLATFORM_VERSION);
		DEVICE_NAME = property.getProperty("device.name");
		APP =System.getProperty("user.dir")+property.getProperty("app");
		NO_RESET = property.getProperty("noReset");
		SERVER ="http://127.0.0.1:4723/wd/hub";
				//property.getProperty("server.url");
		USERNAME = property.getProperty("userName");

	}

	public static String loadTestData(String keyName) throws IOException {
		String fileName = commonUtil.USERNAME;
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/Properties/TestData/" + fileName + ".properties");
		property.load(fis);
		String keyVal = property.getProperty(keyName);
		return keyVal;

	}

	public static void setCapabilities() {
		System.out.println(commonUtil.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, commonUtil.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, commonUtil.PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, commonUtil.DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.APP, commonUtil.APP);
		capabilities.setCapability("appPackage", "com.ebay.mobile");
		capabilities.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
		//capabilities.setCapability("automationName","UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, commonUtil.NO_RESET);

	}



	public static AndroidDriver getDriver() throws MalformedURLException {
		url = new URL("http://127.0.0.1:4723/wd/hub");
		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		return driver;

	}

}
