package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {
	protected By hiddenElementLink=By.xpath("//*[@href='/dynamic_loading/1']");
	protected By renderedElementLink=By.xpath("//*[@href='/dynamic_loading/2']");
	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
	}
	public HiddenElementPage clickHiddenElementLink(){
		 driver.findElement(hiddenElementLink).click();
		 return new HiddenElementPage(driver);
	 }
	public RenderedElementPage clickRenderedElementLink(){
		 driver.findElement(renderedElementLink).click();
		 return new RenderedElementPage(driver);
	 }
}
