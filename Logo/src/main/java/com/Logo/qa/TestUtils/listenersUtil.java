package com.Logo.qa.TestUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.Logo.qa.Base.TestBase;

public  class listenersUtil implements ITestListener{

	public void onTestSuccess(ITestResult result) {
		System.out.println("Pass Test case is " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Failed test case" +result.getName());
		testUtils.takeScreenShots();
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {

		System.out.println("Text execution completed");
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}