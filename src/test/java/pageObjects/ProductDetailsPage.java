package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//This is a PDP page class
public class ProductDetailsPage {

	public WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// PDP page locators
	By pdpProductName = By.cssSelector(".x-item-title__mainTitle .ux-textspans");
	By pdpProductPrimaryPrice = By.cssSelector(".x-price-primary .ux-textspans");
	By pdpProductConvertedPrice = By.cssSelector(".x-price-approx__price .ux-textspans");
	By shippingSectionTab = By.id("TABS_SPR");
	By shippingCountryOption = By.id("shCountry");
	By quantityField = By.id("qtyTextBox");
	By addToCartButton = By.xpath("//span[text()='Add to cart']");
	
	// Get and return as a string the product's title
	public String getProductName()
	{
		return driver.findElement(pdpProductName).getText();
	}
	
	// Get and return as a string the product's price
	public String getProductPrimaryPrice()
	{
		return driver.findElement(pdpProductPrimaryPrice).getText();
	}
	
	// Check and return true or false if product's converted price is displayed
	public Boolean isProductConvertedPriceDisplayed()
	{
		return driver.findElement(pdpProductConvertedPrice).isDisplayed();
	}
	
	// Get and return as a string the product's converted price
	public String getProductConvertedPrice()
	{
		return driver.findElement(pdpProductConvertedPrice).getText();
	}
	
	// Scroll the page and click on the 'Shipping, returns, and payments' tab
	public void clickShippingSectionTab()
	{
		WebElement shippingSection = driver.findElement(By.id("TABS_SPR"));
		Actions actions = new Actions(driver);
		actions.moveToElement(shippingSection);
		actions.perform();
		shippingSection.click();
		System.out.println("The 'Shipping, returns, and payments' tab is clicked");
	}
	
	// Get and return as a string the default shipping country
	public String getDefaultShippingCountryOption()
	{
		Select drpShippingCountry = new Select(driver.findElement(shippingCountryOption));
		WebElement option = drpShippingCountry.getFirstSelectedOption();
		String defaultCountryValue = option.getText();
		return defaultCountryValue;
	}
	
	// Set input for product quantity
	public void selectProductQuantity(Integer qtyValue)
	{
		WebElement qtyField = driver.findElement(quantityField);
		qtyField.clear();
		qtyField.sendKeys(String.valueOf(qtyValue));
	}
	
	// Click the Add to cart button
	public void clickAddToCartButton()
	{
		driver.findElement(addToCartButton).click();
	    System.out.println("Add to cart button clicked");
	}
	
	
}
