package pageObjects;

import org.openqa.selenium.WebDriver;

// This class is used as a global page object factory
public class PageObjectManager {
	
	public WebDriver driver;
	public HomePage homePage;
	public ProductListingPage plpPage;
	public ProductDetailsPage pdpPage;
	public CartPage cartPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	// Initializing a new Home page object
	public HomePage getHomePage()
	{
		homePage = new HomePage(driver);
		return homePage;
	}
	
	// Initializing a new PLP page object
	public ProductListingPage getProductListingPage()
	{
		plpPage = new ProductListingPage(driver);
		return plpPage;
	}
	
	// Initializing a new PDP page object
	public ProductDetailsPage getProductDetailsPage()
	{
		pdpPage = new ProductDetailsPage(driver);
		return pdpPage;
	} 
	
	// Initializing a new Cart page object
	public CartPage getCartPage()
	{
		cartPage = new CartPage(driver);
		return cartPage;
	} 

}
