package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import newtest.TestBase;
import pageObjects.DropDownPage;
import pageObjects.WelcomePage;

public class DropDownTest extends TestBase {
	WebDriver driver;
	WelcomePage welcomePage;
	DropDownPage dropDownPage;
  @Test
  public void dropDownTest() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click DropDown link");
	  dropDownPage=welcomePage.clickDropDownLink();
	  String actualDropDownPageTitle=dropDownPage.getTitle();
	  String expectedDropDownPageTitle="Dropdown List";
	  log.info("4. Check DropDown page title");
	  Assert.assertEquals(actualDropDownPageTitle, expectedDropDownPageTitle);
	  log.info("5. Select Option1");
	  dropDownPage.selectDropDownItem(1);
	  String actualSelectedItem=dropDownPage.selectedDropDownItem();
	  String expectedSelectedItem="Option 1";
	  log.info("6. Check that Option 1 is selected");
	  Assert.assertEquals(actualSelectedItem, expectedSelectedItem);
  }
  @BeforeTest
  @Parameters({"testName","browser"})
  public void beforeTest(String testName, String browser) throws MalformedURLException {
	  initLogger(testName);
	  log.info("0. Driver initialisation. Open browser");
	  //driver=firefoxWebDriver();
	  driver=createWebDriver(browser);
  }
  @AfterTest
  public void closeBrowser(){
	 log.info("7. Close Driver");
	cleanUp(driver);  
  }

}
