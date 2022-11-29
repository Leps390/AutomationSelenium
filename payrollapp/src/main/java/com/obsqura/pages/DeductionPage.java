package com.obsqura.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.GenericUtility;

public class DeductionPage {
	WebDriver driver;
	GenericUtility genericUtility=new GenericUtility();
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
	WebElement tabName;
	public DeductionPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String displayTabName() {
		return (genericUtility.getText(tabName));

	}
	public void setAddDeductionTab() {
		
		driver.navigate().to("https://www.qabible.in/payrollapp/deduction/create");
		}
	
}
