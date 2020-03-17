package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends PageH3Title{
	private By dropDown=By.tagName("select");
	private WebElement dropDownUI=driver.findElement(dropDown);
	Select dropDownList=new Select(dropDownUI);
	public DropDownPage(WebDriver driver){
		 super(driver);
	 }
	public void selectDropDown(int index){
	
	dropDownList.selectByIndex(index);
	}
	public String getSelectedValue(){
		return dropDownList.getFirstSelectedOption().getText();	
	}
}
