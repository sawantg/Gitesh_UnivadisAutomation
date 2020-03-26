package com.univadis.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.univadis.base.TestBase;

public class TestUtilities extends TestBase {
	public static final long TIME_OUT = 30;
	public static final long EXPLICIT_WAIT_TIME_OUT=20;

	public static void takeSnapShot(String fileWithPath) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE); // content
		File DestFile = new File(fileWithPath);// blank file
		FileUtils.copyFile(SrcFile, DestFile); //
		System.out.println("Screenshot taken");

	}

}
