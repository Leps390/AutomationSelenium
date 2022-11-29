package com.obsqura.utilities;

import java.util.Random;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebElement webelement;
	public static String randomStringGenerator() {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 7;
		for (int i = 0; i < length; i++) {

			int index = random.nextInt(alphabet.length());

			char randomChar = alphabet.charAt(index);

			sb.append(randomChar);
		}

		String randomString = sb.toString();
		System.out.println("Random String is: " + randomString);
		return randomString;

		
		
		
	}
	
	public String AlertHandleing(WebDriver driver) {
		String alertMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alertMsg;
	}
	

	public static int randomIntegerGenerator() {
		// TODO Auto-generated method stub
		int randomNum=0,random=0;
		String s="";
		for (int i = 0; i < 10; i++) {
			randomNum	 = RandomUtils.nextInt(1, 7);
			 s=randomNum + " ";
			
			 }
		random=Integer.valueOf(s);
		return random ;
	}
	
	
	



}
