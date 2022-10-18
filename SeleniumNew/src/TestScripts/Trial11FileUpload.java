package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial11FileUpload {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://demo.guru99.com/test/upload/");
		
		WebElement upload_file = driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]"));

		upload_file.sendKeys("C:\\Users\\ACER\\OneDrive\\Desktop\\rose.jpg");
		driver.findElement(By.xpath("//*[@id=\"terms\"]")).click();
		driver.findElement(By.id("submitbutton"));
		//driver.findElement(By.xpath("//*[@id=\"submitbutton\"]"));

	}

}
