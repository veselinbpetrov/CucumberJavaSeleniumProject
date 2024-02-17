package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By drpCtg = By.id("gh-cat");
	By searchField = By.id("gh-ac");
	By searchButton = By.id("gh-btn");
	
	public void selectCategory(String category)
	{
		Select drpCategory = new Select(driver.findElement(drpCtg));
		drpCategory.selectByVisibleText(category);
	}
	
	public void searchProduct(String searchValue)
	{ 
		driver.findElement(searchField).sendKeys(searchValue);
	}
	
	public void clickSearchButton()
	{
		driver.findElement(searchButton).click();
		System.out.println("Search button clicked");
	}
}
