package stepDefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductListingPage;
import utils.TestContextSetup;

//This is the PLP page step definition class
public class ProductListingPageStepDefinition {
	
public WebDriver driver;
public TestContextSetup testContextSetup;
public ProductListingPage plpPage;

public ProductListingPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
	this.plpPage = testContextSetup.pageOjectManager.getProductListingPage();
}

	@Then("The first item on the PLP has the title: {string}")
	public void check_plp_product_name(String title) {
		testContextSetup.plpProductName = plpPage.getProductName();
		System.out.println("The product name on PLP is " + testContextSetup.plpProductName);
		Assert.assertTrue(testContextSetup.plpProductName.contains(title), "");
		System.out.println("The product is a " + title + " item");
	}
	
	@Then("There is a shipping option to {string}")
	public void check_plp_shipping_country(String country) {
	    String plpShippingCountry = plpPage.getShippingCountry();
	    Assert.assertEquals(plpShippingCountry, country);
	    System.out.println("The shipping country is " + plpShippingCountry);
	}
	
	@Then("Price is displayed for the item")
	public void get_plp_product_price() {
		testContextSetup.plpProductPrice = plpPage.getProductPrice();
		System.out.println("The product " + testContextSetup.plpProductName + " price is " + testContextSetup.plpProductPrice);
	}
	
	@When("User clicks on the first item")
	public void click_on_first_plp_product() {
		plpPage.clickProduct();
	}
}
