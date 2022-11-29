package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewlyAddedClientPage {
	WebDriver driver;
	@FindBy(xpath = "/html/body/header/div[3]/div/div/div[2]/ul/li[3]")
	WebElement cName;

	public NewlyAddedClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String displayName() {
		String name = cName.getText();
		System.out.println("name of client is " + name);
		return name;

	}

}
