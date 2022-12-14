package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class DeductionResultPage {

	
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/table/tbody/tr[1]")
	WebElement nameWorker;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/table/tbody/tr[3]")
	WebElement amountDeducted;
	
	
	public DeductionResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getWorkerName() {
		//waitutility.waitforanElement(nameWorker, driver);
		String name = nameWorker.getText();
		return name;
	}
	public String getAmountDeducted() {
		//waitutility.waitforanElement(amountDeducted, driver);
		String amount = amountDeducted.getText();
		return amount;
	}
}
