package MyMavenLesson5.MyMavenProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyTest1 {

	@Test
	public void testExceptionIsThrown()
	{
		EmployeeOfCompany testInstance = new EmployeeOfCompany();
		testInstance.calculateOneDayCost(2250, 22);
	}
		
	@Test
	public void testCalculateOneDayCost() 
	{
		EmployeeOfCompany testInstance = new EmployeeOfCompany();		
		assertEquals("2250/22 must be 102.2727", 102.2727 ,testInstance.calculateOneDayCost(2250, 22));		
	}
	
	
	
	
	
	
	@Test
	public void testCalculateExperianceCoeff()
	{
		EmployeeOfCompany testInstance = new EmployeeOfCompany();
		testInstance.calculateExperianceCoeff(5);
	}

}
