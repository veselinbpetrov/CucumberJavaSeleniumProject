package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public WebDriver driver;
	
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