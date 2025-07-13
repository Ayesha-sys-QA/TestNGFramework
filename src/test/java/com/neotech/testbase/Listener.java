package com.neotech.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.neotech.utils.CommonMethods;

public class Listener implements ITestListener{

	
	public void onStart(ITestContext context)
	{
		System.out.println("Functionality Test Started!");
	}
	
	public void onFinish(ITestContext context)
	{
		System.out.println("Functionality Test Finished!");
	}
	
	
	public void onTestStart(ITestResult result)
	{
		// prints the name of the test that is starting
		System.out.println(result.getName() + " test is starting...");

		// creates a test in the report for the current test
		BaseClass.test = BaseClass.report.createTest(result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println(result.getName() + " test just failed!");

		// print the test failed message in the report
		BaseClass.test.fail(result.getName() + " test FAILED!");

		// add screenshot to the report
		String screenshotPath = CommonMethods.takeScreenshot("failed/" + result.getName());
		BaseClass.test.addScreenCaptureFromPath(screenshotPath);
	}
	
	public void onTestSuccess(ITestResult result)
	{
		// logs the success of the test in the report into the console
		System.out.println(result.getName() + " test just passed!");

		// print the test passed message in the report
		BaseClass.test.pass(result.getName() + " test passed!");

		// add screenshot to the report
		String screenshotPath = CommonMethods.takeScreenshot("passed/" + result.getName());
		BaseClass.test.addScreenCaptureFromPath(screenshotPath);
	}
}