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

import com.univadis.pages.DashBoardPage;
import com.univadis.pages.HomePage;
import com.univadis.pages.LoginPage;

public class ArticlePageTest {
	WebDriver driver; // null
	Properties prop; // null
	HomePage homePage; // null
	LoginPage loginPage; // null
	DashBoardPage dashBoardPage;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Driver//chromedriver80.exe");
		driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//config/config.properties");
		prop = new Properties(); // Important
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		homePage = new HomePage(driver);
		loginPage = homePage.goToLoginPage();
		dashBoardPage = loginPage.doLogin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));

	}

	@Test(testName = "Search Article Test", description = "Verify search article feature is working or not")
	public void verifySearchArticleTest() throws InterruptedException {
		String result = dashBoardPage.searchArticle("dyspnoea");
		Assert.assertTrue(result.contains("dyspnoea"));
	}

	@Test(testName = "Article Heading Test", description = "Verify if Heading is present")
	public void verifyIfShareIconPresent() throws InterruptedException {
		Assert.assertTrue(dashBoardPage.isHeadingAvailable());
	}

	@Test(testName = "Latest Update Block Test", description = "Verify if Latest Update Block is visible")
	public void verifyIfRelatedStoryBlockPresent() throws InterruptedException {
		Assert.assertTrue(dashBoardPage.isLatestUpdateHeadingAvailable());
	}

	@Test(testName = "Professional and Business Heading Test", description = "Verify if Professional and Business Heading is visible")
	public void verifyIfArticleHeadingAvailable() throws InterruptedException {
		Assert.assertTrue(dashBoardPage.isProfessionalAndBusineesHeadingAvailabe());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
