package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxesPage extends PageH3Title {
	
	private By checkbox=By.xpath("//*[@type='checkbox']");
	private List<WebElement> checkboxes=driver.findElements(checkbox);
	
	public CheckBoxesPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkCheckbox(int index){
		checkboxes.get(index).click();
	}
	public Boolean allCheckboxesChecked(){
		Boolean checked=true;
		for(WebElement checkbox:checkboxes){
			if(!checkbox.isSelected()){
				checked=false;
			}
		}
		return checked;	
	}
}
