package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.AlertsPage;
import pageObjects.WelcomePage;

public class AlertTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	AlertsPage alertsPage;
  @Test
  public void alertsTest() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click JavaScript Alerts link");
	  alertsPage=welcomePage.clickAlertsLink();
	  String actualAlertsPageTitle=alertsPage.getTitle();
	  String expectedAlertsPageTitle="JavaScript Alerts";
	  log.info("4. Check JavaScript Alerts page title");
	  Assert.assertEquals(actualAlertsPageTitle, expectedAlertsPageTitle);
	  alertsPage.clickJSalertButton();
	  String actualAlertMessage=alertsPage.getAlertMessage();
	  String expectedAlertMessage="I am a JS Alert";
	  Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	  alertsPage.clickAlertOKButton();
	  String actualResultText=alertsPage.getResultText();
	  String expecteResultText="You successfuly clicked an alert";
	  Assert.assertEquals(actualResultText, expecteResultText);
	  alertsPage.clickJSconfirmButton();
	  actualAlertMessage=alertsPage.getAlertMessage();
	  expectedAlertMessage="I am a JS Confirm";
	  Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	  alertsPage.clickAlertCancelButton();
	  actualResultText=alertsPage.getResultText();
	  expecteResultText="You clicked: Cancel";
	  Assert.assertEquals(actualResultText, expecteResultText);
	  alertsPage.clickJSpromptButton();
	  actualAlertMessage=alertsPage.getAlertMessage();
	  expectedAlertMessage="I am a JS Prompt";
	  String text="Hello, World!";
	  alertsPage.typeAlertText(text);
	  alertsPage.clickAlertOKButton();
	  actualResultText=alertsPage.getResultText();
	  expecteResultText="You entered: "+text;
	  Assert.assertEquals(actualResultText, expecteResultText);
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
