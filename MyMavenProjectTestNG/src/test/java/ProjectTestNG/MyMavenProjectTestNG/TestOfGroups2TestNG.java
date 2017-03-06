package ProjectTestNG.MyMavenProjectTestNG;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOfGroups2TestNG 
{
	static EmployeeOfCompany testInstance;
	@BeforeClass
	public static void initializeInstanceOfClass()
	{
		testInstance = new EmployeeOfCompany();
	}
	
	
	@Test(expectedExceptions = IllegalArgumentException.class, groups = {"exepGroup"})   // add test to Group 
	public void testExceptionIsThrownInCalculateOneDayCostClass()
	{
		testInstance.calculateOneDayCost(0, 22);
		testInstance.calculateOneDayCost(-1, 22);
	}
		
	@Test(dependsOnGroups = {"exepGroup.*"})		// depends on Group
	public void testCalculateOneDayCost() 
	{		
		assertEquals(102.2727, testInstance.calculateOneDayCost(2250, 22), 0.02);
		assertEquals("2200/22 must be 100.00", 100.00,
				testInstance.calculateOneDayCost(2200, 22), 2);
	}		
	
	
	
	
	
}
