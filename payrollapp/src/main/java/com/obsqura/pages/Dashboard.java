package com.obsqura.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.WaitUtility;

public class Dashboard {
WebDriver driver;
WaitUtility waitUtility;

@FindBy(xpath = "/html/body/header/div[1]/div/div[1]/img")
WebElement logo;

@FindBy(xpath = "/html/body/section/div/div/div/p[1]")
WebElement displayText;

@FindBy(linkText = "Workers")
WebElement workerTab;

@FindBy(linkText = "Clients")
//@FindBy(xpath="//*[@id=\"w3\"]/li[3]/a")
WebElement clientsTab;

//@FindBy(xpath="//a[@href='/payrollapp/deduction/index']")
//@FindBy(linkText = "Deduction")

//WebElement deductionTab;

@FindBy(linkText = "TimeSheet")
//@FindBy(xpath="//*[@id=\"w1\"]/li[6]/a")
WebElement timeSheet;


public Dashboard(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}


  public boolean validadeLogo() {
  
  logo.isDisplayed();
  return true; 
  }
 

public String displayText()
{

	//waitUtility.waitforanElement(displayText, driver);
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String s=displayText.getText();
	System.out.println("inside display text method" +s);
	return s;
	
}

public void setWorkerPage() {
	workerTab.click();
}
public void setClientPage() {
	clientsTab.click();
}
public void setDeductionPage() throws Exception {
	Thread.sleep(1000);
	//deductionTab.click();
}
public void setTimeSheetPage() {
	timeSheet.click();
	//driver.navigate().to("https://www.qabible.in/payrollapp/timesheet/index");
}
}
