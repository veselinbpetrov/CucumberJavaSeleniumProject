package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String plpProductName;
	public String plpProductPrice;
	public Integer productQty;
	public Double pdpPrice;
	public PageObjectManager pageOjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup()
	{
		testBase = new TestBase();
		pageOjectManager = new PageObjectManager(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());
	}
}
