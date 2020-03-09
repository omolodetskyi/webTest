package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class BasePage {
	protected WebDriver driver;
	private By pageTitle=By.tagName("h2");
	private By message=By.id("flash");
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	public String getTitle(){
		return driver.findElement(pageTitle).getText(); 
	 }
	 public String getMessage(){
			return driver.findElement(message).getText(); 
		 }
}
