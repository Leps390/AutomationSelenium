package TestScripts;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Trial {

	
	static String browser;
	public void checkBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();//initializing chrome
			driver.get("https://www.google.com/");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{

			System.setProperty("webdriver.gecko.driver", "E:\\OBSQURA\\Selenium class\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			WebDriver driver= new FirefoxDriver();//initializing chrome
			driver.get("https://www.google.com/");
		}
		else if(browser.equalsIgnoreCase("edge")) 
		{

			System.setProperty("webdriver.edge.driver", "E:\\OBSQURA\\Selenium class\\edgedriver_win64\\msedgedriver.exe");

			WebDriver driver= new EdgeDriver();
			driver.get("https://www.google.com/");
			
		}
	}
	
	public static void main(String[] args) 
	{
		Trial t=new Trial();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Browser");
		browser=scan.nextLine();
		t.checkBrowser(browser);
	}
}
