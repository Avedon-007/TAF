package lesson4.framework;

import java.io.IOException;
import java.sql.SQLException;

public class Runner 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, InterruptedException 
	{
		System.out.println("We need to test flight tickets booking system. User can browse and choose flights, tickets' availability," 
							+ " additional services and information via web front-end application. All necessary data are stored in" 
							+ " the three tables of database (airports, flights, airlines) and are updated in realtime. User performs" 
							+ " its requests without reference to a specific date and gets current state of the system. We need to"
							+ " test behavior and correct work of the system.\n");
		System.out.println("GETTING STARTED...");
		
		TestEnvironment myInstance = new TestEnvironment();

		myInstance.initialiseEnvironmentVariables();

		myInstance.createEnvironment();

		myInstance.runTests();
		  
		System.out.println("FINISH!!!");
	}
}
// Runner should be more user friendly, it should provide status messageies

