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


public class LoginTest extends Apploader{

	String Username;
	String password;

	@Test  (groups= {"RegressionTest","smokeTest"},priority=0,alwaysRun=true)
	public void login() throws IOException, InterruptedException {
        this.Username=commonUtil.loadTestData("Username");
        this.password=commonUtil.loadTestData("password");
        loginPage.menuButton().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.signInImg()));
        loginPage.signInImg().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.userNameTextBox()));
        loginPage.userNameTextBox().sendKeys(this.Username);
        loginPage.passwordTextbox().sendKeys(this.password);
        driver.hideKeyboard();
        loginPage.loginButton().click();
        loginPage.noThanksBtn().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.homePage()));
        Assert.assertTrue(loginPage.homePage().isDisplayed(),"Login not succesfull");
        Reporter.log("Login completed successfully");

    }
}
