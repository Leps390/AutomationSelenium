package com.obsqura.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public void waitforanElement(WebElement element, WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}
	public void waitImplicit(long timeout, WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	 }

	public void hardWait(WebDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	 
	public void waitforVisibility(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForAnAlert(WebDriver driver) {
		 WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(10));
		 waitAlert.until(ExpectedConditions.alertIsPresent());
	 }

}
