package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageH3Title extends BasePage {
	protected By pageTitle=By.tagName("h3");
	@Override
	public String getTitle(){
		return driver.findElement(pageTitle).getText(); 
	 }
	public PageH3Title(WebDriver driver) {
		super(driver);
	}

}
