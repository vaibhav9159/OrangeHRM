package com.hrm.qa.Listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrm.qa.base.BaseTest;

import io.qameta.allure.Attachment;

public class AllureTestListener  implements ITestListener  {

	
	private static String getTestMethodName(ITestResult iTestresult)
	{
		return iTestresult.getMethod().getConstructorOrMethod().getName();
	}
	
	// Text attachments for Allure
		@Attachment(value = "Page screenshot", type = "image/png")
		public byte[] saveScreenshotPNG(WebDriver driver) {
			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		}

		// Text attachments for Allure
		@Attachment(value = "{0}", type = "text/plain")
		public static String saveTextLog(String message) {
			return message;
		}

		// HTML attachments for Allure
		@Attachment(value = "{0}", type = "text/html")
		public static String attachHtml(String html) {
			return html;
		}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("onTestStart ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("onTestSuccess " + getTestMethodName(result));
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
/*		Object testClass = iTestResult.getInstance();
		WebDriver driver = BaseTest.getDriver();
		// Allure ScreenShotRobot and SaveTestLog
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			saveScreenshotPNG(driver);
		}
		// Save a log on allure.
		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");	 */	
	} 

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
		System.out.println("onTestFailedWithTimeout "+ getTestMethodName(result));
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
//		context.setAttribute("WebDriver", BaseTest.getDriver());
		System.out.println("onStart " +context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		System.out.println("onFinish "+ (context.getName()));
	}

	
	
}
