package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void switchToNewBrowserTab() 
	{
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
		System.out.println("Switching to a new browser tab window");
	}
	
	public void checkPageUrl(String pageUrl)
	{
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, pageUrl);
		System.out.println("The expected page URL " + actualUrl + " is opened");
	}
}
