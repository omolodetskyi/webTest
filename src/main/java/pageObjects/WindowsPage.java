package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsPage extends H3TitlePage {
	private By newWindowLink = By.xpath("//*[@href='/windows/new']");

	public WindowsPage(WebDriver driver) {
		super(driver);
	}
   public NewWindowPage newWindowLinkClick(){
	   driver.findElement(newWindowLink).click();
	   return new NewWindowPage(driver);
   }
}
