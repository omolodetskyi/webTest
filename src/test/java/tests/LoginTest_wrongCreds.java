package tests;

import org.testng.annotations.Test;


import org.testng.AssertJUnit;
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
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  loginPage=welcomePage.clickFormAuthenticationLink();
	  String actualLoginTitle=loginPage.getTitle();
	  String expectedLoginTitle="Login Page";
	  Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
	  secureAreaPage=loginPage.formAuthenticationLinkClick(userName, password);
	  String actualLoginPageMsg=loginPage.getMessage();
	  String expectedLoginPageMsg=errorMessage;
	  Assert.assertEquals(actualLoginPageMsg.contains(expectedLoginPageMsg),true);
  }
  @BeforeTest
  public void beforeTest() {
	  driver=chromeWebDriver();
  }
  @AfterTest
  public void closeBrowser(){
	cleanUp(driver);  
  }

}
