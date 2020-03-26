package com.univadis.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private final By LOGIN_LINK = By.linkText("Login");
	private final By SIGN_UP_LINK = By.linkText("Sign up free");
	private final By GENERAL_LINK = By.linkText("General Practice");
	private final By LATEST_UPDATE_BLOCK = By.xpath("//ul[@id=\"news-list-content\"]");
	private final By LOAD_MORE = By.xpath("//a[normalize-space(text())=\"Load more\"]");
	private WebDriver driver;
	private WebDriverWait wait;

	public HomePage(WebDriver wd) {

		driver = wd;
		wait = new WebDriverWait(driver, 20);
		// TODO Auto-generated constructor stub
	}

	public LoginPage goToLoginPage() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOGIN_LINK))).click();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;
	}

	public void goToSignUpPage() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(SIGN_UP_LINK))).click();
	}

	public void selectGeneralCategory() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(GENERAL_LINK))).click();
	}

	public int countLatestUpdateArticles() throws InterruptedException {
		WebElement latestBlock = wait.until(ExpectedConditions.visibilityOf(driver.findElement(LATEST_UPDATE_BLOCK)));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOAD_MORE))).click();
		Thread.sleep(5000);
		List<WebElement> total = latestBlock.findElements(By.className("new-homepage-article__item"));
		System.out.println(total.size());
		return total.size();
	}

}
