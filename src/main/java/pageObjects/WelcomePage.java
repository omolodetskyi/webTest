package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage{
	
	private String baseURL="http://the-internet.herokuapp.com";
	private By formAuthenticationLink=By.xpath("//*[@href='/login']");
	private By checkBoxesLink=By.xpath("//*[@href='/checkboxes']");
	private By dropDown=By.xpath("//*[@href='/dropdown']");
	private By fileUpload=By.xpath("//*[@href='/upload']");
	
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
 public CheckBoxesPage clickCheckboxesLink(){
	 driver.findElement(checkBoxesLink).click();
	 return new CheckBoxesPage(driver);
 }
 public DropDownPage clickDropDownLink(){
	 driver.findElement(dropDown).click();
	 return new DropDownPage(driver);
 }
 public FileUploadPage clickFileUploadLink(){
	 driver.findElement(fileUpload).click();
	 return new FileUploadPage(driver);
 }
}
