package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class WorkerSearchPage {
	WebDriver driver;
	WaitUtility waitutility =new WaitUtility();
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/table/tbody/tr[3]/td[7]")
	WebElement searchedNinum;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]")
	WebElement searchedFirstName;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/table/tbody/tr[2]/td[2]")
	WebElement serachedLastName;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/table/tbody/tr[1]/td[5]")
	WebElement searchedPostCode;
	//@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/table/tbody/tr/td/div")
	
	@FindBy(xpath="//*[@id=\"w1\"]/table/tbody/tr/td/div")
	WebElement invalidWorker;
	public WorkerSearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getNiNumber() {
		
		String ninum=searchedNinum.getText();
		waitutility.hardWait(driver);
		return ninum;
	}
	public String getfirstName() {
		waitutility.hardWait(driver);
		String fname=searchedFirstName.getText();
		return fname;
	}
	public String getlastName() {
		
		String lname=serachedLastName.getText();
		waitutility.hardWait(driver);
		return lname;
	}
	public String getPostCode() {
		
		String ninum=searchedPostCode.getText();
		waitutility.hardWait(driver);
		return ninum;
	}
	public String getErrorMessage() {
		
		String error=invalidWorker.getText();
		//waitutility.hardWait(driver);
		waitutility.waitforVisibility(invalidWorker, driver);
		return error;
	}
}
