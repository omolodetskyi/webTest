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

public class AlertsTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	AlertsPage alertsPage;
	String text="Hello World!";
  @Test
  public void alertsTest() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click Checkboxes link");
	  alertsPage=welcomePage.clickAlertsLink();
	  alertsPage.alertButtonClick();
	  String actualAlertMessage=alertsPage.getAlertMessage();
	  String expectedAlertMessage="I am a JS Alert";
	  Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	  alertsPage.alertClickOK();
	  String expectedResultText="You successfuly clicked an alert";
	  String actualResultText=alertsPage.getResultText();
	  Assert.assertEquals(actualResultText, expectedResultText);
	  alertsPage.confirmButtonClick();
	  actualAlertMessage=alertsPage.getAlertMessage();
	  expectedAlertMessage="I am a JS Confirm";
	  Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	  alertsPage.alertClickCancel();
	  expectedResultText="You clicked: Cancel";
	  actualResultText=alertsPage.getResultText();
	  Assert.assertEquals(actualResultText, expectedResultText);
	  alertsPage.promptButtonClick();
	  actualAlertMessage=alertsPage.getAlertMessage();
	  expectedAlertMessage="I am a JS prompt";
	  Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	  alertsPage.alertTypeText(text);
	  alertsPage.alertClickOK();
	  expectedResultText="You entered: "+text;
	  actualResultText=alertsPage.getResultText();
	  Assert.assertEquals(actualResultText, expectedResultText);
	  
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
