package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage{
	
	private String baseURL="http://the-internet.herokuapp.com";
	private By formAuthenticationLink=By.xpath("//*[@href='/login']");
	private By checkboxesLink=By.xpath("//*[@href='/checkboxes']");
	private By dropDownLink=By.xpath("//*[@href='/dropdown']");
 public WelcomePage(WebDriver driver){
	 super(driver);
 }
 
 public void openPage(){
	 driver.get(baseURL);
 }
 public LoginPage clickFormAuthenticationLink(){
	 driver.findElement(formAuthenticationLink).click();
	 return new LoginPage(driver);
 }
 public CheckboxesPage clickCheckboxesLink(){
	 driver.findElement(checkboxesLink).click();
	 return new CheckboxesPage(driver);
 }
 public DropDownPage clickDropDownLink(){
	 driver.findElement(dropDownLink).click();
	 return new DropDownPage(driver);
 }
}
