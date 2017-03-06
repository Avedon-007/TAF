package ProjectTestNG.MyMavenProjectTestNG;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOfGroups1TestNG 
{
	static EmployeeOfCompany testInstance;
	@BeforeClass
	public static void initializeInstanceOfClass()
	{
		testInstance = new EmployeeOfCompany();
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculateOneDayCostClass()
	{
		testInstance.calculateOneDayCost(0, 22);
		testInstance.calculateOneDayCost(-1, 22);
	}
		
	@Test(dependsOnMethods = {"testExceptionIsThrownInCalculateOneDayCostClass"})
	public void testCalculateOneDayCost() 
	{		
		assertEquals(102.2727, testInstance.calculateOneDayCost(2250, 22), 0.02);
		assertEquals("2200/22 must be 100.00", 100.00,
				testInstance.calculateOneDayCost(2200, 22), 2);
	}		
		
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculateExperianceCoeffClass()
	{		
		testInstance.calculateExperianceCoeff(-1);		
	}
	
	@Test(dependsOnMethods = {"testExceptionIsThrownInCalculateExperianceCoeffClass"})
	public void testCalculateExperianceCoeffIfExpirianceMore10Years()
	{		
		assertEquals(
				"Expiriance coefficient for 9 years of expiriance should be 0.9",
				0.9, testInstance.calculateExperianceCoeff(9), 2);
		assertEquals(
				"Expiriance coefficient for 10 years of expiriance should be 0.9",
				0.9, testInstance.calculateExperianceCoeff(10), 2);
	}

	@Test(dependsOnMethods = {"testExceptionIsThrownInCalculateExperianceCoeffClass"})
	public void testCalculateExperianceCoeffIfExpirianceLess9Years()
	{		
		assertEquals(
				"Expiriance coefficient for 1 years of expiriance should be 0.1",
				0.1, testInstance.calculateExperianceCoeff(1), 2);
		assertEquals(
				"Expiriance coefficient for 8 years of expiriance should be 0.8",
				0.8, testInstance.calculateExperianceCoeff(8), 2);
	}
	
	
	
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculeteBonusClass()
	{		
		testInstance.calculeteBonus(0, 5);
		testInstance.calculeteBonus(-1, 5);
		testInstance.calculeteBonus(0, -1);
		testInstance.calculeteBonus(-1, -1);
	}		
	
	@Test(dependsOnMethods = {"testExceptionIsThrownInCalculeteBonusClass", "testCalculateExperianceCoeffIfExpirianceLess9Years", "testCalculateExperianceCoeffIfExpirianceMore10Years"})
	public void testCalculeteBonus()
	{
		// Will use:   assertEquals(double, double, tolerance)  - if tolerance 0.2 , so e.g. 14.5 -> 14.4 & 14.6  (0.2 means +-0.1)		
		assertEquals(
				"Bonus for Employee if SalaryRate 2250 and Expieiance 5 years should be 562.5! -> ",
				562.5, testInstance.calculeteBonus(2250.0, 5), 0.0);
	}
	
	
	
}
