package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
	private WebDriver driver;
	private By pageTitle=By.tagName("h2");
	private String baseURL="http://the-internet.herokuapp.com";
	private By formAuthenticationLink=By.xpath("//*[@href='/login']");
	
 public WelcomePage(WebDriver driver){
	 this.driver=driver;
 }
 public String getTitle(){
	return driver.findElement(pageTitle).getText(); 
 }
 public void openPage(){
	 driver.get(baseURL);
 }
 public LoginPage clickFormAuthenticationLink(){
	 driver.findElement(formAuthenticationLink).click();
	 return new LoginPage(driver);
 }
}
