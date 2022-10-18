package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial8AlertsNwindows {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		
		//Browser alert
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[@class='btn btn-warning']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Hai Welcome");
		driver.switchTo().alert().accept();
		
		driver.get("https://selenium.obsqurazone.com/bootstrap-alert.php");
		driver.findElement(By.xpath("//button[@id='autoclosable-btn-success']")).click();
	}

}
