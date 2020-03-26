package com.univadis.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.univadis.utility.TestUtilities;

public class MyCustomListener implements ITestListener {

	public static ExtentReports extent; 
	public static ExtentTest test; 

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********* Starting Test" + result.getName() + "**************");
		test = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********* Test Pass" + result.getName());
		test.log(Status.PASS, result.getName());
		try {
			TestUtilities.takeSnapShot(System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********* Test Fail" + result.getName());
		test.log(Status.FAIL, result.getName());
		try {
			TestUtilities.takeSnapShot(System.getProperty("user.dir") + "/screenshots/" + "Failed"+result.getName() + ".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("********* Test Skipped" + result.getName());
		test.log(Status.SKIP, result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("********* Running " + context.getClass().getName());
		ExtentHtmlReporter html = new ExtentHtmlReporter("TestReport.html"); 
		extent = new ExtentReports();
		extent.attachReporter(html);

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
