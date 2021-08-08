package com.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testbase.Baseclass;

public class ListenerCls implements ITestListener{

	public void onTestStart(ITestResult result) {
		Baseclass.log.info("on start method"+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		Baseclass.log.info("on testcase pass method"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		Baseclass.log.info("on failure method"+result.getName());
		Baseclass.getScreenshot(result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		Baseclass.log.info("on test skipped method"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Baseclass.log.info("on onTestFailedButWithinSuccessPercentage method"+result.getName());
		
	}

	public void onStart(ITestContext context) {
		Baseclass.log.info("on start suite"+context.getName());
		
	}

	public void onFinish(ITestContext context) {
		Baseclass.log.info("on finish suite"+context.getName());
		
	}

}
