package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helpers {
	public static void takeScreenshot(String fileName, WebDriver driver) throws IOException{
		  TakesScreenshot ts=(TakesScreenshot) driver;
		  String filePath="./screenshots/"+fileName+".png";
		  File screenShot=ts.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(screenShot, new File(filePath));
	}
}
