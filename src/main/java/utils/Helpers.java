package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class Helpers {
	public static void takeScreenshot(String fileName, WebDriver driver) throws IOException{
		  TakesScreenshot ts=(TakesScreenshot) driver;
		  String filePath="./screenshots/"+fileName+".png";
		  File screenShot=ts.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(screenShot, new File(filePath));
	}
	public static List<LogEntry> getBrowserLog(WebDriver driver){
		LogEntries log=driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logList=log.getAll();
		return logList;
	}
}
