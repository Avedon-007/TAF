package MyMavenLesson5.MyMavenProject;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestParamExceptionOfCalcOneDayCost 
{
	EmployeeOfCompany testInstance;
	@Before
	public void setup()
	{
		testInstance = new EmployeeOfCompany();
	}
	
	@Parameter
	 public int p1;
	 @Parameter (value = 1)
	 public int p2;
	
	 @Parameters
	 public static Collection<Object[]> testData()
	 {
		 Object[][] data = new Object[][] { {0, 22}, {-1, 22}, {-2, 22}, {1, -1}, {-1, 0} };
		 return Arrays.asList(data);
	 }
	
	 @Test(expected = IllegalArgumentException.class)
	 public void testExceptionIsThrownInCalculateOneDayCostClass()
	 {
		 //EmployeeOfCompany testInstance = new EmployeeOfCompany(); // Have created new Instance in @Before
		 testInstance.calculateOneDayCost(p1, p2);
	 }	
}
