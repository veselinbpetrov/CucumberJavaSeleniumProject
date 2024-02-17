This project is about BDD end-to-end test on eBay e-commerce web platform. Build with Maven project structure.
It's written on Java with Selenium WebDriver + Cucumber tools. 
For test execution it's used TestNG framework.
The exact technical dependencies about building and executing the script are outlined in the project's "pom.xml" file.

The test scenario is described in the "src/test/java/features/ebayProduct.feature" cucumber .feature file.
All page objects are located at the "src/test/java/pageObjects" package.
The test steps functions for each page object are created in the "src/test/java/stepDefinitions" package.
In the "src/test/java/utils" package are all lower-level java classes that are part of the framework.
You can run the test by executing "\src\test\java\cucumberOptions\TestNGTestRunner.java".
