package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	public static ExtentReports getInstance() {
		ExtentReports report;
		ExtentHtmlReporter htmlReporter;
	    htmlReporter  = new ExtentHtmlReporter("reports/report.html");
		report = new ExtentReports(); 
		return null;
	}

}
