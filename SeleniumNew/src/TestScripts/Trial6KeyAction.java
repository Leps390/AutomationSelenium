package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial6KeyAction {

	public static void main(String[] args) throws InterruptedException 
	{

		System.setProperty("webdriver.chrome.driver","E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		
		Thread.sleep(2000);
		//keyboard actions like enter,tab etc
		
		WebElement elem2=driver.findElement(By.xpath("//*[@id=\"single-input-field\"]"));
		elem2.sendKeys(Keys.ENTER);//to enter tab in an element
		
		WebElement elem=driver.findElement(By.xpath("//*[@id=\"single-input-field\"]"));
		elem.sendKeys(Keys.TAB);//to enter tab in an element
		//elem.sendKeys(Keys.ADD);
		//elem.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		WebElement elem1=driver.findElement(By.xpath("//*[@id=\"value-a\"]"));
		elem1.sendKeys(Keys.TAB);//to enter tab in an element
		
		
	
		
		

	}

}
