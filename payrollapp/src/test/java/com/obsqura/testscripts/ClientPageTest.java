package com.obsqura.testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.constants.ConstantValues;
import com.obsqura.pages.ClientPage;
import com.obsqura.pages.CreateClientPage;
import com.obsqura.pages.Dashboard;
import com.obsqura.pages.Login;
import com.obsqura.pages.NewlyAddedClientPage;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

//@Listeners(com.obsqura.testscripts.ListenerLogin.class)
public class ClientPageTest extends TestHelper {
	WebDriver driver;
	PageUtility pageUtility;
	ClientPage clientPage = new ClientPage(driver);
	WaitUtility waitUtility = new WaitUtility();

	@BeforeMethod
	@Parameters({ "browser" })

	public void openBrowser(@Optional String browser) {
		driver = checkBrowser(browser);
	}

	@Test // (alwaysRun = true, priority = 0)
	public void testLoginLogo() throws IOException {

		Login login = new Login(driver);

		ExcelUtility excelUtility = new ExcelUtility();
		String userName = excelUtility.getCellValue(1, 0);
		String passWord = excelUtility.getCellValue(1, 1);
		login.loginToPage(userName, passWord);
		Dashboard dashboard = new Dashboard(driver);
		waitUtility.hardWait(driver);
		boolean actual = dashboard.validadeLogo();
		Assert.assertEquals(actual, true);

	}

	@Test // (alwaysRun = true, priority = 1)
	public void testLoginDisplay() throws IOException, Exception {

		Login login = new Login(driver);

		ExcelUtility excelUtility = new ExcelUtility();
		String userName = excelUtility.getCellValue(1, 0);
		String passWord = excelUtility.getCellValue(1, 1);
		login.loginToPage(userName, passWord);
		Dashboard dashboard = new Dashboard(driver);
		waitUtility.hardWait(driver);
		String actualText = dashboard.displayText();
		String expectedText = ConstantValues.homePageText;
		System.out.println("Actual text is " + actualText);

		Assert.assertEquals(actualText, expectedText);

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

	 @Test(groups = { "Grouping" })//(priority = 2)
	public void addingClient() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		Dashboard dashboard = new Dashboard(driver);
		dashboard.setClientPage();
		ClientPage clientPage = new ClientPage(driver);
		clientPage.setcreateClientTab();
		CreateClientPage createClientPage = new CreateClientPage(driver);

		createClientPage.setDivision("NewAlpha");
		createClientPage.setInvoiceOrder("Single timesheet per client");
		createClientPage.addBranch("Alpha_new");
		createClientPage.setDelivery("Paper");
		createClientPage.setMasterDocument("Print");

		String generatedName = pageUtility.randomStringGenerator();
		createClientPage.setClientName(generatedName);
		/*
		 * String generatedphone=String.valueOf(PageUtility.randomIntegerGenerator());
		 * createClientPage.setPhone(generatedphone);
		 */
		// createClientPage.setPhone("1234567");
		createClientPage.setInvoiceContract("contract");
		createClientPage.setPhone(String.valueOf(1234567));
		createClientPage.setSettleDAys(String.valueOf(3));
		createClientPage.setFax(String.valueOf(123456789));
		createClientPage.setemail("leps@gmail.com");
		createClientPage.setPostCode(String.valueOf(123456789));
		createClientPage.setcountry("India");
		createClientPage.setAddress("address line 1");
		createClientPage.setCompanyREg("reg field");
		createClientPage.setVatRatet("VAT 5.00%");
		createClientPage.setSave();

		waitUtility.hardWait(driver);
		String actualName = createClientPage.profileName();
		Assert.assertEquals(actualName, generatedName, "name mismatch");

	}

	// @Test(dependsOnMethods = {"addingClient"})//(priority = 3)
	public void viewDetail() throws Exception {

		NewlyAddedClientPage newlyAddedClientPage = new NewlyAddedClientPage(driver);
		String actualText = newlyAddedClientPage.displayName();
		String expectedText = ConstantValues.clientViewText;
		waitUtility.hardWait(driver);
		Assert.assertEquals(actualText, expectedText);
	}

	@Test(groups = { "Grouping" })
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

	@Test // (priority = 6)
	public void testClientReset() throws Exception {

		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		Dashboard dashboard = new Dashboard(driver);
		dashboard.setClientPage();
		ClientPage clientPage = new ClientPage(driver);
		clientPage.setClients();
		clientPage.resetByClientName();
		String nullValue = "";
		waitUtility.hardWait(driver);
		String checkValue = clientPage.getClientName();
		Assert.assertEquals(checkValue, nullValue);

	}

	@Test // (priority = 7)
	public void testClientSearchById() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		Dashboard dashboard = new Dashboard(driver);
		dashboard.setClientPage();
		ClientPage clientPage = new ClientPage(driver);
		clientPage.setClients();

		clientPage.searchByClientID("1");
		String actualText = clientPage.getdisplayId();
		String expectedText = "1";
		Assert.assertEquals(actualText, expectedText);
		waitUtility.hardWait(driver);

	}

	@Test // (priority = 8)
	public void testClientResetId() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		Dashboard dashboard = new Dashboard(driver);
		dashboard.setClientPage();
		ClientPage clientPage = new ClientPage(driver);
		clientPage.setClients();

		clientPage.resetByClientID();

		String nullValue = "";
		String checkValue = clientPage.getResetClientID();
		Assert.assertEquals(checkValue, nullValue);
	}

	@Test // (priority = 9)
	public void testInvalidClient() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		Dashboard dashboard = new Dashboard(driver);
		boolean actual = dashboard.validadeLogo();
		Assert.assertEquals(actual, true);
		dashboard.setClientPage();
		ClientPage clientPage = new ClientPage(driver);
		waitUtility.hardWait(driver);
		clientPage.setClients();
		clientPage.searchByClientName("1000");
		String error = clientPage.getErrorMsg();

		Assert.assertEquals(error, ConstantValues.errorForClient);

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
