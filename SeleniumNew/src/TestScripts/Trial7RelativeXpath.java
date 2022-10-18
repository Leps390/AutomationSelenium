package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial7RelativeXpath {

	public static void main(String[] args)
	
	{
		
		System.setProperty("webdriver.chrome.driver","E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		//relative xpath

				//driver.findElement(By.xpath("//label[@for='inputEmail4']"));//for Enter msg text
				
				driver.findElement(By.xpath("//input[@type='text' or @class='form-control']")).sendKeys("heooloo");
			
				driver.findElement(By.xpath("//img[@src='images/logo.png']"));
				driver.findElement(By.xpath("//button[@type='button' and @id='button-one']")).click();
				
				//driver.findElement(By.xpath("//input[@placeholder='Message'")).sendKeys("helllooooo")	;
				//driver.findElement(By.xpath("//td[@text()='Show Message']"));
				
				driver.findElement(By.xpath("//div[@class='my-2' and @id='message-one']"));
	
				driver.findElement(By.xpath("//input[@id='value-a']")).sendKeys("5");
				
				
			    driver.findElement(By.xpath("//input[@id='value-b']")).sendKeys("7");
			
				driver.findElement(By.xpath("//button[@class='btn btn-primary' and @id='button-two']")).click();
				

				driver.findElement(By.xpath("//a[@href='check-box-demo.php']")).click();
				driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
				
				driver.findElement(By.xpath("//*[contains(@id,'gridCheck')]")).click()	;	
				driver.findElement(By.xpath("//input[starts-with(@id,'check-box-o')]")).click();
	}

}
