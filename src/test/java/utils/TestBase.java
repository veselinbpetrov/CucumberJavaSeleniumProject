package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// This is a Test Base class
public class TestBase {

	public WebDriver driver;
	
	// Initializing a new driver session
	public WebDriver WebDriverManager()
	{
		if(driver== null)
		{
		System.setProperty("webdriver.chrome.driver", "D:/Drivers/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ebay.com/");
		driver.manage().window().maximize();
	}
		return driver;
	}
}