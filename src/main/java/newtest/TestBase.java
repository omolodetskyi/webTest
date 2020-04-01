package newtest;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	protected static Logger log;
	public static WebDriver chromeWebDriver(){
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		ChromeOptions options=new ChromeOptions();
	   // options.setProxy(null);
		//options.setPageLoadStrategy(PageLoadStrategy.NONE);
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	public static WebDriver fireFoxWebDriver(){
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		//ChromeOptions options=new ChromeOptions();
	   // options.setProxy(null);
		//options.setPageLoadStrategy(PageLoadStrategy.NONE);
		//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	public void cleanUp(WebDriver driver){
		driver.close();
	}
   public void initLogger(String testName){
	   log=LogManager.getLogger(testName);
   }
   
}
