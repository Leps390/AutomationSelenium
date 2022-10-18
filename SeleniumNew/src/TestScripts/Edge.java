package TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.edge.driver", "E:\\OBSQURA\\Selenium class\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver= new EdgeDriver();
		driver.get("https://www.google.com/");
		

	}

}
