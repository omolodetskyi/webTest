package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.LoginPage;
import pageObjects.SecureAreaPage;
import pageObjects.WelcomePage;
import utils.extentReports.ExtentReportsManager;
import utils.extentReports.ExtentTestManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class LoginTest_wrongCreds extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
	ExtentTest test;
	ExtentReports extent;
  @Test
  @Parameters({"userName","password","errorMessage"})
  public void loginWithWrongCreds(String userName,String password, String errorMessage) {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  test.log(Status.INFO, "1. Open welcome Page");
	  Reporter.log("1. Open welcome Page<p/>");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Reporter.log("2. Welcome page has Available Examples title<p/>");
	  test.log(Status.INFO, "2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click Form Authentication link");
	  test.log(Status.INFO, "3. Click on Form Authentication link");
	  Reporter.log("3. Click on Form Authentication link<p/>");
	  loginPage=welcomePage.clickFormAuthenticationLink();
	  String actualLoginTitle=loginPage.getTitle();
	  String expectedLoginTitle="Login Page";
	  log.info("4. Check Login title");
	  test.log(Status.INFO, "4. Check title on Login page");
	  Reporter.log("4. Check title on Login page<p/>");
	  Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
	  log.info("5. Enter invalid username/password");
	  Reporter.log("5. Enter invalid username/password<p/>");
	  test.log(Status.INFO, "5. Enter valid username/password");
	  secureAreaPage=loginPage.enterUserNamePassword(userName, password);
	  String actualLoginPageMsg=loginPage.getMessage();
	  String expectedLoginPageMsg=errorMessage;
	  log.info("6. Check '"+expectedLoginPageMsg+"' error message on Login Page");
	  Reporter.log("6. Check '"+expectedLoginPageMsg+"' error message on Login Page");
	  test.log(Status.INFO, "6. Check '"+expectedLoginPageMsg+"' error message on Login Page");
	  Assert.assertEquals(actualLoginPageMsg.contains(expectedLoginPageMsg),true);
  }
  @BeforeTest
  @Parameters({"testName","browser"})
  public void beforeTest(String testName, String browser) throws MalformedURLException {
	  initLogger(testName);
	  log.info("0. Driver initialisation. Open browser");
	  Reporter.log("0. Driver initialisation. Open browser<p/>");
	  extent=ExtentReportsManager.getInstance();
	  test=ExtentTestManager.startTest(testName, "Login test with valid username/password");
	  //driver=firefoxWebDriver();
      //test = extent.createTest(testName, "Testing login page with invalid username or password");
      test.log(Status.INFO, "0. Driver initialisation. Open browser");
	  driver=createWebDriver(browser); 
  }
  @AfterTest
  public void closeBrowser(){
	 log.info("7. Close Driver");
	 Reporter.log("7. Close browser<p/>");
	cleanUp(driver); 
	test.log(Status.INFO, "7. Close browser");
  }

}
