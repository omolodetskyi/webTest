package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RenderedElementPage extends BasePage {
	private By startButton=By.tagName("button");
    private By helloWorld=By.xpath("//h4[contains(text(),'Hello')]");
	public RenderedElementPage(WebDriver driver) {
		super(driver);
	}
	public void clickStartButton(){
    	driver.findElement(startButton).click();
    }
    public boolean helloWorldIsRendered(){
    	WebDriverWait wait=new WebDriverWait(driver,10);
   	    wait.until(ExpectedConditions.presenceOfElementLocated(helloWorld));
   	    if(driver.findElement(helloWorld).isDisplayed()){
   	    	return true;
   	    } else {
   	    	return false;
   	    }
    }
}
