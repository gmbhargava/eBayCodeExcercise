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
	

	By dashBoard = By.id("dasBordId");

	By search = By.id("search_box");

	By searchfiled = By.id("search_src_text");

	By results = By.id("textview_item_name");

	By addCart = By.id("button_add_to_cart");
	
	
	 
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

	public MobileElement searchIcon()
	{
		MobileElement icon=(MobileElement) driver.findElement(search);
		return icon;
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
		MobileElement lgnButton=(MobileElement) driver.findElement(dashBoard);
		return lgnButton;
	}

	public MobileElement searchFiled()
	{
		MobileElement field=(MobileElement) driver.findElement(searchfiled);
		return field;
	}

	public List<MobileElement> searchResults()
	{
		List<MobileElement> fields=(List<MobileElement>) driver.findElement(results);
		return fields;
	}

	public MobileElement addToCartBtn()
	{
		MobileElement field=(MobileElement) driver.findElement(addCart);
		return field;
	}
	
}
