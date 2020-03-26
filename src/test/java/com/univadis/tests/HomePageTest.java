package com.univadis.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.univadis.base.TestBase;
import com.univadis.pages.DashBoardPage;
import com.univadis.pages.HomePage;
import com.univadis.pages.LoginPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() throws IOException {
		setConfig();
		homePage = new HomePage(driver);
	}

	@Test(testName = "Load More Test", description = "Verify the total number General Category Articles ")
	public void verifyLoadMoreContentTest() throws InterruptedException {
		homePage.selectGeneralCategory();
		int totalCount = homePage.countLatestUpdateArticles();
		Assert.assertEquals(totalCount, 28);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
