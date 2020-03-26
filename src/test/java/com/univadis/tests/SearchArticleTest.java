package com.univadis.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.univadis.base.TestBase;
import com.univadis.pages.ArticlesPage;
import com.univadis.pages.DashBoardPage;
import com.univadis.pages.HomePage;
import com.univadis.pages.LoginPage;

public class SearchArticleTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	ArticlesPage articlePage;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		setConfig();
		homePage = new HomePage(driver);
		loginPage = homePage.goToLoginPage();
		dashBoardPage = loginPage.doLogin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		articlePage=dashBoardPage.goToArticle("dyspnoea");
	}

	@Test(testName = "Verify if Share Icon", description = "Verify if Share Icon, Article Title and Related Post is visible")
	public void verifyIfShareIconPresent() throws InterruptedException {
		Assert.assertTrue(articlePage.isArticleHeadingAvailable());
	}
	
	@Test(testName = "Story Block Test", description = "Verify if Related Post is visible")
	public void verifyIfRelatedStoryBlockPresent() throws InterruptedException {
		Assert.assertTrue(articlePage.isrelatedStoryBlockAvailable());
	}
	
	@Test(testName = "Article Heading Block Test", description = "Verify if Article Heading is visible")
	public void verifyIfArticleHeadingAvailable() throws InterruptedException {
		Assert.assertTrue(articlePage.isArticleHeadingAvailable());
	}
	
	@Test(testName = "Verify Email Feature", description = "Verify if Email Feature is working on not")
	public void verifyEmailFeature() throws InterruptedException {
		articlePage.sendEmail();
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
