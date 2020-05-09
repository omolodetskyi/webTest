package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.ShopPage;

public class CssTest extends TestBase{
	WebDriver driver;
	ShopPage shopPage;
  @Test
  public void cssTest() {
	  String expectedCartItems="1";
	  String expectedCartPrice="96";
	  shopPage=new ShopPage(driver);
	  shopPage.openPage();
	  /*
	  driver.findElement(By.cssSelector("div:nth-child(3) > div.stepper-input > a.increment")).click();
	  driver.findElement(By.cssSelector("div:nth-child(3) > div.product-action > button")).click();
	  String actualCartItems=driver.findElement(By.cssSelector("div.cart-info > table > tbody > tr:nth-child(1) > td:nth-child(3) > strong")).getText();
	  Assert.assertEquals(actualCartItems,expectedCartItems);
	  String actualCartPrice=driver.findElement(By.cssSelector("div.cart-info > table > tbody > tr:nth-child(2) > td:nth-child(3) > strong")).getText();
	  Assert.assertEquals(actualCartPrice, expectedCartPrice);
	  */
	  shopPage.increaseNumber.click();
	  shopPage.addToCartButton.click();
	  String actualCartItems=shopPage.cartItems.getText();
	  Assert.assertEquals(actualCartItems,expectedCartItems);
	  String actualCartPrice=shopPage.cartPrice.getText();
	  Assert.assertEquals(actualCartPrice, expectedCartPrice);
	  
  }
  @BeforeTest
  @Parameters({"testName","browser"})
  public void beforeTest(String testName, String browser) {
	  initLogger(testName);
	  driver=createWebDriver(browser);
	  
  }
}
