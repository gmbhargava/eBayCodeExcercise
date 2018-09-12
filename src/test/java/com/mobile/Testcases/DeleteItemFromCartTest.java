package com.mobile.Testcases;

import com.mobile.commonUtilities.Apploader;
import com.mobile.commonUtilities.commonUtil;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;


public class DeleteItemFromCartTest extends Apploader{

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
	public void deleteItem() throws InterruptedException
	{
		deleteItemFromCart.cartMenu().click();
		wait.until(ExpectedConditions.visibilityOf(deleteItemFromCart.inCartMenu()));
		List<MobileElement> items = deleteItemFromCart.cartItems();
		Assert.assertTrue((items.size() > 1), "Cart Lists Not Displayed");
		for (int i=0;i<items.size(); i++)
			{
				if(items.get(i).getText().contains(searchItem)){
					Reporter.log("Items  displayed As Expected");
					deleteItemFromCart.deleteCartBtn().get(i).click();
					Reporter.log("Item removed from the cart As Expected");
				}
			}
		}



}
