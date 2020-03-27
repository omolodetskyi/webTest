package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends H3TitlePage {
  private By placeHolder=By.xpath("//*[@id='tinymce']/p");
	public FramePage(WebDriver driver) {
		super(driver);
	}
    public String getPlaceHolder(){
    	return driver.findElement(placeHolder).getText();
    }
}
