package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.constants.ConstantValues;
import com.obsqura.pages.BankDetails;
import com.obsqura.pages.ClientPage;
import com.obsqura.pages.CreateWorkerPage;
import com.obsqura.pages.Dashboard;
import com.obsqura.pages.Login;
import com.obsqura.pages.WorkerPage;
import com.obsqura.pages.WorkerSearchPage;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class WorkerPageTest extends TestHelper{
  
	WaitUtility waitUtility= new WaitUtility();
	
    @BeforeMethod
	@Parameters({ "browser" })
	public void openBrowser(String browser) {
		driver = checkBrowser(browser);
	}

	//@Test(alwaysRun = true, priority = 0)
	public void loginClientPage() throws IOException {
		Login login = new Login(driver);

		ExcelUtility excelUtility = new ExcelUtility();
		String userName = excelUtility.getCellValue(1, 0);
		String passWord = excelUtility.getCellValue(1, 1);
		login.loginToPage(userName, passWord);
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
		dashboard.setWorkerPage();
		WorkerPage workerPage = new WorkerPage(driver);
		
		String actualValue=workerPage.displayTabName();
		Assert.assertEquals(actualValue, ConstantValues.workerTab);
		
	}
	//to see whether the create worker tab is working or not
	@Test//(alwaysRun = true ,priority = 1)
	public void testCreateWorkerTab() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		Dashboard dashboard= new Dashboard(driver);
		
		dashboard.setWorkerPage();
		WorkerPage workerPage=new WorkerPage(driver);
		workerPage.setCreateWorkerTab();
		CreateWorkerPage createWorkerPage=new CreateWorkerPage(driver);
		String actual=createWorkerPage.getText();
		Assert.assertEquals(actual, ConstantValues.displayCreateWorker);
		
		
	}
	
	
	//to test whether values are entered properly and save is working
	
	@Test
	public void testAddWorkerSave() throws Exception  {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		Dashboard dashboard= new Dashboard(driver);
		dashboard.setWorkerPage();
		WorkerPage workerPage=new WorkerPage(driver);
		workerPage.setCreateWorkerTab();
		CreateWorkerPage createWorkerPage=new CreateWorkerPage(driver);
		createWorkerPage.setTitle("Mrs");
		createWorkerPage.setGender("Female");
		createWorkerPage.setBranch("Alpha_new");
		createWorkerPage.setFirstName("Charu");
		createWorkerPage.setDivision("NewAlpha");
		createWorkerPage.setMiddleName("P");
		createWorkerPage.setLastName("R");
		createWorkerPage.setDateOfBirth("07", "24", "2017");
		createWorkerPage.setEmploymentType("Paye");
		createWorkerPage.setPaySlip("Paper");
		createWorkerPage.setAddressLine1("Addressline1");
		createWorkerPage.setPhonenUm(String.valueOf(123456789));
		createWorkerPage.setEmail("Charu@gmail.com");
		createWorkerPage.setNiNumber(String.valueOf(12345));
		createWorkerPage.setPostCode(String.valueOf(123));
		waitUtility.hardWait(driver);
		createWorkerPage.setNext();
		BankDetails bankDetails = new BankDetails(driver);
		bankDetails.setAccountName("savings");
		bankDetails.setAccountNumber(String.valueOf(12345));
		bankDetails.setSortCode(String.valueOf(345));
		bankDetails.setSaveButton();
		String title=driver.getTitle();
		Assert.assertEquals(title, ConstantValues.workerBankTitle);
		
		
	}
	
	

	@Test//(priority = 4)
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
	@Test//(priority = 5)
	public void testWorkerLastNameSerach() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		

		Dashboard dashboard=new Dashboard(driver);
		dashboard.setWorkerPage();
		Thread.sleep(1000);
		WorkerPage workerPage=new WorkerPage(driver);
		
		workerPage.searchByLastName("benny");
		waitUtility.hardWait(driver);
		WorkerSearchPage workerSearchPage=new WorkerSearchPage(driver);
		Assert.assertTrue(workerSearchPage.getlastName().contains(ConstantValues.searchedLastName));
		
  
}
	@Test//(priority = 6)
	public void testPostCodeSerach() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		

		Dashboard dashboard=new Dashboard(driver);
		dashboard.setWorkerPage();
		Thread.sleep(1000);
		WorkerPage workerPage=new WorkerPage(driver);
		
		workerPage.searchByPostCode("123");
		waitUtility.hardWait(driver);
		WorkerSearchPage workerSearchPage=new WorkerSearchPage(driver);
		Assert.assertTrue(workerSearchPage.getPostCode().contains(ConstantValues.postCode));
		
}
	@Test//(priority = 7)
	public void testNiNumberSearch() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		
		 
		Dashboard dashboard=new Dashboard(driver);
		dashboard.setWorkerPage();
		Thread.sleep(1000);
		WorkerPage workerPage=new WorkerPage(driver);
		//workerPage.setNiNumber(12345);
		workerPage.searchByNiNumber(12345);
		WorkerSearchPage  workerSearchPage=new WorkerSearchPage(driver);
		waitUtility.hardWait(driver);
		Assert.assertTrue(workerSearchPage.getNiNumber().contains(ConstantValues.niNUm));
		/*
		 * String actual=workerSearchPage.getNiNumber(); String
		 * expected=workerPage.getNiNumber(); Assert.assertEquals(actual, expected);
		 */
	}
	@Test//(priority = 8)
	public void testInvalidWorkerName() throws Exception {
		Login login = new Login(driver);

		login.loginToPage("carol", "1q2w3e4r");
		
		Dashboard dashboard=new Dashboard(driver);
		dashboard.setWorkerPage();
		
		WorkerPage workerPage=new WorkerPage(driver);
		workerPage.setWorkerFirstName("1000000");
		WorkerSearchPage  workerSearchPage=new WorkerSearchPage(driver);
		waitUtility.hardWait(driver);
		Assert.assertTrue(workerSearchPage.getErrorMessage().contains(ConstantValues.workerErrorMsg));
	
		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}