package TestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestNgSample1 {
	
	public WebDriver driver;
	
	@BeforeTest
  public void driverPath() {
	  System.setProperty("webdriver.chrome.driver",
				"E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
	   driver = new ChromeDriver();// initializing chrome
	  driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		
  }
  
  @Test
  public void methodOne() throws Exception
  {
    	
	  driver.findElement(By.id("single-input-field")).sendKeys("Hai Lekshmi");
	  
	  driver.findElement(By.className("btn-primary")).click();
	  Thread.sleep(2000);
  }
  @Test
  public void methodTwo() throws Exception
  {
	 
	  driver.findElement(By.id("value-a")).sendKeys("5");
	  driver.findElement(By.id("value-b")).sendKeys("7");
	  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div/div[2]/form/button")).click();
	  Thread.sleep(2000);
  }
  
  
  
  @AfterTest
  public void afterMethod() {
	 
	  driver.close();
	  
  }

}
