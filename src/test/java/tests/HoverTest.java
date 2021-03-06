package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.HoversPage;
import pageObjects.WelcomePage;

public class HoverTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	HoversPage  hoversPage;
  @Test
  public void hoverTest() {
	  int userIndex=1;
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click Hovers link");
	  hoversPage=welcomePage.clickHoversLink();
	  hoversPage.hoverAvatar(userIndex);
	  hoversPage.clickViewProfileLink(userIndex);
  }
  @BeforeTest
  @Parameters({"testName","browser"})
  public void beforeTest(String testName, String browser) throws MalformedURLException {
	  initLogger(testName);
	  log.info("0. Driver initialisation. Open browser");
	  //driver=firefoxWebDriver();
	  driver=createWebDriver(browser); 
  }
  @AfterTest
  public void closeBrowser(){
	 log.info("7. Close Driver");
	 //cleanUp(driver);  
  }
}
