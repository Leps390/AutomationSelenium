package com.obsqura.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.constants.ConstantValues;
import com.obsqura.pages.ClientPage;
import com.obsqura.pages.Dashboard;
import com.obsqura.pages.DeductionPage;
import com.obsqura.pages.Login;
import com.obsqura.pages.PendingTimeSheetPage;
import com.obsqura.pages.TimeSheetPage;
import com.obsqura.pages.WorkerPage;
import com.obsqura.pages.WorkerSearchPage;
import com.obsqura.utilities.ExtendReportUtility;
import com.obsqura.utilities.WaitUtility;

@Listeners(ExtendReportUtility.class)
public class RegressionTest extends TestHelper{
	WebDriver driver;
	WaitUtility waitUtility = new WaitUtility();
	@BeforeMethod
	@Parameters({ "browser" })
	public void openBrowser(String browser) {
		driver = checkBrowser(browser);
		
	}
	
	@Test
	public void testLogin() throws IOException {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		Dashboard dashboard = new Dashboard(driver);
		boolean actual = dashboard.validadeLogo();
		Assert.assertEquals(actual, true);

		String actualText = dashboard.displayText();
		String expectedText = ConstantValues.homePageText;
		System.out.println("Actual text is " + actualText);

		Assert.assertEquals(actualText, expectedText);

	}
@Test
public void testLogout() {
	Login login = new Login(driver);

	login.loginToPage("carol", "1q2w3e4r");
	Dashboard dashboard = new Dashboard(driver);
	dashboard.setClientPage();
	ClientPage clientPage = new ClientPage(driver);
	clientPage.setLogout();
	String actualUrl = driver.getCurrentUrl();
	String expectedUrl = ConstantValues.loginUrl;
	Assert.assertEquals(actualUrl, expectedUrl);
}
@Test
public void testClientSerach() throws Exception {
	Login login = new Login(driver);

	login.loginToPage("carol", "1q2w3e4r");
	Dashboard dashboard = new Dashboard(driver);
	dashboard.setClientPage();
	ClientPage clientPage = new ClientPage(driver);
	clientPage.setClients();
	clientPage.searchByClientName("Charu");
	waitUtility.hardWait(driver);
	String actualName = clientPage.getSearchedClient();
	Assert.assertEquals(actualName, "Charu");

}
@Test
public void checkDisplayName() {
	Login login = new Login(driver);

	login.loginToPage("carol", "1q2w3e4r");
	Dashboard dashboard = new Dashboard(driver);
	dashboard.setClientPage();
	ClientPage clientPage = new ClientPage(driver);

	String actualValue = clientPage.displayTabName();
	Assert.assertEquals(actualValue, ConstantValues.clientTab);

}
@Test
public void testWorkerSerach() throws Exception {
	Login login = new Login(driver);

	login.loginToPage("carol", "1q2w3e4r");
	
	Dashboard dashboard=new Dashboard(driver);
	dashboard.setWorkerPage();
	
	WorkerPage workerPage=new WorkerPage(driver);
	
	workerPage.searchByFirstName("Charu");
	waitUtility.hardWait(driver);
	WorkerSearchPage workerSearchPage=new WorkerSearchPage(driver);
	Assert.assertTrue(workerSearchPage.getfirstName().contains(ConstantValues.workerNameSearch));
}

@Test
public void checkDisplayNameDeduction() {
	Login login = new Login(driver);

	login.loginToPage("carol", "1q2w3e4r");
	
	DeductionPage deductionPage = new DeductionPage(driver);
	
	String actualValue=deductionPage.displayTabName();
	Assert.assertEquals(actualValue, ConstantValues.deductionTab);
	
}
@Test 
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

}
