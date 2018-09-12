package com.mobile.Testcases;

import java.io.IOException;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
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
			loginPage.noThanksBtn().click();
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
		addToCart.searchFiled().sendKeys(searchItem);
		///clicks on search button on keyboard
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.ENTER);
		List<MobileElement> results = addToCart.searchResults();
		Assert.assertTrue((results.size() > 1), "results Lists Not Displayed");
		for (MobileElement elemnt : results)
			{
				if(elemnt.getText().contains(searchItem)){
					Reporter.log("Results displayed As Expected");
					elemnt.click();
					//Swipe until element found
					commonUtil.swipeUntilElementFound(addToCart.addToCartBtn());
					addToCart.addToCartBtn().click();
					Reporter.log("Item Added to the cart As Expected");
				}
			}
		}

	@Test  (groups= {"RegressionTest","smokeTest"},priority=0,alwaysRun=true)
	public void verifyCart() throws InterruptedException
	{
		deleteItemFromCart.cartMenu().click();
		wait.until(ExpectedConditions.visibilityOf(deleteItemFromCart.inCartMenu()));
		List<MobileElement> items = deleteItemFromCart.cartItems();
		for (MobileElement elemnt : items)
		{
			if(elemnt.getText().contains(searchItem)){
				Reporter.log("Results displayed As Expected");
				Assert.assertTrue((elemnt.getText().contains(searchItem)), "Cart Lists Not Displayed");
				Reporter.log("Item Added to the cart As Expected");
			}
		}
	}



}
