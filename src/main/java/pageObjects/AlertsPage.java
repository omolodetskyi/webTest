package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends H3TitlePage {
    private By alertButton=By.xpath("//button[@onclick='jsAlert()']");
    private By confirmButton=By.xpath("//button[@onclick='jsConfirm()']");
    private By promptButton=By.xpath("//button[@onclick='jsPrompt()']");
    private By resultText=By.id("result");
	public AlertsPage(WebDriver driver) {
		super(driver);
	}
    public void alertButtonClick(){
    	driver.findElement(alertButton).click();
    }
    public void confirmButtonClick(){
    	driver.findElement(confirmButton).click();
    }
    public void promptButtonClick(){
    	driver.findElement(promptButton).click();
    }
    public String getAlertMessage(){
    	Alert alert=driver.switchTo().alert();
    	return alert.getText();
    }
    public void alertClickOK(){
    	Alert alert=driver.switchTo().alert();
    	alert.accept();
    }
    public void alertClickCancel(){
    	Alert alert=driver.switchTo().alert();
    	alert.dismiss();
    }
    public void alertTypeText(String text){
    	Alert alert=driver.switchTo().alert();
    	alert.sendKeys(text);
    }
    public String getResultText(){
    	return driver.findElement(resultText).getText(); 	
    }
}
