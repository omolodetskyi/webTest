package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

	private By message=By.id("flash");
	private By userNameField=By.id("username");
	private By passwordField=By.id("password");
	private By loginButton=By.xpath("//*[@type='submit']");
	 public LoginPage(WebDriver driver){
		 super(driver);
	 }
	 
	 public SecureAreaPage enterUserNamePassword(String username,String password){
	   driver.findElement(userNameField).sendKeys(username);
	   driver.findElement(passwordField).sendKeys(password);
	   driver.findElement(loginButton).click();
	   return new SecureAreaPage(driver);
	 }
}
