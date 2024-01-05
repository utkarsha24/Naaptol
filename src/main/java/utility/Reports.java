package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports generateReport()
	{
	ExtentSparkReporter htmlReport=new ExtentSparkReporter("ExtentsReport.html");
	ExtentReports reports=new ExtentReports();
	reports.attachReporter(htmlReport);
	reports.setSystemInfo("version", "1.10");
	reports.setSystemInfo("created by", "utkarsha");
	reports.setSystemInfo("testing type", "regression");
	return reports;
	}
	
}
