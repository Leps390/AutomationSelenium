package TestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgSampleTest 
{
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
  @Test
  public void sampleMethodFour()
  {
	 // System.out.println("Prerequisite");
	  System.out.println("Four ");
  }
}
