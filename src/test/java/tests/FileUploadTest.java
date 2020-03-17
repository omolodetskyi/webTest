package tests;

import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.FileUploadPage;
import pageObjects.WelcomePage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase{
	WebDriver driver;
	WelcomePage welcomePage;
	FileUploadPage fileUploadPage;
  @Test
  public void fileUploadTest() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  fileUploadPage=welcomePage.clickFileUploadLink();
	  fileUploadPage.selectFile();
	  fileUploadPage.pushUploadbutton();
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
	//cleanUp(driver);  
  }
}
