package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial2 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",
				"E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		
		String path = System.getProperty("user.dir"); 
		System.out.println(path);
		
		
		// <button type="button" class="btn btn-primary" id="button-one">Show Message</button>
				String button = driver.findElement(By.id("button-one")).getText();
				System.out.println(button);
				String title = driver.getTitle();
				System.out.println("Title of the page is " + title);
				// returns Title of the webpage
				WebElement a = driver.findElement(By.id("value-a"));
				a.sendKeys("Enter element A");

	}

}
