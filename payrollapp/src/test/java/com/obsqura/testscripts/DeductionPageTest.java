package com.obsqura.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.obsqura.constants.ConstantValues;
import com.obsqura.pages.AddDeductionPage;
import com.obsqura.pages.ClientPage;
import com.obsqura.pages.Dashboard;
import com.obsqura.pages.DeductionPage;
import com.obsqura.pages.DeductionResultPage;
import com.obsqura.pages.Login;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

public class DeductionPageTest extends TestHelper {
	ExtentReports extent;
	ExtentTest test;

	WebDriver driver;
	PageUtility pageUtility;
	

	@Parameters({ "browser" })
	@BeforeMethod
	public void openBrowser(String browser) {
		driver = checkBrowser(browser);

	}
	@Test
	public void checkDisplayName() {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		
		DeductionPage deductionPage = new DeductionPage(driver);
		
		String actualValue=deductionPage.displayTabName();
		Assert.assertEquals(actualValue, ConstantValues.deductionTab);
		
	}
	
	@Test
	public void addDeductionTest() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		DeductionPage deductionPage = new DeductionPage(driver);
		Thread.sleep(1000);
		deductionPage.setAddDeductionTab();
		Thread.sleep(1000);
		AddDeductionPage addDeductionPage = new AddDeductionPage(driver);
		addDeductionPage.clickworkerArrow();
		addDeductionPage.setWorkerName("jyothi");
		addDeductionPage.setDeductionType("Travel");
		addDeductionPage.setAmount(String.valueOf(20000));
		addDeductionPage.setEffectiveDate("24", "07", "2017");
		addDeductionPage.setSaveButton();
		DeductionResultPage deductionResultPage=new DeductionResultPage(driver);
		Assert.assertTrue(deductionResultPage.getWorkerName().contains("jyothi"));
		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
