package com.obsqura.testscripts;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.obsqura.constants.ConstantValues;
import com.obsqura.pages.ClientPage;
import com.obsqura.pages.Dashboard;
import com.obsqura.pages.Login;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.WaitUtility;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(com.obsqura.testscripts.ListenerLogin.class)
public class HomePageTest extends TestHelper {
	WebDriver driver;
	ExcelUtility excelUtility;
	GenericUtility genUtil;
	WaitUtility waitUtility=new WaitUtility();
	ExtentReports extent;
	 ExtentTest test;
	
    @BeforeMethod
	@Parameters({ "browser" })
	public void openBrowser(String browser) {
		driver = checkBrowser(browser);
		
	}

	
	@Test//(priority=0)
	
	public void testCheckTitle() {
		String actualTile=driver.getTitle();
		String expectedTitle=ConstantValues.title;
		Assert.assertEquals(actualTile, expectedTitle, "title doesn't match");
		
		
	}

	@Test//(alwaysRun = true, priority = 1)

	public void testCheckBox() throws IOException {

		Login login = new Login(driver);

		ExcelUtility excelUtility = new ExcelUtility();
		String userName = excelUtility.getCellValue(1, 0);
		String passWord = excelUtility.getCellValue(1, 1);
		login.loginToPage(userName, passWord);

		Boolean actual = login.isCheckBoxSelected();
		Assert.assertTrue(actual);

	}

	@Test//(alwaysRun = true, priority = 2)

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

	@Test//(priority = 3)
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

	

	@Test//(priority = 4)
	public void testResetPassword() {
		Login login=new Login(driver);
		login.isResetClickable();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = ConstantValues.resetUrl;
		Assert.assertEquals(actualUrl, expectedUrl,"url not correct");
	}
	@Test//(groups = { "Grouping" })
	public void testInvalidCredentials() {
		Login login=new Login(driver);
		login.loginToPage("user", "pwd");
		waitUtility.hardWait(driver);
		String actualMsg=login.InvalidCredentials();
		String expectedMsg=ConstantValues.invalidCredentials;
	
		Assert.assertEquals(actualMsg, expectedMsg,"message incorrect");
	}
	
	@Test
	public void testingInvalidLoginBlank() {
		Login login=new Login(driver);
		login.loginToPage("", "");
		waitUtility.hardWait(driver);
		
		Assert.assertTrue(login.getUserBlankMsg().contains(ConstantValues.blankuserError));
		
		Assert.assertTrue(login.getPasswordBlankMsg().contains(ConstantValues.blankpassError));
		
	}
	/*@Test
	public void testingResetForCorrectEmail() {
		userloginpage = new UserLoginPage(driver);
		
		emailresetpage = userloginpage.clickReset();
		String titleLogin = emailresetpage.pageTitle();
		Assert.assertEquals("Password Reset", titleLogin);
		
		homepage = emailresetpage.enterResetInfo("carol@caredirectrecruitment.co.uk");
		Assert.assertTrue(homepage.getEmailSentMsg().contains("Check your email for further instructions."));
		Reporter.log("Reset email sent", true);	
	}
	*/
	//@Test
	/*public void testingResetForWrongEmail() {
		userloginpage = new UserLoginPage(driver);
		
		emailresetpage = userloginpage.clickReset();
		String titleLogin = emailresetpage.pageTitle();
		Assert.assertEquals("Password Reset", titleLogin);
		emailresetpage.enterResetInfo("namita@gmail.com");
		
		Assert.assertTrue(emailresetpage.getWrongEmailMsg().contains("There is no user with this email address."));
		Reporter.log("Reset Unsuccessful", true);
	}*/
	
	/*@Test
	public void testingResetForBlankEmail() {
		userloginpage = new UserLoginPage(driver);
		
		emailresetpage = userloginpage.clickReset();
		String titleLogin = emailresetpage.pageTitle();
		Assert.assertEquals("Password Reset", titleLogin);
		emailresetpage.enterResetInfo("");
		
		Assert.assertTrue(emailresetpage.getWrongEmailMsg().contains("Email cannot be blank."));
		Reporter.log("Reset Unsuccessful", true);
	}*/
	
	@Test
	/*
	 * public void verifyCancelForCorrectEmail() { userloginpage = new
	 * UserLoginPage(driver);
	 * 
	 * emailresetpage = userloginpage.clickReset(); String title =
	 * emailresetpage.pageTitle(); Assert.assertEquals("Password Reset", title);
	 * emailresetpage.clickCancelButton();
	 * 
	 * String titleLogin = userloginpage.pageTitle(); Assert.assertEquals("Login",
	 * titleLogin); }
	 */
	
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
