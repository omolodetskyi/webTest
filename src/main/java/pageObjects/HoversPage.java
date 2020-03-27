package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HoversPage extends H3TitlePage {
	private By avatar=By.xpath("//*[@class='figure']");
	private By viewProfileLink=By.xpath(".//*[@href='/users/1']");
	public HoversPage(WebDriver driver) {
		super(driver);
	}
	public void hoverAvatar(int i){
    	Actions action =new Actions(driver);
    	action.moveToElement(driver.findElements(avatar).get(i)).build().perform();
    }
    public void clickViewProfile(){
    	driver.findElement(viewProfileLink).click();
    }
}
