package com.hrm.qa.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count =0;
	int retryAttempt = 2;
	
	@Override
	public boolean retry(ITestResult result) {
	
		if(count<retryAttempt)
		{
			count ++;
			return true;
		}	
		return false;
	}

}
