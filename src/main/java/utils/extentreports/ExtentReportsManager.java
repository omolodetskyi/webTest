package utils.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsManager {
	private static final ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreports/extent.html");
	private static ExtentReports extent;
	public static ExtentReports getInstance(){
		if(extent==null){
			extent=new ExtentReports();
			extent.attachReporter(htmlReporter);
		}
		return extent;
		
	}

}
