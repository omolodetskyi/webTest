package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.qameta.allure.Step;

import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.LoginPage;
import pageObjects.SecureAreaPage;
import pageObjects.WelcomePage;
import utils.extentreports.ExtentReportsManager;
import utils.extentreports.ExtentTestManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTest_wrongCreds extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
	ExtentTest test;
	ExtentReports extent;
  @Test(description="negative check for Login page")
  @Parameters({"userName","password","errorMessage"})
  public void loginWithWrongCreds(String userName,String password, String errorMessage) {
	  openWelcomePage();
	  checkWelcomePageTitle();
	  clickFormAuthenticationLink();
	  checkLoginTitle();
	  enterUserNamePassword(userName, password);
	  checkErrorMessage(errorMessage);
  }
  @Step("Open welcome Page")
  private void openWelcomePage(){
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  test.log(Status.INFO,"1. Open welcome Page");  
  }
  @Step("Welcome page has Available Examples title")
  private void checkWelcomePageTitle(){
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  test.log(Status.INFO,"2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle); 
  }
  @Step("Click Form Authentication link")
  private void clickFormAuthenticationLink(){
	  log.info("3. Click Form Authentication link");
	  loginPage=welcomePage.clickFormAuthenticationLink();
  }
  @Step("Check Login title")
  private void checkLoginTitle(){
	  String actualLoginTitle=loginPage.getTitle();
	  String expectedLoginTitle="Login Page";
	  log.info("4. Check Login title");
	  Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
  }
 @Step("Enter invalid username/password ({0}/{1})")
 
 private void enterUserNamePassword(String userName, String password){
	 log.info("5. Enter invalid username/password");
	  secureAreaPage=loginPage.enterUserNamePassword(userName, password);
 }
 @Step("Check '{0}' error message on Login Page")
 private void checkErrorMessage(String errorMessage){
	 String actualLoginPageMsg=loginPage.getMessage();
	  String expectedLoginPageMsg=errorMessage;
	  log.info("6. Check '"+expectedLoginPageMsg+"' error message on Login Page");
	  Assert.assertEquals(actualLoginPageMsg.contains(expectedLoginPageMsg),true); 
 }
  @BeforeTest
  @Parameters({"testName","browser"})
  public void beforeTest(String testName, String browser) throws MalformedURLException {
	  initLogger(testName);
	  log.info("0. Driver initialisation. Open browser");
	  //driver=firefoxWebDriver();
	  driver=createWebDriver(browser); 
	  extent=ExtentReportsManager.getInstance();
	  test = ExtentTestManager.createTest(testName, "negative check for Login page");
	  welcomePage=new WelcomePage(driver);
  }
  @AfterTest
  public void closeBrowser(){
	 log.info("7. Close Driver");
	cleanUp(driver);  
  }

}
