package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.LoginPage;
import pageObjects.SecureAreaPage;
import pageObjects.WelcomePage;
import utils.Helpers;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class LoginTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
  @Test
  public void loginTest() throws IOException {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  Reporter.log("1. Open welcome Page<p>", false);
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Reporter.log("2. Welcome page has Available Examples title<p>", false);
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click on Form Authentication link");
	  Reporter.log("3. Click on Form Authentication link<p>", false);
	  loginPage=welcomePage.clickFormAuthenticationLink();
	  String actualLoginTitle=loginPage.getTitle();
	  String expectedLoginTitle="Login Page";
	  log.info("4. Check title on Login page");
	  Reporter.log("4. Check title on Login page<p>", false);
	  Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
	  log.info("5. Enter valid username/password");
	  Reporter.log("5. Enter valid username/password<p>", false);
	  secureAreaPage=loginPage.enterUserNamePassword("tomsmith", "SuperSecretPassword!");
	  String actualSecureAreaPageTitle=secureAreaPage.getTitle();
	  log.info("6. Check title on Secure Area page");
	  Reporter.log("6. Check title on Secure Area page<p>", false);
	  String expectedSecureAreaPageTitle="Secure Area";
	  Assert.assertEquals(actualSecureAreaPageTitle, expectedSecureAreaPageTitle);
	  String actualSecureAreaPageMsg=secureAreaPage.getMessage();
	  String expectedSecureAreaPageMsg="You logged into a secure area!";
	  log.info("7. Check message on Secure Area page");
	  Reporter.log("7. Check message on Secure Area page<p>", false);
	  Assert.assertEquals(actualSecureAreaPageMsg.contains(expectedSecureAreaPageMsg),true);
	  Reporter.log("8. Take screenshot<p>" , false);
	  Helpers.takeScreenshot(driver, "logintestEdge.jpg");
  }
  @BeforeTest
  @Parameters({"testName","browser"})
  public void beforeTest(String testName, String browser) throws MalformedURLException {
	  initLogger(testName);
	  log.info("0. Driver initialisation. Open browser");
	  Reporter.log("0. Driver initialisation. Open browser<p>", false);
	  //driver=firefoxWebDriver();
	  driver=createWebDriver(browser); 
  }
  @AfterTest
  public void closeBrowser(){
	log.info("8. Close browser");  
	Reporter.log("9. Close browser<p>", false);
	cleanUp(driver);  
  }

}
