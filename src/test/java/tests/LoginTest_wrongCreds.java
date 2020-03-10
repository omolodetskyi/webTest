package tests;

import org.testng.annotations.Test;



import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.LoginPage;
import pageObjects.SecureAreaPage;
import pageObjects.WelcomePage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTest_wrongCreds extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
  @Test
  @Parameters({"userName","password","errorMessage"})
  public void loginWithWrongCreds(String userName,String password, String errorMessage) {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click Form Authentication link");
	  loginPage=welcomePage.clickFormAuthenticationLink();
	  String actualLoginTitle=loginPage.getTitle();
	  String expectedLoginTitle="Login Page";
	  log.info("4. Check Login title");
	  Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
	  log.info("5. Enter invalid username/password");
	  secureAreaPage=loginPage.enterUserNamePassword(userName, password);
	  String actualLoginPageMsg=loginPage.getMessage();
	  String expectedLoginPageMsg=errorMessage;
	  log.info("6. Check '"+expectedLoginPageMsg+"' error message on Login Page");
	  Assert.assertEquals(actualLoginPageMsg.contains(expectedLoginPageMsg),true);
  }
  @BeforeTest
  @Parameters({"testName"})
  public void beforeTest(String testName) {
	  initLogger(testName);
	  log.info("0. Initiate Driver");
	  driver=chromeWebDriver();
	 }
  @AfterTest
  public void closeBrowser(){
	 log.info("7. Close Driver");
	cleanUp(driver);  
  }

}
