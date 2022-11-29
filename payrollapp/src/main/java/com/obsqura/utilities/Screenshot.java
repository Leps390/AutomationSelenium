package com.obsqura.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	public void getCaptureScreenshot(WebDriver driver, String name) throws IOException {
	TakesScreenshot scrShot = (TakesScreenshot) driver;
	File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
	
	File file = new File("\\target\\Capture\\ScreenShots");
	if (!file.exists()) {
		file.mkdirs();
	}

	File result = new File("\\target\\Capture\\ScreenShots"+ name + ".png");
	FileHandler.copy(screenShot, result);

}
}