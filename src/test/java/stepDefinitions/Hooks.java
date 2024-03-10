package stepDefinitions;

import io.cucumber.java.After;
import utils.TestContextSetup;

// This is a Hooks class
public class Hooks {
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	// After hook used for quitting the driver session
	@After
	public void AfterScenario()
	{
		testContextSetup.testBase.WebDriverManager().quit();
	}
}
