package PageFactory;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import com.mobile.commonUtilities.Basedriver;

import java.util.List;

public class Login extends Basedriver
{
	By menuBtn=By.id("Main navigation, open");

	By signIn= By.id("Sign in,double tap to activate");

	By usrName=By.id("edit_text_username");

	By password=By.id("edit_text_password");
	
	By lgnBtn=By.id("button_sign_in");

	By noThanks=By.xpath("//android.widget.Button[contains(@id,'button_google_deny')]");

	By dashBoard = By.id("search_box");



	
	 
	public Login(AndroidDriver<MobileElement> driver)
	{
		super(driver);
	}

	public MobileElement menuButton()
	{
		MobileElement btn=(MobileElement) driver.findElement(menuBtn);
		return btn;
	}

	public MobileElement signInImg()
	{
		MobileElement img=(MobileElement) driver.findElement(signIn);
		return img;
	}


	public MobileElement userNameTextBox()
	{
		MobileElement usrNameTextBox=(MobileElement) driver.findElement(usrName);
		return usrNameTextBox;
	}
	

	
	public MobileElement passwordTextbox()
	{
		MobileElement passwrdTextbox=(MobileElement) driver.findElement(password);
		return passwrdTextbox;
	}
	
	public MobileElement loginButton()
	{
		MobileElement lgnButton=(MobileElement) driver.findElement(lgnBtn);
		return lgnButton;
	}
	public MobileElement homePage()
	{
		MobileElement dasboard=(MobileElement) driver.findElement(dashBoard);
		return dasboard;
	}

	public MobileElement noThanksBtn()
	{
		MobileElement btn=(MobileElement) driver.findElement(noThanks);
		return btn;
	}


}
