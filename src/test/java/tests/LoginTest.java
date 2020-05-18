package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.LoginPage;
import pageObjects.SecureAreaPage;
import pageObjects.WelcomePage;
import utils.Helpers;
import utils.Reports;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LoginTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
	ExtentReports report;
	ExtentTest test;
	public String something="test string";
	
  @Test
  public void loginTest() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  Reporter.log("1. Open welcome Page<p>", false);
	 // test.log(Status.INFO, "1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Reporter.log("2. Welcome page has Available Examples title<p>", false);
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	 // test.log(Status.PASS, "2. Welcome page has Available Examples title");
	  log.info("3. Click on Form Authentication link");
	  Reporter.log("3. Click on Form Authentication link<p>", false);
	  //test.log(Status.INFO, "3. Click on Form Authentication link");
	  loginPage=welcomePage.clickFormAuthenticationLink();
	  String actualLoginTitle=loginPage.getTitle();
	  String expectedLoginTitle="Login Page";
	  log.info("4. Check title on Login page");
	  Reporter.log("4. Check title on Login page<p>", false);
	  Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
	  //test.log(Status.PASS, "4. Check title on Login page");
	  log.info("5. Enter valid username/password");
	  Reporter.log("5. Enter valid username/password<p>", false);
	  //test.log(Status.INFO, "5. Enter valid username/password");
	  secureAreaPage=loginPage.enterUserNamePassword("tomsmith", "SuperSecretPassword!");
	  String actualSecureAreaPageTitle=secureAreaPage.getTitle();
	  log.info("6. Check title on Secure Area page");
	  Reporter.log("6. Check title on Secure Area page<p>", false);
	  String expectedSecureAreaPageTitle="Secure Area";
	  Assert.assertEquals(actualSecureAreaPageTitle, expectedSecureAreaPageTitle);
	  //test.log(Status.PASS, "6. Check title on Secure Area page");
	  String actualSecureAreaPageMsg=secureAreaPage.getMessage();
	  String expectedSecureAreaPageMsg="You logged into a secure area!";
	  log.info("7. Check message on Secure Area page");
	  Reporter.log("7. Check message on Secure Area page<p>", false);
	  Assert.assertEquals(actualSecureAreaPageMsg.contains(expectedSecureAreaPageMsg),true);
	 // test.log(Status.PASS, "7. Check message on Secure Area page");
  }
  @BeforeTest
  @Parameters({"testName","browser"})
  public void beforeTest(String testName, String browser, ITestContext context) throws MalformedURLException {
	  initLogger(testName);
	  //report=Reports.getInstance();
	 // test=report.createTest(testName);
	  //test=createTestReport(testName,report);
	  log.info("0. Driver initialisation. Open browser");
	  //test.log(Status.INFO, "0. Driver initialisation. Open browser");
	  Reporter.log("0. Driver initialisation. Open browser<p>", false);
	  driver=createWebDriver(browser);  
	 // context.setAttribute("driver", driver);
	  //context.setAttribute("test", test);
  }
  
  
  @AfterTest
  public void closeBrowser(){
	log.info("8. Close browser");  
	Reporter.log("9. Close browser<p>", false);
	//test.log(Status.INFO, "8. Close browser");
	//cleanUp(driver);  
	//report.flush();
  }

}
