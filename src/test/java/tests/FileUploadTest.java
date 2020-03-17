package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.FileUpload;
import pageObjects.WelcomePage;

public class FileUploadTest extends TestBase {
 WebDriver driver;
 WelcomePage welcomePage;
 FileUpload fileUploadPage;
  @Test
  public void fileUploadTest() {
	  String file="/Users/alexander/Downloads/chesnok.jpg";
	  welcomePage=new WelcomePage(driver);
	  welcomePage.openPage();
	  log.info("1. Open welcome Page");
	  String actualWelcomeTitle=welcomePage.getTitle();
	  String expectedWelcomeTitle="Available Examples";
	  log.info("2. Welcome page has Available Examples title");
	  Assert.assertEquals(actualWelcomeTitle, expectedWelcomeTitle);
	  log.info("3. Click FileUpload link");
	  fileUploadPage=welcomePage.clickFileUploadLink();
	  String actualFileUploadTitle=fileUploadPage.getTitle();
	  String expectedFileUploadTitle="File Uploader";
	  log.info("4. Check File Upload Page title");
	  Assert.assertEquals(actualFileUploadTitle, expectedFileUploadTitle);
	  log.info("5.Select file");
	  fileUploadPage.selectFile(file);
	  log.info("6. Upload file");
	  fileUploadPage.uploadFile();
	  actualFileUploadTitle=fileUploadPage.getTitle();
	  expectedFileUploadTitle="File Uploaded!";
	  log.info("7.Check title of File Upload after file is uploaded");
	  Assert.assertEquals(actualFileUploadTitle, expectedFileUploadTitle);
	  String actualFileName=fileUploadPage.getFileUploaded();
	  String expectedFileName="chesnok.jpg";
	  log.info("8. Check file name which was uploaded");
	  Assert.assertEquals(actualFileName, expectedFileName);
	  
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
	 log.info("9. Close Driver");
	//cleanUp(driver);  
  }
}
