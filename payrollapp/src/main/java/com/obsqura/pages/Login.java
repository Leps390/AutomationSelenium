package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.GenericUtility;
import com.obsqura.utilities.WaitUtility;

public class Login {
WebDriver driver;
GenericUtility genUtil=new GenericUtility()  ;
WaitUtility waitUtility= new WaitUtility();

	@FindBy(id = "loginform-username")
	
	WebElement userName;
	
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[2]/input")
	WebElement password;
	@FindBy(id="loginform-rememberme")
	WebElement checkbox;
	
	@FindBy(name = "login-button")
	WebElement loginButton;
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[2]/p")
	WebElement invalidCredentials;
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[4]/a")
	WebElement passwordReset;
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[1]/p")
	WebElement blankUser;
	@FindBy(xpath="/html/body/section/div/div/div[3]/div/form/div[2]/p")
	WebElement blankPassword;
	public void setUserName(String uname) {
		userName.sendKeys(uname);
		
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
		
	}
	public void  clickButton() {
		loginButton.click();
		
		
	}
	
	public boolean isCheckBoxSelected() {
		
		boolean a= genUtil.checkBoxSelected(checkbox);
		System.out.println(a);
		return a;
	}
	
	
	public Login(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void loginToPage(String uname,String pwd){

        this.setUserName(uname);

        this.setPassword(pwd);

        this.clickButton();        
    }
	
	public String InvalidCredentials() {
		waitUtility.hardWait(driver);
		//waitUtility.waitforanElement(invalidCredentials, driver);
			return invalidCredentials.getText(); 
		
	}
	
	public void isResetClickable() {
		passwordReset.click();
	}
	
	public String getUserBlankMsg() {
		waitUtility.hardWait(driver);
		return blankUser.getText();
	}
	public String getPasswordBlankMsg() {
		waitUtility.hardWait(driver);
		return blankPassword.getText();
	}
	
}
