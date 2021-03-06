package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.LoginPage;
import pageObjects.SecureAreaPage;
import pageObjects.WelcomePage;
import utils.Helpers;
import utils.extentreports.ExtentReportsManager;
import utils.extentreports.ExtentTestManager;

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
	ExtentTest test;
	ExtentReports extent;
  @Test(description="happy path for Login page")
  public void loginTest() throws IOException {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  Reporter.log("1. Open <b>welcome</b> Page<p>");
	  test.log(Status.INFO,"1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Reporter.log("2. Welcome page has Available Examples title<p>");
	  test.log(Status.INFO,"2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click on Form Authentication link");
	  Reporter.log("3. Click on Form Authentication link<p>");
	  test.log(Status.INFO,"3. Click on Form Authentication link");
	  loginPage=welcomePage.clickFormAuthenticationLink();
	  String actualLoginTitle=loginPage.getTitle();
	  String expectedLoginTitle="Login Page";
	  log.info("4. Check title on Login page");
	  Reporter.log("4. Check title on Login page<p>");
	  test.log(Status.INFO,"4. Check title on Login page");
	  Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
	  log.info("5. Enter valid username/password");
	  Reporter.log("5. Enter valid username/password<p>");
	  test.log(Status.INFO,"5. Enter valid username/password");
	  secureAreaPage=loginPage.enterUserNamePassword("tomsmith", "SuperSecretPassword!");
	  String actualSecureAreaPageTitle=secureAreaPage.getTitle();
	  log.info("6. Check title on Secure Area page");
	  Reporter.log("6. Check title on Secure Area page<p>");
	  test.log(Status.INFO,"6. Check title on Secure Area page");
	  String expectedSecureAreaPageTitle="Secure Area";
	  Assert.assertEquals(actualSecureAreaPageTitle, expectedSecureAreaPageTitle);
	  String actualSecureAreaPageMsg=secureAreaPage.getMessage();
	  String expectedSecureAreaPageMsg="You logged into a secure area!2";
	  log.info("7. Check message on Secure Area page");
	  test.log(Status.INFO,"7. Check message on Secure Area page");
	  Reporter.log("7. Check message on Secure Area page<p>");
	  Assert.assertEquals(actualSecureAreaPageMsg.contains(expectedSecureAreaPageMsg),true);
  }
  @BeforeTest
  @Parameters({"testName","browser"})
  public void beforeTest(String testName, String browser, ITestContext context) throws MalformedURLException {
	  initLogger(testName);
	  log.info("0. Driver initialisation. Open browser");
	  Reporter.log("0. Driver initialisation. Open browser<p>");
	  //driver=firefoxWebDriver();
	  driver=createWebDriver(browser); 
	  context.setAttribute("webdriver", driver);
	  extent=ExtentReportsManager.getInstance();
	  test = ExtentTestManager.createTest("Login Test with valid username/password", "happy path for Login page");
  }
  @AfterTest
  public void closeBrowser(){
	log.info("8. Close browser"); 
	Reporter.log("8. Close browser<p>");
	test.log(Status.INFO, "8. Close browser");
	cleanUp(driver);  
  }

}
