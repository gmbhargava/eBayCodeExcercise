package com.mobile.commonUtilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Basedriver {

	
	public AndroidDriver<MobileElement> driver;
	
	
	public Basedriver(AndroidDriver<MobileElement> driver)
	{
		this.driver=driver;
	}
}
