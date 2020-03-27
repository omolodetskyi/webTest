package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.CheckboxesPage;
import pageObjects.WelcomePage;

public class CheckCheckbox extends TestBase {
	WebDriver driver;
	WelcomePage welcomePage;
	CheckboxesPage checkboxesPage;
  @Test
  public void checkCheckbox() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click Checkboxes link");
	  checkboxesPage=welcomePage.clickCheckboxesLink();
	  String actualCheckboxesPageTitle=checkboxesPage.getTitle();
	  String expectedCheckboxesPageTitle="Checkboxes";
	  log.info("4. Check Checkboxes page title");
	  Assert.assertEquals(actualCheckboxesPageTitle, expectedCheckboxesPageTitle);
	  log.info("5. Click on the first checkbox");
	  checkboxesPage.checkCheckbox(0);
	  Boolean actualSelectedState=checkboxesPage.allCheckboxesChecked();
	  Boolean expectedSelectedState=true;
	  log.info("6. Verify that both checkboxes selected");
	  Assert.assertEquals(actualSelectedState, expectedSelectedState);
	 
  }
  @BeforeTest
  @Parameters({"testName"})
  public void beforeTest(String testName) {
	  initLogger(testName);
	  log.info("0. Initiate Driver");
	  driver=chromeWebDriver();
	 }
  @AfterTest
  public void closeBrowser(){
	 log.info("7. Close Driver");
	 cleanUp(driver);  
  }

}
