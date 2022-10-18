package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial1 {

	public static void main(String[] args) throws Exception 
	{
		

String path = System.getProperty("user.dir"); 
System.out.println(path);
System.setProperty("webdriver.chrome.driver",path+"\\src\\resources\\chromedriver.exe");

		//System.setProperty("webdriver.chrome.driver",
			//	"E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		
		// Navigation commands
		
		  driver.navigate().to("https://demo.guru99.com/test/newtours/");
		  driver.navigate().back(); 
		  Thread.sleep(3000);
		   driver.navigate().forward();
		  
		  Thread.sleep(3000); 
		  driver.navigate().refresh();

	}

}
