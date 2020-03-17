package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class H3TitlePage extends BasePage {
	By pageTitle=By.tagName("h3");
	public H3TitlePage(WebDriver driver){
		 super(driver);
	 }
	@Override
	public String getTitle(){
		return driver.findElement(pageTitle).getText(); 
	 }
}
