package pageObjects;

import org.openqa.selenium.WebDriver;

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
	
	public HomePage getHomePage()
	{
		homePage = new HomePage(driver);
		return homePage;
	}
	
	public ProductListingPage getProductListingPage()
	{
		plpPage = new ProductListingPage(driver);
		return plpPage;
	}
	
	public ProductDetailsPage getProductDetailsPage()
	{
		pdpPage = new ProductDetailsPage(driver);
		return pdpPage;
	} 
	
	public CartPage getCartPage()
	{
		cartPage = new CartPage(driver);
		return cartPage;
	} 

}
