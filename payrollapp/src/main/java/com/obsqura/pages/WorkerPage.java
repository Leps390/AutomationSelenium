package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.WaitUtility;

public class WorkerPage {
	WebDriver driver;
	WaitUtility waitutility =new WaitUtility();
	GenericUtility genericUtility=new GenericUtility();
	@FindBy(id = "workersearch-first_name")
	
	WebElement firstName;

	@FindBy(id = "workersearch-last_name")
	WebElement lastName;

	@FindBy(id = "workersearch-postcode")
	WebElement postCode;
	@FindBy(id = "workersearch-ni_number")
	WebElement niNumber;
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
	WebElement tabName;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[5]/button[1]")
	WebElement searchButton;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[5]/button[2]")
	WebElement resetButton;
	@FindBy(xpath = "/html/body/section/div/div/div[1]/ul/li[2]/a")
	WebElement createWorkerTab;
	
	public WorkerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setWorkerFirstName(String fname) {
		firstName.sendKeys(fname);

	}

	public void setWorkerLastName(String lname) {
		lastName.sendKeys(lname);

	}

	public void setPostCode(int pcode) {
		postCode.sendKeys(String.valueOf(pcode));

	}

	public void setNiNumber(int ninum) {
		niNumber.sendKeys(String.valueOf(ninum));

	}
	public String displayTabName() {
		return (genericUtility.getText(tabName));

	}
	public void setCreateWorkerTab() {
		createWorkerTab.click();

	}

	public void setSearchButtton() {
		searchButton.click();

	}

	public void searchByFirstName(String fname) throws Exception {
		this.setWorkerFirstName(fname);
		waitutility.waitImplicit(30, driver);
		this.setSearchButtton();

	}

	public void searchByLastName(String lname) throws Exception {
		this.setWorkerLastName(lname);
		waitutility.hardWait(driver);
		this.setSearchButtton();

	}

	public void searchByPostCode(String pcode) throws Exception {
		this.setPostCode(Integer.valueOf(pcode));
		waitutility.hardWait(driver);
		this.setSearchButtton();

	}

	public void setreset() throws Exception {
		WorkerPage workerPage = new WorkerPage(driver);
		waitutility.hardWait(driver);
		workerPage.setreset();

	}

	public void searchByNiNumber(int ni) throws InterruptedException {
		this.setNiNumber(ni);
		waitutility.hardWait(driver);
		this.setSearchButtton();
		

	}
	
	public String getNiNumber() {
		String ninum=niNumber.getText();
		return ninum;
	}

	/*
	 * public void resetByClientID() throws InterruptedException { ClientPage
	 * clientPage=new ClientPage(driver); Thread.sleep(1000);
	 * 
	 * this.setReset();
	 * 
	 * }
	 */

}
