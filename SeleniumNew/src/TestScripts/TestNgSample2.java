package TestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class TestNgSample2 {
	@BeforeMethod
	public void beforeTest() {
	System.out.println("Prerequisite");
		
	}
  @Test
  public void sampleMethodOne()
  {
	  //System.out.println("Prerequisite");
	  System.out.println("One ");
  }
  
  @Test
  public void sampleMethodTwo()
  {
	  //System.out.println("Prerequisite");
	  System.out.println("two ");
  }
  @Test
  public void sampleMethodThree()
  {
	// System.out.println("Prerequisite");
	  System.out.println("Three ");
  }
  @AfterClass
  public void afterClass() {
	  
	  System.out.println("After class");
  }

}
