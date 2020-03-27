package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends H3TitlePage {
   private By result=By.id("result");
   private By pageBody=By.tagName("body");
	public KeyPressesPage(WebDriver driver) {
		super(driver);
	}
    public String getResult(){
    	return driver.findElement(result).getText();
    }
    public void pressKey(Keys keys){
    	driver.findElement(pageBody).sendKeys(keys);
    }
}
