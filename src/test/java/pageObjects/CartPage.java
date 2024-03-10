package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

// This is a Cart page class
public class CartPage {
	
	public WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// Cart page locators
	By cartProductPrice = By.cssSelector(".item-price .text-display-span span span");
	By quantityField = By.xpath("//select[@data-test-id='qty-dropdown']");
	
	// Check the expected cart page URL
	public void checkCartPageUrl(String pageUrl)
	{
		driver.get(pageUrl);
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, pageUrl);
		System.out.println("The expected page URL " + actualUrl + " is opened");
	}
	
	// Get and return as a string the added product's quantity 
	public String getProductQuantity()
	{
		Select drpQnt = new Select(driver.findElement(quantityField));
		WebElement option = drpQnt.getFirstSelectedOption();
		String quantity = option.getText();
		return quantity;
	}
	
	// Get and return as a string the product's price
	public String getProductPrice()
	{
		return driver.findElement(cartProductPrice).getText();
	}
	
}
