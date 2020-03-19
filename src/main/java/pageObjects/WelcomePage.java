package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage{
	
	private String baseURL="http://the-internet.herokuapp.com";
	private By formAuthenticationLink=By.xpath("//*[@href='/login']");
	private By checkboxesLink=By.xpath("//*[@href='/checkboxes']");
	private By dropDownLink=By.xpath("//*[@href='/dropdown']");
	private By fileUploadLink=By.xpath("//*[@href='/upload']");
	private By alertsLink=By.xpath("//*[@href='/javascript_alerts']");
	private By windowLink=By.xpath("//*[@href='/windows']");
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
 public WindowPage clickWindowLink(){
	 driver.findElement(windowLink).click();
	 return new WindowPage(driver);
 }
 public CheckboxesPage clickCheckboxesLink(){
	 driver.findElement(checkboxesLink).click();
	 return new CheckboxesPage(driver);
 }
 public DropDownPage clickDropDownLink(){
	 driver.findElement(dropDownLink).click();
	 return new DropDownPage(driver);
 }
 public FileUpload clickFileUploadLink(){
	 driver.findElement(fileUploadLink).click();
	 return new FileUpload(driver);
 }
 public AlertsPage clickAlertsLink(){
	 driver.findElement(alertsLink).click();
	 return new AlertsPage(driver);
 }
}
