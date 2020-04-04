package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiddenElementPage extends BasePage {
    private By startButton=By.tagName("button");
    private By helloWorld=By.xpath("//h4[contains(text(),'Hello')]");
	public HiddenElementPage(WebDriver driver) {
		super(driver);
	}
    public void clickStartButton(){
    	driver.findElement(startButton).click();
    }
    public boolean helloWorldIsVisible(){
    	WebDriverWait wait=new WebDriverWait(driver,10);
   	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(helloWorld)));
   	    if(driver.findElement(helloWorld).isDisplayed()){
   	    	return true;
   	    } else {
   	    	return false;
   	    }
    }
}
