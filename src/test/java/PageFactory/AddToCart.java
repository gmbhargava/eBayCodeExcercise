package PageFactory;

import com.mobile.commonUtilities.Basedriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class AddToCart extends Basedriver
{
	By menuBtn=By.id("Main navigation, open");

	By dashBoard = By.id("dasBordId");

	By search = By.id("search_box");

	By searchfiled = By.id("search_src_text");

	By results = By.id("textview_item_name");

	By addCart = By.id("button_add_to_cart");


	public AddToCart(AndroidDriver<MobileElement> driver)
	{
		super(driver);
	}

	public MobileElement menuButton()
	{
		MobileElement btn=(MobileElement) driver.findElement(menuBtn);
		return btn;
	}


	public MobileElement searchIcon()
	{
		MobileElement icon=(MobileElement) driver.findElement(search);
		return icon;
	}
	
	public MobileElement homePage()
	{
		MobileElement pg=(MobileElement) driver.findElement(dashBoard);
		return pg;
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
