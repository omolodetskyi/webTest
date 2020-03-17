package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends H3TitlePage {
	protected By checkbox=By.xpath("//*[@type='checkbox']");
	List<WebElement> checkboxes=driver.findElements(checkbox);
	
	public CheckboxesPage(WebDriver driver) {
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
