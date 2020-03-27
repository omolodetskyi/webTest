package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.KeyPressesPage;
import pageObjects.WelcomePage;

public class KeyPressesTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	KeyPressesPage keyPressesPage;
  @Test
  public void keyPressesTest() {
  welcomePage=new WelcomePage(driver);
  welcomePage.openPage();
  log.info("1. Open welcome Page");
  String actualWelcomeTitle=welcomePage.getTitle();
  String expectedWelcomeTitle="Available Examples";
  log.info("2. Welcome page has Available Examples title");
  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
  log.info("3. Click Checkboxes link");
  keyPressesPage=welcomePage.clickKeyPressesLink();
  //keyPressesPage.pressKey(Keys.ENTER);
  
  keyPressesPage.pressKeyByAction(Keys.ENTER);
  String actualResult=keyPressesPage.getResult();
  String expectedResult="You entered: ENTER";
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
	// cleanUp(driver);  
  }
}
