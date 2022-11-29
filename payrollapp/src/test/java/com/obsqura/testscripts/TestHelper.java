package com.obsqura.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.obsqura.utilities.Screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHelper {
	WebDriver driver;
	Screenshot screenshot;

	@Parameters({ "browser" })
	public WebDriver checkBrowser(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
			 "E:\\OBSQURA\\Selenium class\\chromedriver_107\\chromedriver.exe");

			String path = System.getProperty("user.dir");

			//System.setProperty("webdriver.chrome.driver", path + "\\src\\resources\\com\\obsqura\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();// initializing chrome

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else if (browser.equalsIgnoreCase("firefox")) {

			/*
			 * System.setProperty("webdriver.gecko.driver",
			 * "E:\\OBSQURA\\Selenium class\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			 */
			String path = System.getProperty("user.dir");

			System.setProperty("webdriver.chrome.driver", path + "\\src\\resources\\com\\obsqura\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else if (browser.equalsIgnoreCase("edge")) {

			String path = System.getProperty("user.dir");

			System.setProperty("webdriver.chrome.driver", path + "\\src\\resources\\com\\obsqura\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		driver.get("https://www.qabible.in/payrollapp/");
		return driver;
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
