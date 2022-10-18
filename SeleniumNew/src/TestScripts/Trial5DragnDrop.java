package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Trial5DragnDrop 
{

	public static void main(String[] args) 
	{
	
		System.setProperty("webdriver.chrome.driver","E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		
		//WebElement element=driver.findElement(By.xpath("//*[@id=\"todrag\"]/span[1]"));
		WebElement element=driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
		WebElement elem=driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
		
		Actions action=new Actions(driver);
		//action.moveToElement(elem).release().build().perform();
		action.clickAndHold(element).build().perform();//selenium 4
		action.release(elem).build().perform();
		
		//WebElement trialAction=driver.findElement(By.xpath(null));
		//action.doubleClick(trialAction).perform();
		
		
		//WebElement elem=driver.findElement(By.xpath("//*[@id=\"mydropzone\"]"));
		//action.moveToElement(element).clickAndHold().build().perform();
		
		
		//action.moveToElement(elem).release().build().perform();
		//action.clickAndHold(element).build().perform();//selenium 4
		//action.release(elem).build().perform();////selenium 4


	}

}
