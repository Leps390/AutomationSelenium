package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeSheetPage {
	
	WebDriver driver;
	@FindBy(xpath="/html/body/section/div/div/div[1]/ul/li[1]/a")
	WebElement pendingTimesheet;
	@FindBy(linkText = "Approved Timesheets")
	WebElement approvedTimesheet;
	@FindBy(linkText = "Create Timesheet")
	WebElement createTimesheet;
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
	WebElement timeSheetHeading;
	
	public TimeSheetPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setPendingTimeSheet() {
		pendingTimesheet.click();
	}
	
	public void setApprovedTimeSheet() {
		approvedTimesheet.click();
	}
	public void setCreateTimeSheet() {
		createTimesheet.click();
	}

	public String getHeading() {
		String s=timeSheetHeading.getText();
		System.out.println("inside display text method" +s);
		return s;
	}
}
