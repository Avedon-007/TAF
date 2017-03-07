package MyMavenLesson5.MyMavenProject;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


//@RunWith(Parameterized.class)
public class TestMyTest1Params 
{
	private double salaryRate;
	private int generalWorkigDaysInMoth;	
	
	private static List <double[]> dataSet = new ArrayList<double[]>();
	private static EmployeeOfCompany testInstance;
	
	@BeforeClass
	public static void initializeInstanceOfClass()
	{
		testInstance = new EmployeeOfCompany();		
		
		dataSet.add(new double[] {102.2727, 2250.0, 22.0, 0.02});
		dataSet.add(new double[] {100.00, 2200.0, 22.0, 0.0});
		
	}
	
	
	
		
//	public TestMyTest1Params(double salaryRate, int generalWorkigDaysInMoth)
//	{
//		this.salaryRate = salaryRate;
//		this.generalWorkigDaysInMoth = generalWorkigDaysInMoth;
//	}
	
//	@Parameterized.Parameters
//	public static Collection forTestExceptionIsThrownInCalculateOneDayCostClass()
//	{
//		return Arrays.asList(new Object[][]{ {0, 22}, {-1, 22} });
//	}
//		
//	// Two methods of handling Exceptions: @Rule and Annotations
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
//	
////	@Test
////	public void testExceptionIsThrownInCalculateOneDayCostClass()
////	{
////		thrown.expect(IllegalArgumentException.class);
////		testInstance.calculateOneDayCost(salaryRate, generalWorkigDaysInMoth);		
////	}	
	
	@Test
	public void testCalculateOneDayCost() 
	{
		for (double[] buferArry : dataSet)
		{				
				assertEquals("2250/22 must be 102.2727", buferArry[0],
				testInstance.calculateOneDayCost(buferArry[1], buferArry[2]), buferArry[3]);
		}
	}
			
	
	@Test
	public void testCalculateExperianceCoeffIfExpirianceMore10Years()
	{		
		assertEquals(
				"Expiriance coefficient for 9 years of expiriance should be 0.9",
				0.9, testInstance.calculateExperianceCoeff(9), 0);		//tolerance 0 (use tolerance coz DOUBLE Method)
	}

	@Test
	public void testCalculateExperianceCoeffIfExpirianceLess9Years()
	{		
		assertEquals(
				"Expiriance coefficient for 1 years of expiriance should be 0.1",
				0.1, testInstance.calculateExperianceCoeff(1), 0);
		assertEquals(
				"Expiriance coefficient for 8 years of expiriance should be 0.8",
				0.8, testInstance.calculateExperianceCoeff(8), 0);
	}
	
	
	
	
	
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculateExperianceCoeffClass()
	{		
		testInstance.calculateExperianceCoeff(-1);		
	}
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testCalculeteBonus()
	{
		// Will use:   assertEquals(double, double, tolerance)  - if tolerance 0.2 , so e.g. 14.5 -> 14.4 & 14.6  (0.2 means +-0.1)		
		assertEquals(
				"Bonus for Employee if SalaryRate 2250 and Expieiance 5 years should be 562.5! -> ",
				562.5, testInstance.calculeteBonus(2250.0, 5), 0.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
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
		assertEquals(
				"Real working days should be 22 if the Working days in month 22, Sickdays 0, Vacations days 0 and Missed days 0",
				22, testInstance.countRealWorkigDays(22, 0, 0, 0));
		assertEquals(
				"Real working days should be 21 if the Working days in month 22, Sickdays 1, Vacations days 0 and Missed days 0",
				21, testInstance.countRealWorkigDays(22, 1, 0, 0));
		assertEquals(
				"Real working days should be 21 if the Working days in month 22, Sickdays 0, Vacations days 1 and Missed days 0",
				21, testInstance.countRealWorkigDays(22, 0, 1, 0));
		assertEquals(
				"Real working days should be 21 if the Working days in month 22, Sickdays 0, Vacations days 0 and Missed days 1",
				21, testInstance.countRealWorkigDays(22, 0, 0, 1));
		assertEquals(
				"Real working days should be 20 if the Working days in month 22, Sickdays 1, Vacations days 1 and Missed days 0",
				20, testInstance.countRealWorkigDays(22, 1, 1, 0));
		assertEquals(
				"Real working days should be 20 if the Working days in month 22, Sickdays 1, Vacations days 0 and Missed days 1",
				20, testInstance.countRealWorkigDays(22, 1, 0, 1));
		assertEquals(
				"Real working days should be 20 if the Working days in month 22, Sickdays 0, Vacations days 1 and Missed days 1",
				20, testInstance.countRealWorkigDays(22, 0, 1, 1));
		assertEquals(
				"Real working days should be 19 if the Working days in month 22, Sickdays 1, Vacations days 1 and Missed days 1",
				19, testInstance.countRealWorkigDays(22, 1, 1, 1));
		assertEquals(
				"Real working days should be 0 if the Working days in month 22, Sickdays 10, Vacations days 10 and Missed days 2",
				0, testInstance.countRealWorkigDays(22, 10, 10, 2));
	}
	
	@Test(expected = IllegalArgumentException.class)
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
