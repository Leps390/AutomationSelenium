package TestScripts;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "E:\\OBSQURA\\Selenium class\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();//initializing chrome
		driver.get("https://www.google.com/");
	}

}
