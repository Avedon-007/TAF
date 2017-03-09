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



@RunWith(Parameterized.class)
public class TestMyTest1Params 
{
	private double salaryRate;
	private int generalWorkigDaysInMoth;	
	private static List <double[]> dataSet1 = new ArrayList<double[]>();
	private static List <double[]> dataSet2 = new ArrayList<double[]>();
	private static List <double[]> dataSet3 = new ArrayList<double[]>();
	private static int[] dataSet4 = {-1, 2, -3};
	private static List <double[]> dataSet5 = new ArrayList<double[]>();
	private static List <double[]> dataSet6 = new ArrayList<double[]>();
	private static List <int[]> dataSet7 = new ArrayList<int[]>();
	private static EmployeeOfCompany testInstance;
	
	@BeforeClass
	public static void initializeInstanceOfClass()
	{
		testInstance = new EmployeeOfCompany();		
		
		dataSet1.add(new double[] {102.2727, 2250.0, 22.0, 0.02});
		dataSet1.add(new double[] {100.00, 2200.0, 22.0, 0.0});
		
		dataSet2.add(new double[] {0.9, 9, 0.0});
		dataSet2.add(new double[] {0.9, 10, 0.0});
		dataSet2.add(new double[] {0.9, 11, 0.0});
		
		dataSet3.add(new double[] {0.0, 0, 0.0});
		dataSet3.add(new double[] {0.1, 1, 0.0});
		dataSet3.add(new double[] {0.7, 7, 0.0});
		dataSet3.add(new double[] {0.8, 8, 0.0});
		
		dataSet5.add(new double[] {0, 1, 0, 0.0});
		dataSet5.add(new double[] {0.4, 1, 8, 0.0});
		
		dataSet6.add(new double[] {0, 0});
		dataSet6.add(new double[] {-1, 1});	//должен тест упасть, так как 1, но не падает
		dataSet6.add(new double[] {-0.1, 1});
		
		dataSet7.add(new int[] {22, 22, 0, 0, 0});
		dataSet7.add(new int[] {21, 22, 1, 0, 0});
		dataSet7.add(new int[] {21, 22, 0, 1, 0});
		dataSet7.add(new int[] {21, 22, 0, 0, 1});
		dataSet7.add(new int[] {20, 22, 1, 1, 0});
		dataSet7.add(new int[] {20, 22, 1, 0, 1});
		dataSet7.add(new int[] {20, 22, 0, 1, 1});
		dataSet7.add(new int[] {19, 22, 1, 1, 1});
		dataSet7.add(new int[] {0, 22, 10, 10, 2});

	}
	
	
		
	public TestMyTest1Params(double salaryRate, int generalWorkigDaysInMoth)
	{
		this.salaryRate = salaryRate;
		this.generalWorkigDaysInMoth = generalWorkigDaysInMoth;
	}
	
	@Parameterized.Parameters
	public static Collection forTestExceptionIsThrownInCalculateOneDayCostClass()
	{
		return Arrays.asList(new Object[][]{ {0, 22}, {-1, 22} });
	}
		
// Two methods of handling Exceptions: @Rule and Annotations
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testExceptionIsThrownInCalculateOneDayCostClass()
	{
		thrown.expect(IllegalArgumentException.class);
		testInstance.calculateOneDayCost(salaryRate, generalWorkigDaysInMoth);		
	}	
	
	//Using DataSet1//	
	@Test
	public void testCalculateOneDayCost() 
	{
		for (double[] buferArry : dataSet1)
		{				
				assertEquals("2250/22 must be 102.2727", buferArry[0],
				testInstance.calculateOneDayCost(buferArry[1], buferArry[2]), buferArry[3]);
		}
	}
			
	//Using DataSet2//	
	@Test
	public void testCalculateExperianceCoeffIfExpirianceMore9Years()
	{		
		for (double[] buferArry : dataSet2)
		{
		assertEquals(
				"Expiriance coefficient for 9 years of expiriance should be 0.9",
				buferArry[0], testInstance.calculateExperianceCoeff(buferArry[1]), buferArry[2]);		//tolerance 0 (use tolerance coz DOUBLE Method)
		}
	}

	//Using DataSet3//	
	@Test
	public void testCalculateExperianceCoeffIfExpirianceLess9Years()
	{		
		for (double[] buferArry : dataSet3)
		{
		assertEquals(
				"Expiriance coefficient for 1 years of expiriance should be 0.1",
				buferArry[0], testInstance.calculateExperianceCoeff(buferArry[1]), buferArry[2]);
		}
	}	
	
	//Using DataSet4//		
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculateExperianceCoeffClass()
	{	// проверка не валидна
		for (int i = 0; i < dataSet4.length; i++)		
			assertEquals(IllegalArgumentException.class, testInstance.calculateExperianceCoeff(dataSet4[i]));			
	}
	
	
	//Using DataSet5//
	@Test
	public void testCalculeteBonus()
	{		
		for (double[] buferArry : dataSet5)
		{
			// For String Format  https://www.dotnetperls.com/format-java
			String text = String
					.format("Bonus for Employee if SalaryRate %2$.1f and Expieiance %3$.1f years should be %1$.1f ! -> ",
							buferArry[0], buferArry[1], buferArry[2]);
			// Will use: assertEquals(double, double, tolerance) - if tolerance
			// 0.2 , so e.g. 14.5 -> 14.4 & 14.6 (0.2 means +-0.1)	
		assertEquals(text, buferArry[0], testInstance.calculeteBonus(buferArry[1], buferArry[2]), buferArry[3]);
		}
	}
	
	//Using DataSet6//
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculeteBonusClass()
	{	
		for (double[] buferArry : dataSet6)		
			testInstance.calculeteBonus(buferArry[0], buferArry[1]);  
	}
	
	//Using DataSet7//
	@Test
	public void testCountRealWorkigDays()
	{		
		for (int[] buferArry : dataSet7)
		{
			String text = String
					.format("Real working days should be %1$d if the Working days in month %2$d, Sickdays %3$d, Vacations days %4$d and Missed days %5$d",
							buferArry[0], buferArry[1], buferArry[2],
							buferArry[3], buferArry[4]);
			assertEquals(text,
					buferArry[0], testInstance.countRealWorkigDays(buferArry[1], buferArry[2], buferArry[3], buferArry[4]));
		}
		
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
