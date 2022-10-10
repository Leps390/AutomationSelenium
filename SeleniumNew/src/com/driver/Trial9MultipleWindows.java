package com.driver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial9MultipleWindows {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://demoqa.com/browser-windows");
		//driver.switchTo().window("");
	//	driver.getWindowHandle();
		//driver.getWindowHandles();
		
		
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		driver.findElement(By.id("tabButton")).click();
		
		Thread.sleep(2000);
		Set<String>s1=driver.getWindowHandles();

		Iterator<String> I1= s1.iterator();

		while(I1.hasNext())
		{

		   String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		System.out.println(driver.switchTo().window(child_window).getTitle());

		driver.close();
		}

		}
		// once all pop up closed now switch to parent window
		driver.switchTo().window(parent);

		
		
		
		
	}

}
