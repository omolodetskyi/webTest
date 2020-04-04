package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.WelcomePage;

public class ScrollTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
  @Test
  public void scrollTest() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  welcomePage.scrollDown();
  }
  @BeforeTest
  @Parameters({"testName"})
  public void beforeTest(String testName) {
	  initLogger(testName);
	  log.info("0. Initiate Driver");
	  driver=createWebDriver("chrome");
	 }
  @AfterTest
  public void closeBrowser(){
	 log.info("7. Close Driver");
	 //cleanUp(driver);  
  }
}
