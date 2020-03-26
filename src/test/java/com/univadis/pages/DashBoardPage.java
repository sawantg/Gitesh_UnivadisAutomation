package com.univadis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
	private final By USERNAME = By.xpath("//span[@data-initials=\"AH\"]");
	protected final By SEARCH_TEXTBOX = By.id("global-search");
	protected final By SEARCH_RESULT = By.className("result-news");
	private final By HEADING_LINK = By.xpath("//div[@class=\"onboarding-tour onboarding-tour__news\"]/span");
	private final By LATEST_UPDATE_LINK = By.xpath("//div[@class=\"new-homepage-article__title\"]/span");
	private final By PROFESSIONAL_UPDATE = By.xpath("//div[@class=\"header__title\"]");

	private WebDriver driver;
	private WebDriverWait wait;

	public DashBoardPage(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, 20);

	}

	public String getUserName() {
		String userName = wait.until(ExpectedConditions.elementToBeClickable(USERNAME)).getAttribute("data-fullname");
		return userName;
	}

	public String searchArticle(String article) throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SEARCH_TEXTBOX)))
				.sendKeys(article + Keys.ENTER);
		Thread.sleep(5000);
		String result = wait.until(ExpectedConditions.visibilityOf(driver.findElement(SEARCH_RESULT)))
				.findElement(By.tagName("a")).getAttribute("title");
		System.out.println(result);
		Thread.sleep(5000);

		return result;
	}

	public ArticlesPage goToArticle(String article) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SEARCH_TEXTBOX)))
				.sendKeys(article + Keys.ENTER);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(SEARCH_RESULT))).findElement(By.tagName("a"))
				.click();
		return new ArticlesPage(driver);

	}

	public boolean isHeadingAvailable() {
		WebElement articleBlock = wait.until(ExpectedConditions.visibilityOf(driver.findElement(HEADING_LINK)));
		if (!(articleBlock == null)) {
			return true;
		}
		return false;
	}

	public boolean isLatestUpdateHeadingAvailable() {
		WebElement articleBlock = wait.until(ExpectedConditions.visibilityOf(driver.findElement(LATEST_UPDATE_LINK)));
		if (!(articleBlock == null)) {
			return true;
		}
		return false;
	}

	public boolean isProfessionalAndBusineesHeadingAvailabe() {
		WebElement articleBlock = wait.until(ExpectedConditions.visibilityOf(driver.findElement(PROFESSIONAL_UPDATE)));
		if (!(articleBlock == null)) {
			return true;
		}
		return false;
	}

}
