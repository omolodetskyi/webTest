package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.LoginPage;
import pageObjects.SecureAreaPage;
import pageObjects.WelcomePage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LoginTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	LoginPage loginPage;
	SecureAreaPage secureAreaPage;
  @Test
  public void loginTest() {
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
	  log.info("5. Enter valid username/password");
	  secureAreaPage=loginPage.formAuthenticationLinkClick("tomsmith", "SuperSecretPassword!");
	  String actualSecureAreaPageTitle=secureAreaPage.getTitle();
	  String expectedSecureAreaPageTitle="Secure Area";
	  log.info("6. Check Secure Area title");
	  Assert.assertEquals(actualSecureAreaPageTitle, expectedSecureAreaPageTitle);
	  String actualSecureAreaPageMsg=secureAreaPage.getMessage();
	  String expectedSecureAreaPageMsg="You logged into a secure area!";
	  log.info("7. Check message '"+expectedSecureAreaPageMsg+"' on Secure Area page");
	  Assert.assertEquals(actualSecureAreaPageMsg.contains(expectedSecureAreaPageMsg),true);
  }
  @BeforeTest
  public void beforeTest() {
	  driver=chromeWebDriver();
	  initLogger("Login with valid username/password");
	  log.info("0. Initiate Driver");
  }
  @AfterTest
  public void closeBrowser(){
	cleanUp(driver);  
	 log.info("8. Close Driver");
  }

}
