package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends H3TitlePage {
    By selectFileButton=By.id("file-upload");
    By uploadFileButton=By.id("file-submit");
    By uploadFileText=By.id("uploaded-files");
	public FileUploadPage(WebDriver driver) {
		super(driver);
	}
    public void selectFile(String filePath){
    	driver.findElement(selectFileButton).sendKeys(filePath);
    }
    public String getSelectFileButtonText(){
    	return driver.findElement(selectFileButton).getText();
    }
    public void uploadFile(){
    	driver.findElement(uploadFileButton).click();
    }
    public String getUploadedFileText(){
    	//System.out.println(driver.findElement(uploadFileText).getText());
    	return driver.findElement(uploadFileText).getText();
    	
    }
}
