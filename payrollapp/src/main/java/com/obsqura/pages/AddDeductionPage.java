package com.obsqura.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.WaitUtility;

public class AddDeductionPage {
	Select select;

	WebDriver driver;
	WaitUtility waitutility =new WaitUtility();
	
	//@FindBy(id = "select2-deduction-worker_id-container")
	@FindBy(xpath="/html/body/span/span/span[1]/input")
	WebElement workerName;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/form/div[1]/div/span/span[1]/span/span[1]")
	//@FindBy(xpath="/html/body/section/div/div/div[2]/div/div/form/div[1]/div/span/span[1]/span/span[2]")
	WebElement workerArrow;
	@FindBy(id = "deduction-type")
	WebElement type;
	@FindBy(id = "deduction-amount")
	WebElement amount;
	@FindBy(id = "deduction-effective_from")
	WebElement effectiveDate;
	@FindBy(xpath="//*[@id=\"w0\"]/div[5]/div/button")
	WebElement saveButton;
	
	public AddDeductionPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickworkerArrow() {
		workerArrow.click();
	}
	public void setWorkerName(String workername) {
		waitutility.hardWait(driver);
		workerName.sendKeys(workername);
		workerName.sendKeys(Keys.ENTER);
		//select = new Select(workerName);
	
		//select.selectByVisibleText(workername);
	}
	
	public void setDeductionType(String deducType) {
		type.click();
		select = new Select(type);
		select.selectByVisibleText(deducType);
	}
	
	public void setAmount(String amt) {
		amount.sendKeys(amt);

	}

	public void setEffectiveDate(String dd,String mm,String yy) {
		effectiveDate.sendKeys(mm);
		effectiveDate.sendKeys(dd);
		effectiveDate.sendKeys(yy);
	}
	public void setSaveButton() {
   JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", saveButton);
		
		saveButton.click();

	}
}
