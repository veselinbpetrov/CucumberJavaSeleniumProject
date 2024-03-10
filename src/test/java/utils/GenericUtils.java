package utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

// This class contains generic (common) methods for all page objects
public class GenericUtils {
	public WebDriver driver;
	public WebDriverWait driverWait;
	
	public GenericUtils(WebDriver driver, WebDriverWait driverWait)
	{
		this.driver = driver;
		this.driverWait = driverWait;
	}
	
	By headerSection = By.className("gh-tbl");
	
	// Method for switching from parent to child browser window
	public void switchToNewBrowserTab() 
	{
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
		System.out.println("Switching to a new browser tab window");
	}
	
	// Method for checking the expected page URL
	public void checkPageUrl(String pageUrl)
	{
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, pageUrl);
		System.out.println("The expected page URL " + actualUrl + " is opened");
	}
	
	// Method for checking page loading with explicit wait
	public void checkPageLoaded() {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(headerSection));
		System.out.println("The page is loaded");
	}
}
