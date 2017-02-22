package MyMavenLesson5.MyMavenProject;

import org.apache.poi.hssf.record.PrecisionRecord;

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

	// This Method round decimal number. For example: 10.12345 -> 10.123
	protected static double roundDoubleDigit(double value, int place)
	{
		int places = 0;
		if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	
	public double calculateOneDayCost(double salaryRate, int generalWorkigDaysInMoth)
	{
		if(salaryRate <= 0) throw new IllegalArgumentException("'SalaryRate' should be more than 0!");
		return roundDoubleDigit( (salaryRate/generalWorkigDaysInMoth) , 4);
	}	
	
	public double calculateExperianceCoeff(int experience)
	{
		double experianceCoeff = 0.0;
		if(experience >= 10) experianceCoeff = 0.5;
		else if(experience >= 0 && experience < 10)	experianceCoeff = experience/10;		 
		else System.out.println("ERROR!!! experience value is less 0");
		return experianceCoeff;
	}
		
	public double calculeteBonus(double salaryRate, int experience)
	{
		if(salaryRate <= 0) throw new IllegalArgumentException("'SalaryRate' should be more than 0!");
		return (salaryRate * 0.5) * calculateExperianceCoeff(experience);
	}
	
	public int countRealWorkigDays(int generalWorkigDaysInMoth, int sickDays, int vacationDays) 
	{
		return generalWorkigDaysInMoth - sickDays - vacationDays;
	}

	public double calculateSalary(double salaryRate, double bonus, int sickDays,  int generalWorkigDaysInMoth,
			int realWorkigDaysInMoth,  int vacationDays)
	{
		return calculateOneDayCost(salaryRate, generalWorkigDaysInMoth) * countRealWorkigDays(generalWorkigDaysInMoth, sickDays, vacationDays) +  calculeteBonus();
	}
}
