package stepDefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import pageObjects.CartPage;
import utils.TestContextSetup;

//This is the Cart page step definition class
public class CartPageStepDefinition {
	
public WebDriver driver;
public Integer productQty;
public TestContextSetup testContextSetup;
public CartPage cartPage;

public CartPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
	this.cartPage = testContextSetup.pageOjectManager.getCartPage();
}
	
	@Then("User is on the {string} page")
	public void check_cart_page(String pageUrl) {
		testContextSetup.genericUtils.checkPageUrl(pageUrl);
	}
	
	@Then("The expected quantity is displayed in the cart")
	public void check_cart_product_quantity() {
		String quantity = cartPage.getProductQuantity();
		// Parse the product quantity from String to Integer data type and assert with the expected value
		Integer cartQty = Integer.parseInt(quantity);
	    Assert.assertEquals(cartQty, testContextSetup.productQty);
	    System.out.println("The expected quantity: " + cartQty + " is added in the cart");
	}
	
	@Then("The expected calcuated price is displayed in the cart")
	public void check_cart_price() {
		String cartPrimaryPrice = cartPage.getProductPrice().substring(4);
		// Parse the product price from String to Double data type and assert with the expected value
		Double cartPrice = Double.parseDouble(cartPrimaryPrice);
		System.out.println("The product price on the Cart page is " + cartPrice);
		Assert.assertEquals(cartPrice, (testContextSetup.pdpPrice * testContextSetup.productQty));
	    System.out.println("The expected calcuated price is displayed in the cart");
	}
}
