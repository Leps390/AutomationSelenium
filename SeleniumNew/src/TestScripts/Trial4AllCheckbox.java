package TestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trial4AllCheckbox {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",
				"E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		//select one check box first.now select all the checkbox in one go
		WebElement chekBox=driver.findElement(By.id("gridCheck"));
		chekBox.click();
		boolean selected=chekBox.isSelected();
		System.out.println(selected);
		
		List<WebElement> AllCheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
	    //System.out.println("Number of Check boxes : "+ Integer.toString(AllCheckBoxes.size()));
	         
	    for(WebElement ele:AllCheckBoxes)
	    {
	    	
	        ele.click();
	    }
	    System.out.println("All check boxes have been checked");
		

	}

}
