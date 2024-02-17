package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utils.TestContextSetup;

public class HomePageStepDefinition {
	
public WebDriver driver;
public TestContextSetup testContextSetup;
public HomePage homePage;

public HomePageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
	this.homePage = testContextSetup.pageOjectManager.getHomePage();
}

	@Given("User is on the eBay {string} page")
	public void check_home_page(String pageUrl) {
		testContextSetup.genericUtils.checkPageUrl(pageUrl);
	}
	
	@When("User selects the category {string} from the drop-down")
	public void select_product_cateogry(String category) {
		homePage.selectCategory(category);		
		System.out.println(category + " category is selected");
	}
	
	@When("User sets value {string} in the search field")
	public void enter_search_value(String searchValue) {
		homePage.searchProduct(searchValue);
		System.out.println("The search field input is " + searchValue);
	}
	
	@When("User clicks the Search button")
	public void click_search_button() {
		homePage.clickSearchButton();
	}
}