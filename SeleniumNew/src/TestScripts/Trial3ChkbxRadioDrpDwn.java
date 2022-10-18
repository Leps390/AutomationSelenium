package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Trial3ChkbxRadioDrpDwn {

	public static void main(String[] args) throws InterruptedException
	{
		
		//String path = System.getProperty("user.dir"); 
		//System.out.println(path); 
		//System.setProperty("webdriver.chrome.driver",path+"\\resources\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver",
				"E:\\OBSQURA\\Selenium class\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// initializing chrome
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		
		 driver.findElement(By.id("single-input-field")).sendKeys("Hai Lekshmi");
		 driver.findElement(By.className("btn-primary")).click();
		 driver.findElement(By.id("value-a")).sendKeys("5");
		 driver.findElement(By.id("value-b")).sendKeys("7");
		 driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div/div[2]/form/button")).click();
		 String title=driver.getTitle();
		 System.out.println("Title of the page is "+title);
		// <button type="button" class="btn btn-primary" id="button-one">Show Message</button>
		 String buttonName=driver.findElement(By.id("button-one")).getText();
		 System.out.println("button is "+buttonName);
		 //<div id="message-one" class="my-2">Your Message :</div>
		String yourName= driver.findElement(By.id("message-one")).getText();
		System.out.println(yourName);
		
		//List<>e=driver.findElements(By.id(yourName));
		
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		
		//checkbox
		//<label class="form-check-label" for="gridCheck">Click on this check box</label>
		WebElement chekBox=driver.findElement(By.id("gridCheck"));//.isSelected();
		chekBox.click();
		boolean selected=chekBox.isSelected();
		System.out.println(selected);
		
		//radio button
		//<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="Female">
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		WebElement radioBUtton=driver.findElement(By.id("inlineRadio2"));
		radioBUtton.click();
		boolean sele=radioBUtton.isSelected();
		System.out.println(sele);
		 
		//drop down
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		WebElement select	=driver.findElement(By.id("single-input-field"));
		Select s=new Select( select);
		//different ways to select option in drop down
		s.selectByIndex(1);
		Thread.sleep(2000);
		s.selectByValue("Yellow");//toselect by value
		Thread.sleep(2000);
		s.selectByVisibleText("Green");//--to select by visible text
		
		//to select multiple option from dop down
		WebElement dropdown = driver.findElement(By.id("multi-select-field"));
		Select select1 = new Select(dropdown);
		select1.selectByVisibleText("Yellow");
		select1.selectByValue("Red");

	}

}
