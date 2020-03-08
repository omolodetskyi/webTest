package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	private By pageTitle=By.tagName("h2");
	private By message=By.id("flash");
	private By userNameField=By.id("username");
	private By passwordField=By.id("password");
	private By loginButton=By.xpath("//*[@type='submit']");
	 public LoginPage(WebDriver driver){
		 this.driver=driver;
	 }
	 public String getTitle(){
			return driver.findElement(pageTitle).getText(); 
		 }
	 public SecureAreaPage formAuthenticationLinkClick(String username,String password){
	   driver.findElement(userNameField).sendKeys(username);
	   driver.findElement(passwordField).sendKeys(password);
	   driver.findElement(loginButton).click();
	   return new SecureAreaPage(driver);
	 }
	 public String getMessage(){
			return driver.findElement(message).getText(); 
		 }
}
