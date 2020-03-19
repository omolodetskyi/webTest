package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends H3TitlePage {
private By JSalertButton=By.xpath("//*[@onclick='jsAlert()']");
private By JSconfirmButton=By.xpath("//*[@onclick='jsConfirm()']");
private By JSpromptButton=By.xpath("//*[@onclick='jsPrompt()']");
private By resultText=By.id("result");
protected Alert switchToAlert(){
	WebDriverWait wait=new WebDriverWait(driver,5);
	wait.until(ExpectedConditions.alertIsPresent());
	return driver.switchTo().alert();
	
}
public AlertsPage(WebDriver driver) {
		super(driver);
	}
  public void clickJSalertButton(){
	  driver.findElement(JSalertButton).click();
  }
  public void clickJSconfirmButton(){
	  driver.findElement(JSconfirmButton).click();
  }
  public void clickJSpromptButton(){
	  driver.findElement(JSpromptButton).click();
  }
  public String getAlertMessage(){
	 Alert alert=switchToAlert();
	 return alert.getText(); 
  }
  public void clickAlertOKButton(){
	Alert alert=switchToAlert();
	alert.accept();  
  }
  public void clickAlertCancelButton(){
		Alert alert=switchToAlert();
		alert.dismiss();
  }
  public String getResultText(){
	  return driver.findElement(resultText).getText();
  }
  public void typeAlertText(String text){
	  Alert alert=switchToAlert();
	  alert.sendKeys(text);
  }
}
