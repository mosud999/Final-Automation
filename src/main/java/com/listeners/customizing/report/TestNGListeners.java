package com.listeners.customizing.report;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.nike.utilities.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestNGListeners extends BaseClass implements ITestListener {
	

	
	ExtentReports extentReports;
	ExtentTest extentTest;

	@Override
	public void onFinish(ITestContext result) {
		extentReports.endTest(extentTest);	
		extentReports.flush();
	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is Failed");
		File file = screentshotCaptureMethod(result.getMethod().getMethodName());
		extentTest.log(LogStatus.FAIL, result.getMethod().getMethodName(), " is failed");
		String path = file.getAbsolutePath();
	
		extentTest.log(LogStatus.FAIL, result.getMethod().getMethodName() + "is failed" + extentTest.addScreenCapture(path));
		extentTest.log(LogStatus.INFO, result.getMethod().getMethodName() + " message"+result.getThrowable().getMessage());

		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is Skipped");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is Started");
		extentReports= new ExtentReports("C:\\Users\\User\\workspace\\Nike.Automation\\extent_report\\extentReport.html");
		extentTest=extentReports.startTest(result.getMethod().getMethodName());
		extentTest.log(LogStatus.INFO, result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is Success");
		//extentTest=extentReports.startTest(result.getMethod().getMethodName());
		extentTest.log(LogStatus.PASS, result.getMethod().getMethodName(), " is success");
	}

}
