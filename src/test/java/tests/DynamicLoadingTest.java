package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.DynamicLoadingPage;
import pageObjects.HiddenElementPage;
import pageObjects.RenderedElementPage;
import pageObjects.WelcomePage;

public class DynamicLoadingTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	HiddenElementPage hiddenElementPage;
	RenderedElementPage renderedElementPage;
	DynamicLoadingPage dynamicLoadingPage;
  @Test
  public void hiddenElementTest() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click DropDown link");
	  dynamicLoadingPage=welcomePage.clickDynamicLoadingLink(); 
	  hiddenElementPage=dynamicLoadingPage.clickHiddenElementLink();
	  hiddenElementPage.clickStartButton();
	  Assert.assertTrue(hiddenElementPage.helloWorldIsVisible());
  }
  @Test
  public void renderedElementTest() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click DropDown link");
	  dynamicLoadingPage=welcomePage.clickDynamicLoadingLink(); 
	  renderedElementPage=dynamicLoadingPage.clickRenderedElementLink();
	  renderedElementPage.clickStartButton();
	  Assert.assertTrue(renderedElementPage.helloWorldIsRendered());
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
	// cleanUp(driver);  
  }
}