package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.SliderPage;
import pageObjects.WelcomePage;

public class SliderTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	SliderPage sliderPage;
  @Test
  public void sliderTest() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click Checkboxes link");
	  sliderPage=welcomePage.clickSliderLink();
	  //sliderPage.moveSlider(2);
	  sliderPage.moveSliderWithKeyboard(5);
	  String actualRange=sliderPage.getRange();
	  String expectedRange="2";
	  Assert.assertEquals(actualRange, expectedRange);
	  
  }
  @BeforeTest
  @Parameters({"testName"})
  public void beforeTest(String testName) {
	  initLogger(testName);
	  log.info("0. Initiate Driver");
	  driver=createWebDriver();
	 }
  @AfterTest
  public void closeBrowser(){
	 log.info("7. Close Driver");
	//cleanUp(driver);  
  }
}
