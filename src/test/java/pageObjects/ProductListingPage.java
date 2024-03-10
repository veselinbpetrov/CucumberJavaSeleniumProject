package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This is a PLP page class
public class ProductListingPage {

	public WebDriver driver;
	
	public ProductListingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// PLP page locators
	By plpProductName = By.cssSelector(".srp-results .s-item__title span");
	By plpProductPrice = By.cssSelector(".srp-results .s-item__price");
	By shippingToSelector = By.xpath("//button[text()='Shipping to']//span");
	
	// Get and return as a string the product's title
	public String getProductName()
	{
		return driver.findElement(plpProductName).getText();
	}
	
	// Get and return as a string the shipping country 
	public String getShippingCountry()
	{
		return driver.findElement(shippingToSelector).getText();
	}
	
	// Get and return as a string the product's price
	public String getProductPrice()
	{
		return driver.findElement(plpProductPrice).getText();
	}
	
	// Click on the first product
	public void clickProduct()
	{
		driver.findElement(plpProductName).click();
		System.out.println("The product is clicked");
	}
}
