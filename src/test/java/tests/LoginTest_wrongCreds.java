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
import utils.Reports;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class LoginTest_wrongCreds extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
	ExtentReports report;
	ExtentTest test;
	
  @Test
  @Parameters({"userName","password","errorMessage"})
  public void loginWithWrongCreds(String userName,String password, String errorMessage) {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  Reporter.log("1. Open welcome Page<p>", false);
	  test.log(Status.INFO, "1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Reporter.log("2. Welcome page has Available Examples title<p>", false);
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  test.log(Status.PASS, "2. Welcome page has Available Examples title");
	  log.info("3. Click Form Authentication link");
	  Reporter.log("3. Click on Form Authentication link<p>", false);
	  test.log(Status.INFO, "3. Click on Form Authentication link");
	  loginPage=welcomePage.clickFormAuthenticationLink();
	  String actualLoginTitle=loginPage.getTitle();
	  String expectedLoginTitle="Login Page2";
	  log.info("4. Check Login title");
	  Reporter.log("4. Check title on Login page<p>", false);
	  Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
	  test.log(Status.PASS, "4. Check title on Login page");
	  log.info("5. Enter invalid username/password");
	  Reporter.log("5. Enter invalid username/password:"+userName+"/"+password+"<p>", false);
	  test.log(Status.INFO, "5. Enter invalid username/password:"+userName+"/"+password);
	  secureAreaPage=loginPage.enterUserNamePassword(userName, password);
	  String actualLoginPageMsg=loginPage.getMessage();
	  String expectedLoginPageMsg=errorMessage;
	  log.info("6. Check '"+expectedLoginPageMsg+"' error message on Login Page");
	  Reporter.log("6. Check '"+expectedLoginPageMsg+"' error message on Login Page<p>", false);
	  Assert.assertEquals(actualLoginPageMsg.contains(expectedLoginPageMsg),true);
	  test.log(Status.PASS, "6. Check '"+expectedLoginPageMsg+"' error message on Login Page");
  }
 
  @BeforeTest
  @Parameters({"testName","browser"})
  public void beforeTest(String testName, String browser, ITestContext context) throws MalformedURLException {
	  initLogger(testName);
	  log.info("0. Driver initialisation. Open browser");
	  Reporter.log("0. Driver initialisation. Open browser<p>", false);
	  //driver=firefoxWebDriver();
	  report=Reports.getInstance();
	  test=report.createTest(testName);
	  //test=createTestReport(testName,report);
	  test.log(Status.INFO, "0. Driver initialisation. Open browser");
	  driver=createWebDriver(browser); 
	  context.setAttribute("driver", driver);
	  context.setAttribute("test", test);
  }
  @AfterTest
  public void closeBrowser(){
	 log.info("7. Close Driver");
	 Reporter.log("9. Close browser<p>", false);
	 test.log(Status.INFO, "8. Close browser");
	cleanUp(driver);  
	report.flush();
  }
  
}
