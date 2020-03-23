package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage extends H3TitlePage {
	private By newWindowLink=By.xpath("//*[@href='/windows/new']");
	public WindowPage(WebDriver driver) {
		super(driver);
	}
    public NewWindow clickNewWindowLink(){
    	driver.findElement(newWindowLink).click();
    	this.switchToWindowByTitle("New Window");
    	return new NewWindow(driver);
    }
}
