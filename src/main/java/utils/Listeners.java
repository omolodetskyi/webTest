package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		/*
		WebDriver driver= (WebDriver)result.getTestContext().getAttribute("driver");
		ExtentTest test=(ExtentTest)result.getTestContext().getAttribute("test");
				try {
					String imgPath = "."+Helpers.takeScreenshot(driver, result.getName());
					
				    test.addScreenCaptureFromPath(imgPath);
				    test.log(Status.FAIL, result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
				    
				} catch (IOException e) {
					e.printStackTrace();
				}
				*/
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	} 

}
