package com.univadis.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.univadis.utility.TestUtilities;

public class TestBase {
	protected static WebDriver driver;
	protected Properties prop;
	protected String MAIN_PAGE_URL;

	public void setConfig() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//config/config.properties");
		prop = new Properties();
		prop.load(fis);
		
		String browser = "chrome";
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//driver//chromedriver80.exe");
			System.out.println("LAUNCHING CHROME BROWSER ON YOUR LOCAL SYSTEM");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//driver//IEDriverServer.exe");
			System.out.println("LAUNCHING IE BROWSER ON YOUR LOCAL SYSTEM");
			driver = new InternetExplorerDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//driver//geckodriver.exe");
			System.out.println("LAUNCHING FIREFOX BROWSER ON YOUR LOCAL SYSTEM");
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().pageLoadTimeout(TestUtilities.TIME_OUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
