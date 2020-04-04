package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;

public class Calendar  extends TestBase{
	WebDriver driver;
	String url="https://www.phptravels.net/home";
  @Test
  public void calendarTest() {
	  By checkinField=By.id("checkin");
	  By checkoutField=By.id("checkout");
	  driver.get(url);
	  driver.manage().window().maximize();
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollTo(0,100)");
	  driver.findElement(checkinField).click();
	/*
	 * for hidden
	 * WebDriverWait wait=new WebDriverWait(driver,10);
	 * WebElement element=driver.findElement(.....);
	 * wait.until(ExpectedConditions.visibilityOf(element));
	 * for rendered after click
	 * WebDriverWait wait=new WebDriverWait(driver,10);
	 * By locator=By.xpath(...);
	 * wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	 * 
	 * 
	  driver.findElement(checkinField).clear();
	  driver.findElement(checkinField).sendKeys("24/08/2020");
	  driver.findElement(checkoutField).click();
	  driver.findElement(checkoutField).clear();
	  driver.findElement(checkoutField).sendKeys("01/09/2020");
	  */
	  List <WebElement> titles=driver.findElements(By.className("datepicker--nav-title"));
	  for(WebElement title:titles){
		  if(title.isDisplayed()){
			  title.click();
			  break;
		  }
	  }
	  List <WebElement> monthes=driver.findElements(By.xpath("//*[@data-month='7']"));
	  for(WebElement month:monthes){
		  if(month.isDisplayed()){
			  month.click();
			  break;
		  }  
	  }
	  List <WebElement> days=driver.findElements(By.xpath("//*[@data-date='24']"));
	  for(WebElement day:days){
		  if(day.isDisplayed()){
			  day.click();
			  break;
		  }  
	  }
	  
	  titles=driver.findElements(By.className("datepicker--nav-title"));
	  for(WebElement title:titles){
		  if(title.isDisplayed()){
			  title.click();
			  break;
		  }
	  }
	  monthes=driver.findElements(By.xpath("//*[@data-month='8']"));
	  for(WebElement month:monthes){
		  if(month.isDisplayed()){
			  month.click();
			  break;
		  }  
	  }
	  days=driver.findElements(By.xpath("//*[@data-date='1']"));
	  for(WebElement day:days){
		  if(day.isDisplayed()){
			  day.click();
			  break;
		  }  
	  }
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
	 //cleanUp(driver);  
  }
  
}
