package MyMavenLesson5.MyMavenProject;



public class EmployeeOfCompany 
{
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private int experience;
	private String position;
	private double salaryRate;
	
	public EmployeeOfCompany(){}
	
	public EmployeeOfCompany(String firstName, String lastName, String gender, int age, int experience, String position, double salaryRate)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.experience = experience;
		this.position = position;
		this.salaryRate = salaryRate;
	}
			
		
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public double calculateOneDayCost(double salaryRate, int generalWorkigDaysInMoth)
	{
		if(salaryRate <= 0 || generalWorkigDaysInMoth < 0) throw new IllegalArgumentException("'SalaryRate' should be more than 0 and 'generalWorkigDaysInMoth' should be 0 or more! ");
		
		return salaryRate/generalWorkigDaysInMoth;
	}	
	
	public double calculateExperianceCoeff(double experience)
	{
		double experianceCoeff = 0.0;
		if(experience >= 9) experianceCoeff = 0.9;
		else if(experience >= 0 && experience < 9)	experianceCoeff = experience/10;		 
		else throw new IllegalArgumentException("ERROR!!! 'experience' value is less 0! ");
		
		return experianceCoeff;
	}
		
	public double calculeteBonus(double salaryRate, double experience)
	{
		if(salaryRate <= 0) throw new IllegalArgumentException("'SalaryRate' should be more than 0! ");
		
		return (salaryRate * 0.5) * calculateExperianceCoeff(experience);
	}
	
	public int countRealWorkigDays(int generalWorkigDaysInMoth, int sickDaysInMonth, int vacationDaysInMoth, int missedDays) 
	{
		int sumOfSickAndVacationAndMissedDays = sickDaysInMonth + vacationDaysInMoth + missedDays;
		if(generalWorkigDaysInMoth <= 0) throw new IllegalArgumentException("The General working days in month should be more than 0! ");
		else if(generalWorkigDaysInMoth >= 24) throw new IllegalArgumentException("The General working days in month should be less than 24! ");
		else if(sickDaysInMonth < 0) throw new IllegalArgumentException("The Sickdays in month should be 0 or more! ");
		else if(vacationDaysInMoth < 0) throw new IllegalArgumentException("The Vacation days in month should be 0 or more! ");
		else if(missedDays < 0) throw new IllegalArgumentException("The Missed days in month should be 0 or more! ");
		else if(sumOfSickAndVacationAndMissedDays > generalWorkigDaysInMoth) throw new IllegalArgumentException("The Sum of Vacation days, Sickdays and Missed days should be less or equals than General Working days in month! ");
		
		return generalWorkigDaysInMoth - sickDaysInMonth - vacationDaysInMoth- missedDays;
	}

	public double calculateSalary(double salaryRate, double bonus, int sickDaysInMonth,  int generalWorkigDaysInMoth,
			int realWorkigDaysInMoth,  int vacationDaysInMoth, int experience, int missedDays)
	{
		return calculateOneDayCost(salaryRate, generalWorkigDaysInMoth) * countRealWorkigDays(generalWorkigDaysInMoth, sickDaysInMonth, vacationDaysInMoth, missedDays) +  calculeteBonus(salaryRate, experience);
	}
}


/*
//////////////////////////////////////////////////////////////////////////////////////
// This Method round decimal number. For example: 10.12345 -> 10.123				//
// than we can use:  roundDoubleDigit(10.12345, 3);  --> 10.123						//
protected static double roundDoubleDigit(double value, int place)					//
{																					//
int places = 0;																		//
if (places < 0) throw new IllegalArgumentException();								//																					
long factor = (long) Math.pow(10, places);											//
value = value * factor;																//	
long tmp = Math.round(value);														//
return (double) tmp / factor;														//
}																					//
//////////////////////////////////////////////////////////////////////////////////////
*/