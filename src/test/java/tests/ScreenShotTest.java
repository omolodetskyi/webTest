package tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.WelcomePage;
import utils.Helpers;

public class ScreenShotTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
  @Test
  public void scrollTest()  {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  Assert.assertTrue(false);
	 
  }
  @AfterMethod
  public void checkStatus(ITestResult test) throws IOException{
	  if(test.getStatus()==ITestResult.FAILURE){
	  Helpers.takeScreenshot(driver,test.getName());  
	  }
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
