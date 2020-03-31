package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends H3TitlePage {
  private By placeHolder=By.xpath("//*[@id='tinymce']/p");
  private By frame=By.id("mce_0_ifr");
	public FramePage(WebDriver driver) {
		super(driver);
	}
    public String getPlaceHolder(){
    	return driver.findElement(placeHolder).getText();
    }
    public void switchToFrame(){
    	 //driver.switchTo().frame(driver.findElement(frame));
    	//driver.switchTo().frame(0);
    	driver.switchTo().frame("mce_0_ifr");
    }
}
