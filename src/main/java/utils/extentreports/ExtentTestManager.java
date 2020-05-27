package utils.extentreports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	static Map extentTestMap=new HashMap();
	static ExtentReports extent=ExtentReportsManager.getInstance();
	public synchronized static ExtentTest getTest(){
		return (ExtentTest) extentTestMap.get((int)(long)(Thread.currentThread().getId()));	
	}
	public synchronized static ExtentTest createTest (String testName, String desc){
		ExtentTest test=extent.createTest(testName, desc);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
		
	}

}
