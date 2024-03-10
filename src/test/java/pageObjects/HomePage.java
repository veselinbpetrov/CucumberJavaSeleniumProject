package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

//This is a Home page class
public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// Home page locators
	By drpCtg = By.id("gh-cat");
	By searchField = By.id("gh-ac");
	By searchButton = By.id("gh-btn");
	
	// Select product category from the drop-down
	public void selectCategory(String category)
	{
		Select drpCategory = new Select(driver.findElement(drpCtg));
		drpCategory.selectByVisibleText(category);
	}
	
	// Populate input in the Search field
	public void searchProduct(String searchValue)
	{ 
		driver.findElement(searchField).sendKeys(searchValue);
	}
	
	// Click the Search button
	public void clickSearchButton()
	{
		driver.findElement(searchButton).click();
		System.out.println("Search button clicked");
	}
}
