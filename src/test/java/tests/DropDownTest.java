package tests;

import pageObjects.DropDownPage;
import pageObjects.WelcomePage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import newtest.TestBase;
public class DropDownTest extends TestBase {
	private WelcomePage welcomePage;
	private DropDownPage dropDownPage;
	WebDriver driver;
	@Test
	public void selectDropdownTest(){
		  welcomePage=new WelcomePage(driver);
		  welcomePage.openPage();
		  log.info("1. Open welcome Page");
		  String actualWelcomeTitle=welcomePage.getTitle();
		  String expectedWelcomeTitle="Available Examples";
		  log.info("2. Welcome page has Available Examples title");
		  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
		  log.info("3. Click on DropDown link");
		  dropDownPage=welcomePage.clickDropDownLink();
		  String actualDropDownTitle=dropDownPage.getTitle();
		  String expectedDropDownTitle="Dropdown List";
		  log.info("4. Check Dropdown page title");
		  Assert.assertEquals(actualDropDownTitle, expectedDropDownTitle);
		  log.info("5. Select Option1");
		  dropDownPage.selectDropDown(1);
		  log.info("6. Check that Option1 is selected");
		  String actualSelectedValue=dropDownPage.getSelectedValue();
		  String expectedSelectedValue="Option 1";
		  Assert.assertEquals(actualSelectedValue,expectedSelectedValue);
	}
	 @BeforeTest
	  @Parameters({"testName"})
	  public void beforeTest(String testName) {
		  initLogger(testName);
		  log.info("0. Driver initialisation. Open browser");
		  driver=chromeWebDriver();
		  
		  
	  }
	  @AfterTest
	  public void closeBrowser(){
		log.info("8. Close browser");  
		cleanUp(driver);  
	  }
}
