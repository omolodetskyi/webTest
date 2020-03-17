package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUpload extends H3TitlePage {
	private By fileSelectButton = By.id("file-upload");
	private By fileSubmitButton=By.id("file-submit");
	private By fileUploadedPanel=By.id("file-uploaded");
	public FileUpload(WebDriver driver) {
		super(driver);
	}
    public void selectFile(String filePath){
    	driver.findElement(fileSelectButton).sendKeys(filePath);
    }
    public String getFileUploaded(){
    	String fileUploadedName=driver.findElement(fileUploadedPanel).getText();
    	return fileUploadedName;
    }
}
