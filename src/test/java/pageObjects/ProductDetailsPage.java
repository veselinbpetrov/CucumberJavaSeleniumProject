package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {

	public WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By pdpProductName = By.cssSelector(".x-item-title__mainTitle .ux-textspans");
	By pdpProductPrimaryPrice = By.cssSelector(".x-price-primary .ux-textspans");
	By pdpProductConvertedPrice = By.cssSelector(".x-price-approx__price .ux-textspans");
	By shippingSectionTab = By.id("TABS_SPR");
	By shippingCountryOption = By.id("shCountry");
	By quantityField = By.id("qtyTextBox");
	By addToCartButton = By.xpath("//span[text()='Add to cart']");
	
	public String getProductName()
	{
		return driver.findElement(pdpProductName).getText();
	}
	
	public String getProductPrimaryPrice()
	{
		return driver.findElement(pdpProductPrimaryPrice).getText();
	}
	
	public Boolean isProductConvertedPriceDisplayed()
	{
		return driver.findElement(pdpProductConvertedPrice).isDisplayed();
	}
	
	public String getProductConvertedPrice()
	{
		return driver.findElement(pdpProductConvertedPrice).getText();
	}
	
	public void clickShippingSectionTab()
	{
		WebElement shippingSection = driver.findElement(By.id("TABS_SPR"));
		Actions actions = new Actions(driver);
		actions.moveToElement(shippingSection);
		actions.perform();
		shippingSection.click();
		System.out.println("The 'Shipping, returns, and payments' tab is clicked");
	}
	
	public String getDefaultShippingCountryOption()
	{
		Select drpShippingCountry = new Select(driver.findElement(shippingCountryOption));
		WebElement option = drpShippingCountry.getFirstSelectedOption();
		String defaultCountryValue = option.getText();
		return defaultCountryValue;
	}
	
	public void selectProductQuantity(Integer qtyValue)
	{
		WebElement qtyField = driver.findElement(quantityField);
		qtyField.clear();
		qtyField.sendKeys(String.valueOf(qtyValue));
	}
	
	public void clickAddToCartButton()
	{
		driver.findElement(addToCartButton).click();
	    System.out.println("Add to cart button clicked");
	}
	
	
}
