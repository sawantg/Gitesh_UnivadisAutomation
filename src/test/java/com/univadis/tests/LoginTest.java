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

public class LoginTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() throws IOException {
		setConfig();
		homePage = new HomePage(driver);
		loginPage = homePage.goToLoginPage();

	}
	
	@Test(testName = "LoginTest", description = "Verify whether the user is able to login into the univadis.co.uk")
	public void verifyLoginTest() throws InterruptedException {

		DashBoardPage dashBoardPage = loginPage.doLogin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		Assert.assertEquals(dashBoardPage.getUserName(), prop.getProperty("EXPECTED_USERNAME"));
	}


	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
