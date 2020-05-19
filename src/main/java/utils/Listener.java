package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

import utils.extentReports.ExtentReportsManager;
import utils.extentReports.ExtentTestManager;

public class Listener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().pass("Test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver=(WebDriver)result.getTestContext().getAttribute("driver");
		
		try {
			String imgPath=Helpers.takeScreenshot(driver, result.getName());
			Reporter.log("<b>Test Failed!</b> See screenshot<p/><img src='."+imgPath+"'>");
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed",MediaEntityBuilder.createScreenCaptureFromPath("."+imgPath).build());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().skip("Step skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportsManager.getInstance().flush();
	}

}
