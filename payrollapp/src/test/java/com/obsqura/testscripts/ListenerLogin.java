package com.obsqura.testscripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenerLogin   implements ITestListener /* extendsTestListenerAdapter*/  {
	WebDriver driver;
	
	ExtentReports extent;
	 ExtentTest test;

	
	
	/*
	 * public void report() { extent = new ExtentReports(); ExtentSparkReporter
	 * spark = new ExtentSparkReporter("target/Spark/Spark.html"); //new
	 * ExtentSparkReporter("target/Spark/Spark.html"); extent.attachReporter(spark);
	 * extent.setSystemInfo("user", "LEkshmi");
	 * spark.config().setDocumentTitle("Payroll Test Reports");
	 * spark.config().setReportName("Results of functional TEsts");
	 * spark.config().setTheme(Theme.DARK); }
	 */
@Test
public void onTestStart(ITestResult result) {
	
	/*
	 * Date date = new Date(); SimpleDateFormat formatter = new
	 * SimpleDateFormat("ddMMyyyy_hhmmss"); String strDate = formatter.format(date);
	 */
	
	  extent = new ExtentReports(); 
	  ExtentSparkReporter spark = new
	  ExtentSparkReporter("target/Spark/Spark.html"); 
	  extent.attachReporter(spark);
	  extent.setSystemInfo("user", "LEkshmi");
	  spark.config().setDocumentTitle("Payroll Test Reports");
	  spark.config().setReportName("Results of functional TEsts");
	  spark.config().setTheme(Theme.DARK);
	 
	//extent.flush();
}

@Test
public void onTestSuccess(ITestResult result) {
	
	
	test=extent.createTest("from reports" +result.getName());
	test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	System.out.println("The success test is (from listner class)"+result.getName());
	//extent.flush();
	//extent.endTest();
}

@Test
public void onTestFailure(ITestResult result) {
	
	test=extent.createTest("from reports" +result.getName());
	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	/*
	 * if(result.getStatus()==ITestResult.FAILURE) { test.log(Status.FAIL,
	 * "TEST CASE FAILED IS" +result.getName()); test.log(Status.FAIL,
	 * "TEST CASE FAILED IS" +result.getThrowable()); try { // Create refernce of
	 * TakesScreenshot TakesScreenshot ts=(TakesScreenshot)driver;
	 * 
	 * // Call method to capture screenshot File
	 * source=ts.getScreenshotAs(OutputType.FILE);
	 * 
	 * 
	 * try{ FileHandler.copy(source, new
	 * File("./Screenshots/"+result.getName()+".png"));
	 * System.out.println("Screenshot taken"); } finally {
	 * System.out.println("Scernshot caputured"); } } catch (Exception e) {
	 * System.out.println("Exception while taking screenshot "+e.getMessage()); } }
	 */
		String screenshotPath=System.getProperty("user.dir")+"\\Scrrenshots\\"+result.getName()+".png";
		File f =new File(screenshotPath);
		if(f.exists()) {
			try {
				test.fail("Screenshot is below"+test.addScreenCaptureFromPath(screenshotPath));
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	

	
	System.out.println("The failed test is (from listner class)"+result.getName());
	//extent.flush();
	
}

@Test
public void onTestSkipped(ITestResult result) {
	test=extent.createTest("from reports" +result.getName());
	test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
	System.out.println("The SKIP test is (from listner class)"+result.getName());
	
	//extent.flush();
	
	
}

@Test
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	test=extent.createTest("from reports" +result.getName());
	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.AMBER));
	System.out.println("The success test is (from listner class)"+result.getName());
	//extent.flush();
}



@Test
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
	
}
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}
@AfterSuite
public void tear()
{
    extent.flush();
}
}
