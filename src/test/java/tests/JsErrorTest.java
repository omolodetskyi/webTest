package tests;

import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import newtest.TestBase;
import pageObjects.JsErrorPage;
import pageObjects.WelcomePage;
import utils.Helpers;

public class JsErrorTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	JsErrorPage jsErrorPage;
	SoftAssert softAssert;
  @Test
  public void checkLog() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  jsErrorPage=welcomePage.clickJsErrorPageLink();
	  List<LogEntry> logs=Helpers.getBrowserLog(driver);
	 // boolean containsError=false;
	  for(LogEntry logEntry:logs){
		// if(logEntry.getMessage().contains("error")){
		  if(logEntry.getLevel().equals(Level.SEVERE)){
			 log.info("JS error is found: "+logEntry.getMessage());
			// containsError=true;
			 
			 softAssert.fail("Failed because of JS error: "+logEntry.getMessage());
		 }
		 //Assert.assertEquals(containsError, false);
		  
		  
	  }
	  softAssert.assertAll();
  }
  @BeforeTest
  @Parameters({"testName"})
  public void beforeTest(String testName) {
	  initLogger(testName);
	  log.info("0. Initiate Driver");
	  driver=chromeWebDriver();
	  softAssert=new SoftAssert();
	 }
  @AfterTest
  public void closeBrowser(){
	  
	 log.info("7. Close Driver");
	//cleanUp(driver);  
  }
}
