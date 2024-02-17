package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CartPage {
	
	public WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By cartProductPrice = By.cssSelector(".item-price .text-display-span span span");
	By quantityField = By.xpath("//select[@data-test-id='qty-dropdown']");
	
	public void checkCartPageUrl(String pageUrl)
	{
		driver.get(pageUrl);
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, pageUrl);
		System.out.println("The expected page URL " + actualUrl + " is opened");
	}
	
	
	public String getProductQuantity()
	{
		Select drpQnt = new Select(driver.findElement(quantityField));
		WebElement option = drpQnt.getFirstSelectedOption();
		String quantity = option.getText();
		return quantity;
	}
	
	public String getProductPrice()
	{
		return driver.findElement(cartProductPrice).getText();
	}
	
}
