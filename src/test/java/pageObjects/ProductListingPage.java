package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {

	public WebDriver driver;
	
	public ProductListingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By plpProductName = By.cssSelector(".srp-results .s-item__title span");
	By plpProductPrice = By.cssSelector(".srp-results .s-item__price");
	By shippingToSelector = By.xpath("//button[text()='Shipping to']//span");
	
	public String getProductName()
	{
		return driver.findElement(plpProductName).getText();
	}
	
	public String getShippingCountry()
	{
		return driver.findElement(shippingToSelector).getText();
	}
	
	public String getProductPrice()
	{
		return driver.findElement(plpProductPrice).getText();
	}
	
	public void clickProduct()
	{
		driver.findElement(plpProductName).click();
		System.out.println("The product is clicked");
	}
}
