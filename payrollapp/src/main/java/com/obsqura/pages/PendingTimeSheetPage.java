package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class PendingTimeSheetPage {
	WebDriver driver;
	WaitUtility waitUtility=new WaitUtility();
	@FindBy(xpath="/html/body/section/div/div/div[2]/button[1]")
	
	WebElement generatePayslip;
	@FindBy(xpath="/html/body/section/div/div/div[2]/button[2]")
	WebElement generateInvoice;
	public PendingTimeSheetPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setGenereateInvoice() {
		generateInvoice.click();
		
		driver.switchTo().alert().accept();
	}
	public void setGeneratePaySlip() throws Exception {
		waitUtility.hardWait(driver);
		generatePayslip.click();
		driver.switchTo().alert().accept();
		
		
	}
	public String getAlertMessage() {
		String alertMessage= driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alertMessage;
	}
	
}
