package com.univadis.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	int count = 1;
	int limit = 4;

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (count < limit) {
			count=count+1;
			return true;
		}

		return false;
	}

}
