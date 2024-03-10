package stepDefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductDetailsPage;
import utils.TestContextSetup;

//This is the PDP page step definition class
public class ProductDetailsPageStepDefinition {
	
public WebDriver driver;
public String pdpProductName;
public String pdpProductConvertedPrice;
public String pdpProductPrimaryPrice;
public TestContextSetup testContextSetup;
public ProductDetailsPage pdpPage;

public ProductDetailsPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
	this.pdpPage = testContextSetup.pageOjectManager.getProductDetailsPage();
}

	@Then("The item title on PDP is matching")
	public void check_pdp_product_name() {		
		testContextSetup.genericUtils.switchToNewBrowserTab();
		pdpProductName = pdpPage.getProductName();
		System.out.println("The product name on PDP is " + pdpProductName);
		Assert.assertEquals(testContextSetup.plpProductName, pdpProductName);
	    System.out.println("The product titles matches on PLP and PDP");
	}
	
	@Then("The item price on PDP is matching")
	public void check_pdp_product_price() {
		pdpProductConvertedPrice = pdpPage.getProductConvertedPrice().split(" ")[1];
		System.out.println("The product converted price on PDP is " + pdpProductConvertedPrice);
		Assert.assertTrue(testContextSetup.plpProductPrice.contains(pdpProductConvertedPrice));
	    System.out.println("The product prices match on PLP and PDP");
	    // Parse the product price from String to Double data type and remove the currency symbols
	    pdpProductPrimaryPrice = pdpPage.getProductPrimaryPrice().substring(4);
	    testContextSetup.pdpPrice = Double.parseDouble(pdpProductPrimaryPrice);
	    System.out.println("The product primary price on PDP is " + testContextSetup.pdpPrice);
	}
	
	@When("User scrolls and clicks on Shipping and payments section")
	public void click_on_shipping_payment_tab() {
		pdpPage.clickShippingSectionTab();
	}
	
	@Then("{string} exists in the country drop down list")
	public void check_pdp_shipping_country(String country) {
		String defaultCountryValue = pdpPage.getDefaultShippingCountryOption();
	    Assert.assertEquals(defaultCountryValue, country);
	    System.out.println("The defaulf shipping country option is " + defaultCountryValue);
	}
	
	@When("User selects quantity {int}")
	public void select_product_quantity(Integer qtyValue) {
		pdpPage.selectProductQuantity(qtyValue);
		testContextSetup.productQty = qtyValue;
		System.out.println("Product quantity: " + qtyValue + " is set");
	}
	
	@When("User clicks Add to cart button")
	public void click_add_to_cart_btn() {
		pdpPage.clickAddToCartButton();
	}
}