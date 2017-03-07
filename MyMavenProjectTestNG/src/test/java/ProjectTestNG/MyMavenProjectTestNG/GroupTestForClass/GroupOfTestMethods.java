package ProjectTestNG.MyMavenProjectTestNG.GroupTestForClass;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ProjectTestNG.MyMavenProjectTestNG.EmployeeOfCompany;




@Test(groups = "exepGroupClass")
public class GroupOfTestMethods 
{
	static EmployeeOfCompany testInstance;
	
	@BeforeClass (alwaysRun = true)
	public static void initializeInstanceOfClass()
	{
		testInstance = new EmployeeOfCompany();
	}
	
	
	// Let's do all Exception Tests firstly
	
	public void testExceptionIsThrownInCalculateOneDayCostClass()
	{
		testInstance.calculateOneDayCost(0, 22);
		testInstance.calculateOneDayCost(-1, 22);
	}
	
	
	public void testExceptionIsThrownInCalculateExperianceCoeffClass()
	{		
		testInstance.calculateExperianceCoeff(-1);		
	}
	
	
	public void testExceptionIsThrownInCalculeteBonusClass()
	{		
		testInstance.calculeteBonus(0, 5);
		testInstance.calculeteBonus(-1, 5);
		testInstance.calculeteBonus(0, -1);
		testInstance.calculeteBonus(-1, -1);
	}	
	
	
}
