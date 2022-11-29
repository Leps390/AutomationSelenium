package com.obsqura.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.utilities.GenericUtility;

public class CreateClientPage {
	GenericUtility genUtility =new GenericUtility();
	Select select;

	WebDriver driver;
	@FindBy(id = "client-branch_id")
	WebElement clientbranch;
	// @FindBy(id="client-your_ref")
	@FindBy(id = "client-division_id")
	WebElement division;

	@FindBy(id = "client-invoice_order")
	WebElement invoiceOrder;
	@FindBy(id = "client-invoice_contact")
	WebElement invoiceContact;
	@FindBy(id = "client-invoice_delivery_method")
	WebElement invoiceDelivery;
	@FindBy(xpath = "//*[@id=\"client-client_name\"]")
	WebElement clientName;
	@FindBy(id = "client-phone")
	WebElement phone;
	@FindBy(id = "client-master_document")
	WebElement masterDocument;
	@FindBy(id = "client-client_address")
	WebElement clientAddr;
	@FindBy(id = "client-fax")
	WebElement fax;
	@FindBy(id = "client-settilement_days")
	WebElement settleDAys;
	@FindBy(id = "client-postcode")
	WebElement postCOde;
	@FindBy(id = "client-email")
	WebElement email;
	@FindBy(id = "client-vat_rate")
	WebElement vatRate;
	@FindBy(id = "client-company_reg")
	WebElement compREg;
	@FindBy(id = "client-country")
	WebElement country;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[4]/div/button")
	WebElement saveBUtton;

	
	@FindBy(xpath="/html/body/section/div/div/div[2]/table/tbody/tr[3]/td")
	WebElement displayedName;

	public void setDivision(String div) {
		select = new Select(division);

		select.selectByVisibleText(div);
	}

	public void addBranch(String value) {

		select = new Select(clientbranch);
		select.selectByVisibleText(value);
	}

	public void setMasterDocument(String masterdoc) {

		select = new Select(masterDocument);
		select.selectByVisibleText(masterdoc);
	}

	public void setInvoiceOrder(String invoice) {
		select = new Select(invoiceOrder);
		select.selectByVisibleText(invoice);
	}

	public void setInvoiceContract(String contract) {
		invoiceContact.sendKeys(contract);
	}

	public void setDelivery(String delivery) {
		select = new Select(invoiceDelivery);
		select.selectByVisibleText(delivery);
	}

	public void setClientName(String name) {
		clientName.sendKeys(name);
	}

	public void setPhone(String ph) {
		phone.clear();
		phone.sendKeys(ph);
	}

	public void setSettleDAys(String days) {
		settleDAys.sendKeys(days);
	}

	public void setFax(String clientfax) {
		fax.sendKeys(clientfax);
	}

	public void setemail(String clientemail) {
		email.sendKeys(clientemail);
	}

	public void setAddress(String addr) {
		clientAddr.sendKeys(addr);
	}

	public void setCompanyREg(String reg) {
		compREg.sendKeys(reg);
	}

	public void setPostCode(String code) {
		postCOde.sendKeys(code);
	}

	public void setcountry(String clientCountry) {
		country.clear();
		country.sendKeys(clientCountry);
	}

	public void setVatRatet(String vat) {

		select = new Select(vatRate);
		select.selectByVisibleText(vat);
	}

	public void setSave() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", saveBUtton);

		saveBUtton.click();
	}

	public CreateClientPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String profileName() {
		return genUtility.getText(displayedName);
	}

}
