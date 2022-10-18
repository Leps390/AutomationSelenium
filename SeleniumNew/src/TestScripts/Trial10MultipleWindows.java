package TestScripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial10MultipleWindows {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://selenium.obsqurazone.com/window-popup.php");
		//driver.switchTo().window("");
	   //	driver.getWindowHandle();
		//driver.getWindowHandles();
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[1]/div/div[2]/a")).click();
		Set<String> child=driver.getWindowHandles();
		Iterator<String> I1= child.iterator();
		
		while(I1.hasNext())
		{

		   String child_window=I1.next();
		   System.out.println(child_window);

		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		
		Thread.sleep(2000);
		driver.close();
		}
	}

	}
}
