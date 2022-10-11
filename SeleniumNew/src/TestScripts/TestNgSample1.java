package TestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNgSample1 {
	@BeforeTest
  public void driverPath() {
	  System.setProperty("webdriver.chrome.driver",
				"E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();// initializing chrome
	  driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		
  }
  
  @Test
  public void methodOne()
  {
    	WebDriver driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	  driver.findElement(By.id("single-input-field")).sendKeys("Hai Lekshmi");
	  
	  driver.findElement(By.className("btn-primary")).click();
  }
  @Test
  public void methodTwo()
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	  driver.findElement(By.id("value-a")).sendKeys("5");
	  driver.findElement(By.id("value-b")).sendKeys("7");
	  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div/div[2]/form/button")).click();
  }
  
  
  
  @AfterMethod
  public void afterMethod() {
	  WebDriver driver = new ChromeDriver();
	  driver.close();
	  
  }

}
