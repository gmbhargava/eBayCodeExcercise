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
import java.security.SecureRandom;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import PageFactory.Login;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
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
	public static String propertyFile = "config.properties";
	public static String USERNAME;
	public static ExtentReports extent;
	public static String NO_RESET;
	



	public static void verticalSwipe(double startPercentage, double finalPercentage) {

		Dimension size = driver.manage().window().getSize();
		int width = size.width / 2;
		int start = (int) (size.getHeight() * startPercentage);
		int endPoint = (int) (size.getHeight() * finalPercentage);
		new TouchAction(driver).press(width, start).waitAction(Duration.ofMillis(500)).moveTo(width, endPoint).release()
				.perform();

	}

	public static void HorizontalSwipe(double from, double to, double length) {
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		int y = (int) (height * length);
		int start = (int) (width * from);
		int end = (int) (width * to);
		new TouchAction(driver).press(start, y).waitAction(Duration.ofMillis(500)).moveTo(end, y).release().perform();
	}
	
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
		SERVER = property.getProperty("server.url");
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
		capabilities.setCapability("automationName","UiAutomator2");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, commonUtil.NO_RESET);

	}



	public static AndroidDriver getDriver() throws MalformedURLException {
		url = new URL(commonUtil.SERVER);
		driver = new AndroidDriver(new URL(commonUtil.SERVER), capabilities);
		return driver;

	}

}
