package MyMavenLesson5.MyMavenProject;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMyTest1 {
	static EmployeeOfCompany testInstance;

	@BeforeClass
	public static void initializeInstanceOfClass() {
		testInstance = new EmployeeOfCompany();
	}

	// ----------------------------------------------------------------------------------------
	// использую один набор данных в каждом методе, потому что если использовать
	// несколько наборов данных в одном методе, то проверка не валидна (если
	// хоть один набор данных удовлетворяет проверку - проверка проходит)

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculateOneDayCostClass1() {
		// EmployeeOfCompany testInstance = new EmployeeOfCompany(); // See the
		// @BeforClass
		testInstance.calculateOneDayCost(0, 22);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculateOneDayCostClass2() {
		testInstance.calculateOneDayCost(-1, 22);
	}

	// ----------------------------------------------------------------------------------------

	@Test
	public void testCalculateOneDayCost() {
		// EmployeeOfCompany testInstance = new EmployeeOfCompany(); // See the @BeforClass
		assertEquals("2250/22 must be 102.2727", 102.2727,
				testInstance.calculateOneDayCost(2250, 22), 0.02); // tolerance 0.02 (use tolerance
																	// coz DOUBLE Method)
		assertEquals("2200/22 must be 100.00", 100.00,
				testInstance.calculateOneDayCost(2200, 22), 0.0);
	}

	@Test
	public void testCalculateExperianceCoeffIfExpirianceMore10Years() {
		assertEquals(
				"Expiriance coefficient for 9 years of expiriance should be 0.9",
				0.9, testInstance.calculateExperianceCoeff(9), 0);
		assertEquals(
				"Expiriance coefficient for 10 years of expiriance should be 0.9",
				0.9, testInstance.calculateExperianceCoeff(10), 0);
	}

	@Test
	public void testCalculateExperianceCoeffIfExpirianceLess9Years() {
		assertEquals(
				"Expiriance coefficient for 1 years of expiriance should be 0.1",
				0.1, testInstance.calculateExperianceCoeff(1), 0);
		assertEquals(
				"Expiriance coefficient for 8 years of expiriance should be 0.8",
				0.8, testInstance.calculateExperianceCoeff(8), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculateExperianceCoeffClass() {

		testInstance.calculateExperianceCoeff(-1);
	}

	@Test
	public void testCalculeteBonus() {
		// Will use: assertEquals(double, double, tolerance) - if tolerance 0.2
		// , so e.g. 14.5 -> 14.4 & 14.6 (0.2 means +-0.1)
		assertEquals(
				"Bonus for Employee if SalaryRate 2250 and Expieiance 5 years should be 562.5! -> ",
				562.5, testInstance.calculeteBonus(2250.0, 5), 0.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrownInCalculeteBonusClass() {
		testInstance.calculeteBonus(0, 5);
		testInstance.calculeteBonus(-1, 5);
		testInstance.calculeteBonus(0, -1);
		testInstance.calculeteBonus(-1, -1);
	}

	@Test
	public void testCountRealWorkigDays() {
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
	public void testExceptionIsThrownInCountRealWorkigDaysClass() {
		testInstance.countRealWorkigDays(0, 0, 0, 0);
		testInstance.countRealWorkigDays(24, 0, 0, 0);
		testInstance.countRealWorkigDays(20, -1, 0, 0);
		testInstance.countRealWorkigDays(20, 0, -1, 0);
		testInstance.countRealWorkigDays(20, 0, 0, -1);
		testInstance.countRealWorkigDays(20, 10, 9, 1);
	}
}
