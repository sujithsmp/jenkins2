package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtility implements ITestListener {
	ExtentSparkReporter sparkReporter;
	ExtentReports reports;
	ExtentTest test;
	String repName;	

	public void onStart(ITestContext context) {// userdef function
	

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// date time capture using
		// java

		File reportPath = new File(System.getProperty("user.dir") + "//ExtentReport");

		if (!reportPath.exists()) {
			reportPath.mkdir(); // create folder using java for storing extent Report
		}
		repName="ExtentReport_" + timeStamp + ".html" ;

		// create file for report
		sparkReporter = new ExtentSparkReporter(".//ExtentReport//" + repName);
		

		// System details
		sparkReporter.config().setDocumentTitle("Extent Report Sample");
		sparkReporter.config().setReportName("Report Summary");
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		//link extentsparkreport to extentreport
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);
		
		reports.setSystemInfo("PC Name", "Sujith");
		//reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Application", "demo");
		reports.setSystemInfo("username", System.getProperty("user.name"));
		
		String os=context.getCurrentXmlTest().getParameter("os");
		reports.setSystemInfo("Os", os);
		
		String browser=context.getCurrentXmlTest().getParameter("browser");
		reports.setSystemInfo("Browser", browser);
		
		List<String>includeGroups=context.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty())
		{
			reports.setSystemInfo("Groups", includeGroups.toString());
		}
		
		
	}

	// this method start before test execution
	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		//test = reports.createTest(result.getName());
		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());//to display group in report
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult result) {
		//test = reports.createTest(result.getName());
		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());//to display group in report
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		String path=new BaseClass().captureScreenShot(result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		
		//test = reports.createTest(result.getName());
		test = reports.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());//to display group in report
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	// invoked before all test methods
	/*
	 * public void onStart(ITestContext context) { configureReport(); }
	 */
	// invoked after all test methods
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
