package tests;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import newtest.TestBase;
import pageObjects.WelcomePage;
import pageObjects.jsErrorPage;
import utils.Helpers;

public class jsErrorTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	jsErrorPage jsErrorPage;
	SoftAssert softAssert;
  @Test
  public void jsErrorTest() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click Hovers link");
	  jsErrorPage=welcomePage.clickJsErrorLink();
	  List<LogEntry> logs=Helpers.getBrowserLogs(driver);
	  softAssert.fail("some fail of test");
	  //boolean containsError=false;
	  for(LogEntry logEntry:logs){
		  if(logEntry.getMessage().contains("error")){
			  //containsError=true;
			  softAssert.fail("JS error is found " + logEntry.getMessage());
			  //log.info("JS error is found " + logEntry.getMessage());
		  }
	  }
	  softAssert.assertAll();
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
