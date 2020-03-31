package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import newtest.TestBase;
import pageObjects.WelcomePage;
import utils.Helpers;

public class ScreenshotTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	Helpers hp;
  @Test
  public void screenShotTest() throws IOException {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples2";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  hp.takeScreenshot("welcomePage",driver);
  }
  
  @AfterTest
  public void closeBrowser(){
	log.info("8. Close browser");  
	cleanUp(driver);  
  }
  @AfterMethod
  public void checkStatus(ITestResult test) throws IOException{
	log.info("8. Close browser");  
	if(test.getStatus()==ITestResult.FAILURE){
		log.info("test is failed, so taking screenshot");
		Helpers.takeScreenshot(test.getName(), driver);
	}  
  }
  @BeforeTest
  @Parameters({"testName"})
  public void beforeTest(String testName) {
	  initLogger(testName);
	  log.info("0. Driver initialisation. Open browser");
	  driver=chromeWebDriver();  
  }
}
