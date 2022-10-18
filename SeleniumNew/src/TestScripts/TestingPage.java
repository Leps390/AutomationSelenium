package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingPage {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");

		 //<input type="text" class="form-control" id="single-input-field" placeholder="Message">
		  
		  driver.findElement(By.id("single-input-field")).sendKeys("Hai Lekshmi");
		  //<button type="button" class="btn btn-primary" id="button-one">ShowMessage</button> 
		  driver.findElement(By.className("btn-primary")).click();
		  
		  //<input type="text" class="form-control" id="value-a" placeholder="Enter Value">
		  driver.findElement(By.id("value-a")).sendKeys("5");
		  
		 //<input type="text" class="form-control" id="value-b"placeholder="Enter Value">
		  
		  driver.findElement(By.id("value-b")).sendKeys("7");
		  
		 
		  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div/div[2]/form/button")).click();
		 
		 //driver.findElement(By.linkText("Input Form")); Thread.sleep(3000);
		 // driver.findElement(By.partialLinkText("Input Form"));
		 

		
		
		 
	}

}
