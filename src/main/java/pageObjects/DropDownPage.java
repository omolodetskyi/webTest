package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends H3TitlePage {
	protected By dropDown=By.tagName("select");
	protected WebElement dropDownList=driver.findElement(dropDown);
	Select dropDownUI=new Select(dropDownList);
	public DropDownPage(WebDriver driver) {
		super(driver);
	}
    public void selectDropDownItem(int index){
    	dropDownUI.selectByIndex(index);
    }
    public String selectedDropDownItem(){
    	return dropDownUI.getFirstSelectedOption().getText();
    }
}
