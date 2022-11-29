package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankDetails  {
	WebDriver driver;
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[2]/ul/li[3]")
	WebElement displayTitle;
	@FindBy(id="worker-ac_name")
	WebElement accountName;
	@FindBy(id="worker-ac_no")
	WebElement accountNumber;
	
	@FindBy(id="worker-sort_code")
	WebElement sortCode;
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[4]/div/button")
	WebElement saveButton;
	
	public BankDetails(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setAccountNumber(String accnum) {
		accountNumber.sendKeys(accnum);
	}
	public void setAccountName(String accname) {
		accountName.sendKeys(accname);
	}
	public void setSortCode(String scode) {
		sortCode.sendKeys(scode);
	}
	
	public String setDisplayTitle() {
		String title=displayTitle.getText();
		return title;
	}
	
	public void setSaveButton() {
		saveButton.click();
	}

}
