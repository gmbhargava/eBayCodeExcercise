package com.mobile.Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mobile.commonUtilities.Apploader;
import com.mobile.commonUtilities.commonUtil;

import io.appium.java_client.MobileElement;


public class AddToCartTest extends Apploader{

	String Username;
	String password;
	String searchItem;


	@BeforeTest
	public void login() throws IOException
	{
		try {
			this.Username=commonUtil.loadTestData("Username");
			this.password=commonUtil.loadTestData("password");
			this.searchItem=commonUtil.loadTestData("searchItemName");
			loginPage.menuButton().click();
			wait.until(ExpectedConditions.visibilityOf(loginPage.signInImg()));
			loginPage.signInImg().click();

			loginPage.userNameTextBox().sendKeys(this.Username);
			loginPage.passwordTextbox().sendKeys(this.password);
			driver.hideKeyboard();
			loginPage.loginButton().click();

			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(loginPage.homePage()));

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test  (groups= {"RegressionTest","smokeTest"},priority=0,alwaysRun=true)
	public void searchItem() throws InterruptedException
	{
		loginPage.searchFiled().sendKeys(searchItem);
		List<MobileElement> results = loginPage.searchResults();
		Assert.assertTrue((results.size() > 1), "results Lists Not Displayed");
		for (MobileElement elemnt : results)
			{
				if(elemnt.getText().contains(searchItem)){
					Reporter.log("Results displayed As Expected");
					elemnt.click();
					commonUtil.swipeDown();
					loginPage.addToCartBtn().click();
					Reporter.log("Item Added to the cart As Expected");
				}
			}
		}



}
