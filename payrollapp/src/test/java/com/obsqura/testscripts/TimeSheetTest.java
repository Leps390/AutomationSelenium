package com.obsqura.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.constants.ConstantValues;

import com.obsqura.pages.Dashboard;
import com.obsqura.pages.Login;
import com.obsqura.pages.PendingTimeSheetPage;
import com.obsqura.pages.TimeSheetPage;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.WaitUtility;

public class TimeSheetTest extends TestHelper {

	WebDriver driver;
	WaitUtility waitUtility=new WaitUtility();
	@BeforeMethod
	@Parameters({ "browser" })
	public void openBrowser(String browser) {
		driver = checkBrowser(browser);
	}

	@Test // (priority=1)
	public void setTimSheetPage() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		Dashboard dashboard = new Dashboard(driver);
		dashboard.setTimeSheetPage();
		waitUtility.hardWait(driver);
		TimeSheetPage timeSheetPage = new TimeSheetPage(driver);

		String actualHeading = timeSheetPage.getHeading();
		Assert.assertEquals(actualHeading, ConstantValues.timeSheetTitle);
	}

	@Test // (priority = 2)
	public void setGeneratePaySlip() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		Dashboard dashboard = new Dashboard(driver);
		dashboard.setTimeSheetPage();
		waitUtility.hardWait(driver);
		TimeSheetPage timeSheetPage = new TimeSheetPage(driver);
		timeSheetPage.setPendingTimeSheet();
		PendingTimeSheetPage pendingTimeSheetPage = new PendingTimeSheetPage(driver);
		pendingTimeSheetPage.setGeneratePaySlip();
		 waitUtility.waitForAnAlert(driver);
		String actualAlert = pendingTimeSheetPage.getAlertMessage();
		Assert.assertEquals(actualAlert, ConstantValues.timeSheetPayslipAlert);

	}

	@Test // (priority = 2)
	public void setGenerateInvoice() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		Dashboard dashboard = new Dashboard(driver);
		dashboard.setTimeSheetPage();
		waitUtility.hardWait(driver);
		TimeSheetPage timeSheetPage = new TimeSheetPage(driver);
		timeSheetPage.setPendingTimeSheet();
		PendingTimeSheetPage pendingTimeSheetPage = new PendingTimeSheetPage(driver);
		pendingTimeSheetPage.setGenereateInvoice();
	 waitUtility.waitForAnAlert(driver);
		String actualAlert = pendingTimeSheetPage.getAlertMessage();
		Assert.assertEquals(actualAlert, ConstantValues.timeSheetInvoiceAlert);

	}

	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
