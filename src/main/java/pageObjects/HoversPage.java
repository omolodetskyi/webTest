package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoversPage extends H3TitlePage {
    private By avatar=By.className("figure");
    private By viewProfileLink=By.xpath(".//*[@class='figcaption']/a");
	public HoversPage(WebDriver driver) {
		super(driver);
	}
    public void hoverAvatar(int i){
    	Actions action=new Actions(driver);
    	action.moveToElement(driver.findElements(avatar).get(i)).build().perform();
    }
    public void clickViewProfileLink(int i){
    	 WebElement viewProfileLinkeElement =driver.findElements(viewProfileLink).get(i);
    	 WebDriverWait wait=new WebDriverWait(driver,10);
    	 wait.until(ExpectedConditions.elementToBeClickable(viewProfileLinkeElement));
    	 viewProfileLinkeElement.click();
    }
}
