package com.obsqura.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.WaitUtility;

public class ClientPage {
	GenericUtility genericUtility=new GenericUtility();
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	@FindBy(xpath = "//*[@id=\"clientsearch-client_name\"]")
	WebElement clientName;
	@FindBy(id = "clientsearch-id")
	WebElement clientId;
	@FindBy(xpath="/html/body/header/div[3]/div/div/div[1]/h1")
    WebElement tabName;
	@FindBy(xpath = "//*[@id=\"w0\"]/div[3]/button[1]")
	WebElement searchButton;
	//@FindBy(linkText = "Reset")
    @FindBy(className = "btn-default")
	WebElement resetButton;

	@FindBy(xpath = "/html/body/header/div[1]/div/div[2]/div[1]/ul/li[2]")
	WebElement CarolThomas;
	@FindBy(xpath = "/html/body/header/div[1]/div/div[2]/div[1]/ul/li[2]/ul/div/li[2]/a")
	WebElement logOut;

	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]")
	WebElement savedClientName;

	@FindBy(xpath = "//a[@href='/payrollapp/client/view?id=1']")
	WebElement eyeButton;

	@FindBy(linkText = "Create Client")
	WebElement createClientTab;

	@FindBy(linkText = "Clients")
	WebElement Clients;
	@FindBy(xpath = "//*[@id=\"w1\"]/table/tbody/tr/td[1]")
	WebElement displayID;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/table/tbody/tr/td/div")
	WebElement errorMsg;

	public ClientPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setClientName(String client) {
		clientName.sendKeys(client);

	}

	public void setClientId(String id) {
		clientId.sendKeys(String.valueOf(id));
	}

	public void setSearch() {
		searchButton.sendKeys(Keys.RETURN);
	}

	public void setReset() {
		resetButton.sendKeys(Keys.RETURN);
	}

	public void searchByClientName(String client) throws Exception {
		this.setClientName(client);
		waitutility.hardWait(driver);
		this.setSearch();

	}

	public void resetByClientName() throws Exception {
		ClientPage clientPage = new ClientPage(driver);
		//waitutility.hardWait(driver);

		clientPage.setReset();

	}

	public String getClientName() {
		waitutility.hardWait(driver);
		String cName = clientName.getText();
		return cName;
	}

	public void searchByClientID(String id) throws InterruptedException {

		this.setClientId(String.valueOf(id));
		waitutility.hardWait(driver);

		this.setSearch();

	}

	public void resetByClientID() throws InterruptedException {

		ClientPage clientPage = new ClientPage(driver);
		waitutility.hardWait(driver);
		clientPage.setReset();
		this.setReset();

	}

	public String getResetClientID() {
		String cID = clientId.getText();
		return cID;
	}
	
	public String displayTabName() {
		return (genericUtility.getText(tabName));

	}


	public void setEyeButton() {

		eyeButton.sendKeys(Keys.RETURN);
	}

	public void setcreateClientTab() {

		createClientTab.sendKeys(Keys.RETURN);
	}

	public void setClients() {

		Clients.sendKeys(Keys.RETURN);
	}

	public String getSearchedClient() {
		String name = savedClientName.getText();
		return name;
	}

	public String getErrorMsg() {
		String error = errorMsg.getText();
		return error;
	}

	public String getdisplayId() {

		waitutility.waitImplicit(30, driver);

		String s = displayID.getText();
		System.out.println("inside display text method" + s);
		return s;

	}

	public void setLogout() {
		CarolThomas.click();
		logOut.click();
	}

}
