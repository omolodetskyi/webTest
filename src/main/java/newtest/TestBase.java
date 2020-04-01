package newtest;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	protected static Logger log;
	WebDriver driver;
	public WebDriver createWebDriver(String browser){
			switch(browser){
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
				ChromeOptions options=new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				driver=new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
				driver=new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    break;
	        }
			log.info("Started driver on "+browser);
			return driver;
		}
		
	public void cleanUp(WebDriver driver){
		driver.close();
	}
   public void initLogger(String testName){
	   log=LogManager.getLogger(testName);
   }
   
}
