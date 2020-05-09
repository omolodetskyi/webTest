package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage{
	private String baseURL="https://rahulshettyacademy.com/seleniumPractise/#/";
	@FindBy(css="div:nth-child(3) > div.stepper-input > a.increment")
	public WebElement increaseNumber;
	@FindBy(css="div:nth-child(3) > div.product-action > button")
	public WebElement addToCartButton;
	@FindBy(css="div.cart-info > table > tbody > tr:nth-child(1) > td:nth-child(3) > strong")
	public WebElement cartItems;
	@FindBy(css="div.cart-info > table > tbody > tr:nth-child(2) > td:nth-child(3) > strong")
	public WebElement cartPrice;
	protected WebDriver driver;
	public ShopPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	 }
	public void openPage(){
		 driver.get(baseURL);
	 } 
}
