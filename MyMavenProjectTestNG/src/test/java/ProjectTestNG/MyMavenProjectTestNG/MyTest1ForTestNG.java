package ProjectTestNG.MyMavenProjectTestNG;




import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;





public class MyTest1ForTestNG 
{
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculateOneDayCostClass()
	{
		EmployeeOfCompany testInstance = new EmployeeOfCompany(); // See the @BeforClass
		testInstance.calculateOneDayCost(0, 22);
		testInstance.calculateOneDayCost(-1, 22);
	}
		
	@Test
	public void testCalculateOneDayCost() 
	{
		EmployeeOfCompany testInstance = new EmployeeOfCompany();	// See the @BeforClass
		assertEquals(102.2727, testInstance.calculateOneDayCost(2250, 22), 0.02); // 4 is a number of digits after the comma
		assertEquals("2200/22 must be 100.00", 100.00,
				testInstance.calculateOneDayCost(2200, 22), 2);
	}
		
	
	
	@Test
	public void testCalculateExperianceCoeffIfExpirianceMore10Years()
	{		
		AssertJUnit.assertEquals(
				"Expiriance coefficient for 9 years of expiriance should be 0.9",
				0.9, testInstance.calculateExperianceCoeff(9), 2);
		AssertJUnit.assertEquals(
				"Expiriance coefficient for 10 years of expiriance should be 0.9",
				0.9, testInstance.calculateExperianceCoeff(10), 2);
	}

	@Test
	public void testCalculateExperianceCoeffIfExpirianceLess9Years()
	{		
		AssertJUnit.assertEquals(
				"Expiriance coefficient for 1 years of expiriance should be 0.1",
				0.1, testInstance.calculateExperianceCoeff(1), 2);
		AssertJUnit.assertEquals(
				"Expiriance coefficient for 8 years of expiriance should be 0.8",
				0.8, testInstance.calculateExperianceCoeff(8), 2);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculateExperianceCoeffClass()
	{		
		testInstance.calculateExperianceCoeff(0);
		testInstance.calculateExperianceCoeff(-1);
	}
	
	
	@Test
	public void testCalculeteBonus()
	{
		// Will use:   assertEquals(double, double, tolerance)  - if tolerance 0.2 , so e.g. 14.5 -> 14.4 & 14.6  (0.2 means +-0.1)		
		AssertJUnit.assertEquals(
				"Bonus for Employee if SalaryRate 2250 and Expieiance 5 years should be 562.5! -> ",
				562.5, testInstance.calculeteBonus(2250.0, 5), 0.0);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculeteBonusClass()
	{		
		testInstance.calculeteBonus(0, 5);
		testInstance.calculeteBonus(-1, 5);
		testInstance.calculeteBonus(0, -1);
		testInstance.calculeteBonus(-1, -1);
	}
	
	
	@Test
	public void testCountRealWorkigDays()
	{		
		AssertJUnit.assertEquals(
				"Real working days should be 22 if the Working days in month 22, Sickdays 0, Vacations days 0 and Missed days 0",
				22, testInstance.countRealWorkigDays(22, 0, 0, 0));
		AssertJUnit.assertEquals(
				"Real working days should be 21 if the Working days in month 22, Sickdays 1, Vacations days 0 and Missed days 0",
				21, testInstance.countRealWorkigDays(22, 1, 0, 0));
		AssertJUnit.assertEquals(
				"Real working days should be 21 if the Working days in month 22, Sickdays 0, Vacations days 1 and Missed days 0",
				21, testInstance.countRealWorkigDays(22, 0, 1, 0));
		AssertJUnit.assertEquals(
				"Real working days should be 21 if the Working days in month 22, Sickdays 0, Vacations days 0 and Missed days 1",
				21, testInstance.countRealWorkigDays(22, 0, 0, 1));
		AssertJUnit.assertEquals(
				"Real working days should be 20 if the Working days in month 22, Sickdays 1, Vacations days 1 and Missed days 0",
				20, testInstance.countRealWorkigDays(22, 1, 1, 0));
		AssertJUnit.assertEquals(
				"Real working days should be 20 if the Working days in month 22, Sickdays 1, Vacations days 0 and Missed days 1",
				20, testInstance.countRealWorkigDays(22, 1, 0, 1));
		AssertJUnit.assertEquals(
				"Real working days should be 20 if the Working days in month 22, Sickdays 0, Vacations days 1 and Missed days 1",
				20, testInstance.countRealWorkigDays(22, 0, 1, 1));
		AssertJUnit.assertEquals(
				"Real working days should be 19 if the Working days in month 22, Sickdays 1, Vacations days 1 and Missed days 1",
				19, testInstance.countRealWorkigDays(22, 1, 1, 1));
		AssertJUnit.assertEquals(
				"Real working days should be 0 if the Working days in month 22, Sickdays 10, Vacations days 10 and Missed days 2",
				0, testInstance.countRealWorkigDays(22, 10, 10, 2));
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testExceptionIsThrownInCountRealWorkigDaysClass()
	{		
		testInstance.countRealWorkigDays(0, 0, 0, 0);
		testInstance.countRealWorkigDays(24, 0, 0, 0);
		testInstance.countRealWorkigDays(20, -1, 0, 0);
		testInstance.countRealWorkigDays(20, 0, -1, 0);
		testInstance.countRealWorkigDays(20, 0, 0, -1);
		testInstance.countRealWorkigDays(20, 10, 9, 1);
	}
	
}
