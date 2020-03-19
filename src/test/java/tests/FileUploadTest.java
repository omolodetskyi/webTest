package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import newtest.TestBase;
import pageObjects.FileUploadPage;
import pageObjects.WelcomePage;

import org.openqa.selenium.WebDriver;

public class FileUploadTest extends TestBase{
 WebDriver driver;	
 WelcomePage welcomePage;
 FileUploadPage fileUploadPage;
 String filePath="/Users/alexander/Downloads/chesnok.jpg";
  @Test
  public void fileUploadTest() {
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click File Upload link");
	  fileUploadPage=welcomePage.clickFileUpload();
	  fileUploadPage.selectFile(filePath);
	  fileUploadPage.uploadFile();
	  String actualFileUploadTitle=fileUploadPage.getTitle();
	  String expectedFileUploadTitle="File Uploaded!";
	  Assert.assertEquals(actualFileUploadTitle, expectedFileUploadTitle);
	  String actualFileUploadedText=fileUploadPage.getUploadedFileText();
	  String expectedFileUploadedText="chesnok.jpg";
	  Assert.assertEquals(actualFileUploadedText, expectedFileUploadedText);
	  
  }
  //TODO move beforetest and aftertest to TestBase
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
	//cleanUp(driver);  
  }
}
