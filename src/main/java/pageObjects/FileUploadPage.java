package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends PageH3Title {
   private By fileUploadSelector=By.id("file-upload");
   private By uploadButton=By.id("file-submit");
	public FileUploadPage(WebDriver driver) {
		super(driver);
	}
    public void selectFile() {
    	String filePath="/Users/alexander/Desktop/touchVPN_proxy.png";
    	driver.findElement(fileUploadSelector).sendKeys(filePath);
    }
    public void pushUploadbutton(){
    	driver.findElement(uploadButton).click();
    }
}
