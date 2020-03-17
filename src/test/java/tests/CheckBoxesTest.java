package tests;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.CheckBoxesPage;
import pageObjects.WelcomePage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CheckBoxesTest extends TestBase {
	private WelcomePage welcomePage;
	private CheckBoxesPage checkboxesPage;
	WebDriver driver;
  @Test
  public void checkBothCheckboxes() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click on Checkboxes link");
	  checkboxesPage=welcomePage.clickCheckboxesLink();
	  String actualCheckBoxesPageTitle=checkboxesPage.getTitle();
	  String expectedCheckBoxesPageTitle="Checkboxes";
	  log.info("3. Check Checkboxes page title");
	  Assert.assertEquals(actualCheckBoxesPageTitle, expectedCheckBoxesPageTitle);
	  log.info("4. Check first checkbox");
	  checkboxesPage.checkCheckbox(0);
	  Boolean actualResult=checkboxesPage.allCheckboxesChecked();
	  Boolean expectedResult=true;
	  log.info("5. Verify if all checkboxes checked");
	  Assert.assertEquals(actualResult, expectedResult);
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
