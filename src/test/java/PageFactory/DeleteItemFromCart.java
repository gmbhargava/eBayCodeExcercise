package PageFactory;

import com.mobile.commonUtilities.Basedriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class DeleteItemFromCart extends Basedriver
{
	By cart=By.id("Cart button");

	By inCart = By.xpath("//android.widget.TextView[@text='IN CART']");

	By saved = By.xpath("//android.widget.TextView[@text='SAVED']");

	By searchfiled = By.id("search_src_text");

	By results = By.xpath("//android.widget.RelativeLayout[@id='item_details']//android.widget.TextView[@id='title']");

	By removeBtn = By.id("remove_from_cart_button");


	public DeleteItemFromCart(AndroidDriver<MobileElement> driver)
	{
		super(driver);
	}

	public MobileElement cartMenu()
	{
		MobileElement btn=(MobileElement) driver.findElement(cart);
		return btn;
	}


	public MobileElement inCartMenu()
	{
		MobileElement icon=(MobileElement) driver.findElement(inCart);
		return icon;
	}
	

	public MobileElement searchFiled()
	{
		MobileElement field=(MobileElement) driver.findElement(searchfiled);
		return field;
	}

	public List<MobileElement> cartItems()
	{
		List<MobileElement> fields=(List<MobileElement>) driver.findElement(results);
		return fields;
	}

	public List<MobileElement> deleteCartBtn()
	{
        List<MobileElement> field=(List<MobileElement>) driver.findElement(removeBtn);
		return field;
	}
	
}
