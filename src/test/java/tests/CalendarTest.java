package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;

public class CalendarTest extends TestBase{
	WebDriver driver;
	String url="https://phptravels.net/home";
	
  @Test
  public void calendarTest() {
	  driver.get(url);
	  driver.manage().window().maximize();
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollTo(0,100)");
	  List <WebElement> titles=driver.findElements(By.className("datepicker--nav-title"));
	  driver.findElement(By.id("checkin")).click();
	  for(WebElement title:titles){
		  if(title.isDisplayed()){
			  title.click();
		  }
	  }
	  driver.findElement(By.xpath("//*[@data-month='7']")).click();
	  driver.findElement(By.xpath("//*[@data-date='24']")).click();
	  driver.findElement(By.id("checkout")).click();
	  System.out.println("I've clicked checkout");
	  titles=driver.findElements(By.className("datepicker--nav-title"));
	  for(WebElement title:titles){
		  if(title.isDisplayed()){
			  title.click();
		  }
	  }
	  List <WebElement> monthes=driver.findElements(By.xpath("//*[@data-month='8']"));
	  for(WebElement month:monthes){
		  if(month.isDisplayed()){
			  month.click();
		  }
	  }
	  List <WebElement> days=driver.findElements(By.xpath("//*[@data-date='1']"));
	  for(WebElement day:days){
		  if(day.isDisplayed()){
			  day.click();
		  }
	  }	
	  /* simple set of date
	  driver.findElement(By.id("checkin")).clear();
	  driver.findElement(By.id("checkin")).sendKeys("24/08/2020");
	  driver.findElement(By.id("checkout")).clear();
	  driver.findElement(By.id("checkout")).sendKeys("01/09/2020");
	  driver.findElement(By.id("checkout")).sendKeys(Keys.ENTER);
	  */
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
	// cleanUp(driver);  
  }
}
