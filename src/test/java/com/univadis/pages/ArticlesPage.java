package com.univadis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticlesPage {

	private final By SHAREICON = By.className("social");
	private final By RELATED_STORY = By.className("header__title");
	private final By ARTICLE_HEADING = By.className("new-article__title--title-small");
	private final By EMAIL_LINK = By.xpath("//a[@title=\"Email\"]/..");
	private final By EMAIL_TEXTBOX = By.name("emailAddress");
	private final By SEND_EMAIL_BUTTON = By.xpath("//input[@value=\"Send\"]");
	private final By EMAIL_STATUS = By.xpath("//*[text()=\"Article sent\"]");
	protected final By SEARCH_TEXTBOX = By.id("global-search");
	protected final By SEARCH_RESULT = By.className("result-news");
	private WebDriver driver;
	private WebDriverWait wait;

	public ArticlesPage(WebDriver wd) {
		driver = wd;
		wait = new WebDriverWait(driver, 20);
		// TODO Auto-generated constructor stub
	}

	public boolean isrelatedStoryBlockAvailable() {
		WebElement relatedBlock = wait.until(ExpectedConditions.visibilityOf(driver.findElement(RELATED_STORY)));
		if (!(relatedBlock == null)) {
			return true;
		}
		return false;

	}

	public boolean isShareIconAvailable() {
		WebElement shareIcon = wait.until(ExpectedConditions.visibilityOf(driver.findElement(SHAREICON)));
		if (!(shareIcon == null)) {
			return true;
		}
		return false;
	}

	public boolean isArticleHeadingAvailable() {
		WebElement articleBlock = wait.until(ExpectedConditions.visibilityOf(driver.findElement(ARTICLE_HEADING)));
		if (!(articleBlock == null)) {
			return true;
		}
		return false;
	}

	public boolean sendEmail() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(EMAIL_LINK))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(EMAIL_TEXTBOX)))
				.sendKeys("Paresh.Mehta@aptushealth.com");
		Thread.sleep(6000);

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SEND_EMAIL_BUTTON)))
				.click();
		WebElement state = wait.until(ExpectedConditions.visibilityOf(driver.findElement(EMAIL_STATUS)));

		if (!(state == null)) {
			return true;
		}
		return false;
	}

}
