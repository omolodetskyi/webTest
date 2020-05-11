package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import newtest.TestBase;
import pageObjects.ShopPage;

public class ShopTest extends TestBase{
	private WebDriver driver;
	ShopPage shopPage;
  @Test
  public void shopTest() {
	shopPage.openPage();
	shopPage.incrementButton.click();
	shopPage.addToCartButton.click();
	String actualItems=shopPage.itemsCart.getText();
	Assert.assertEquals(actualItems, "1");
	String actualPrice=shopPage.priceCart.getText();
	Assert.assertEquals(actualPrice, "96");

	
  }
  @BeforeTest
  @Parameters({"testName","browser"})
  public void beforeTest(String testName, String browser) {
	  initLogger(testName);
	  driver=createWebDriver(browser);
	  shopPage=new ShopPage(driver);
  }
}
