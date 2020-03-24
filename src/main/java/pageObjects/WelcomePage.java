package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends BasePage{
	
	private String baseURL="http://the-internet.herokuapp.com";
	private By formAuthenticationLink=By.xpath("//*[@href='/login']");
	private By checkboxesLink=By.xpath("//*[@href='/checkboxes']");
	private By dropDownLink=By.xpath("//*[@href='/dropdown']");
	private By fileUploadLink=By.xpath("//*[@href='/upload']");
	private By alertsLink=By.xpath("//*[@href='/javascript_alerts']");
	private By windowsLink=By.xpath("//*[@href='/windows']");
	private By dragAndDropLink=By.xpath("//*[@href='/drag_and_drop']");
	private By bottomLink=By.xpath("//*[@href='http://elementalselenium.com/']");
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
 public FileUploadPage clickFileUpload(){
	 driver.findElement(fileUploadLink).click();
	 return new FileUploadPage(driver);
 }
 public AlertsPage clickAlertsLink(){
	 driver.findElement(alertsLink).click();
	 return new AlertsPage(driver);
 }
 public WindowsPage clickWindowsLink(){
	 driver.findElement(windowsLink).click();
	 return new WindowsPage(driver);
 }
 public DragAndDropPage clickDragAndDropLink(){
	 driver.findElement(dragAndDropLink).click();
	 return new DragAndDropPage(driver);
 }
 public void scrollDown(){
	 WebDriverWait wait=new WebDriverWait(driver,5);
	 wait.until(ExpectedConditions.presenceOfElementLocated(bottomLink));
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
 }
}
