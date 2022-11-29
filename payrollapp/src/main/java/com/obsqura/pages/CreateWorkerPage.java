package com.obsqura.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class CreateWorkerPage {
	WebDriver driver;
	WaitUtility waitutility=new WaitUtility();
	Select select;

	@FindBy(id = "worker-title")

	WebElement title;
	@FindBy(id = "worker-gender")
	WebElement gender;
	@FindBy(id = "worker-branch_id")
	WebElement branch;
	@FindBy(id = "worker-first_name")
	WebElement firstName;
	@FindBy(id = "worker-middle_name")
	WebElement middleName;
	@FindBy(id = "worker-division_id")
	WebElement division;
	@FindBy(id = "worker-last_name")
	WebElement lastName;
	@FindBy(id = "worker-dob")
	WebElement dateOfBirth;
	@FindBy(id = "worker-employment_type")
	WebElement employementType;

	@FindBy(id = "worker-address1")
	WebElement addressLine1;
	@FindBy(id = "worker-payslip_method")
	WebElement paySlipMethod;
	@FindBy(id = "worker-phone")
	WebElement phnoneNUm;
	@FindBy(id = "worker-email")
	WebElement email;
	@FindBy(id = "worker-ni_number")
	WebElement niNum;
	@FindBy(id = "worker-postcode")
	WebElement postCode;
	
	@FindBy(xpath = "//*[@id=\"w0\"]/div[4]/div/button")
	WebElement nextButton;
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
	WebElement textOnCreate;
    @FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
    WebElement createdWorker;
	public CreateWorkerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setTitle(String tit) {

		select = new Select(title);

		select.selectByVisibleText(tit);
	}
	public void setBranch(String bran) {

		select = new Select(branch);

		select.selectByVisibleText(bran);
	}


	public void setGender(String gend) {

		select = new Select(gender);

		select.selectByVisibleText(gend);
	}

	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void setMiddleName(String midname) {
		middleName.sendKeys(midname);
	}

	public void setDivision(String div) {

		select = new Select(division);

		select.selectByVisibleText(div);
	}
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void setDateOfBirth(String mm,String dd,String yy) {
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(yy);
	}
	public void setEmploymentType(String empType) {

		select = new Select(employementType);

		select.selectByVisibleText(empType);
	}
	public void setAddressLine1(String addr1) {
		addressLine1.sendKeys(addr1);
	}
	public void setPaySlip(String paySlp) {

		select = new Select(paySlipMethod);

		select.selectByVisibleText(paySlp);
	}
	public void setPhonenUm(String phnum) {
		phnoneNUm.sendKeys(phnum);
	}
	public void setNiNumber(String ni) {
		niNum.sendKeys(ni);
	}
	public void setEmail(String emailid) {
		email.sendKeys(emailid);
	}
	public void setPostCode(String pcode) {
		postCode.sendKeys(pcode);
	}
	
	public void setNext() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", nextButton);
		nextButton.click();
	}
	
	public String getText() {
		String heading=textOnCreate.getText();
		return heading;
	}
	public String getCreatedWorker() {
		
		String name=createdWorker.getText();
		waitutility.hardWait(driver);
		return name;
	}
}
