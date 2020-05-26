package utils.extentReports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.extentReports.ExtentReportsManager;

public class ExtentTestManager {
	static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentReportsManager.getInstance();
    public synchronized static ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
    public synchronized static ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}
