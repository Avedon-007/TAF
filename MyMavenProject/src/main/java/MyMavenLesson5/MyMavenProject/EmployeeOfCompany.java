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

	
	public double calculateOneDayCost(int generalWorkigDaysInMoth)
	{
		return salaryRate/generalWorkigDaysInMoth;
	}	
	
	public double calculateExperianceCoeff()
	{
		double experianceCoeff = 0.0;
		if(experience >= 10) experianceCoeff = 0.5;
		else if(experience >= 0 && experience < 10)	experianceCoeff = experience/10;		 
		else System.out.println("ERROR!!! experience value is less 0");
		return experianceCoeff;
	}
		
	public double calculeteBonus()
	{
		return (salaryRate * 0.5) * calculateExperianceCoeff();
	}
	
	public int countRealWorkigDays(int generalWorkigDaysInMoth, int sickDays, int vacationDays) 
	{
		return generalWorkigDaysInMoth - sickDays - vacationDays;
	}

	public double calculateSalary(double salaryRate, double bonus, int sickDays,  int generalWorkigDaysInMoth,
			int realWorkigDaysInMoth,  int vacationDays)
	{
		return calculateOneDayCost(generalWorkigDaysInMoth) * countRealWorkigDays(generalWorkigDaysInMoth, sickDays, vacationDays) +  calculeteBonus();
	}
}
