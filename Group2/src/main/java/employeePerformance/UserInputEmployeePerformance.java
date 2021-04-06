package employeePerformance;

import java.text.ParseException;
import java.util.Scanner;

import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import employeePerformance.Interfaces.IUserInputEmployeePerformance;
import employeePerformance.abstractFactory.EmployeePerformanceFactory;
import employeePerformance.abstractFactory.IEmployeePerformanceFactory;

public class UserInputEmployeePerformance implements IUserInputEmployeePerformance {

	IEmployeePerformanceFactory  employeePerformanceFactory = EmployeePerformanceFactory.instance();
	IInputEmployeeDetails inputEmployeeDetails; 
	IEmployeePerformanceDB employeedetailsDB; 

	public boolean userInputEmployeePerformanceDetails() throws ParseException  
	{
		Scanner sc = new Scanner(System.in);
		String date = null;
	    String employeeID = null;
	 	
		System.out.println("Please Provide Date:");
		date = sc.nextLine();
		
		System.out.println("Please provide employeeID:");
		employeeID = sc.nextLine();
		
		inputEmployeeDetails = employeePerformanceFactory.userInput(date, employeeID);
		employeedetailsDB = employeePerformanceFactory.employeedetailsDB(inputEmployeeDetails);
		employeedetailsDB.getticketCountsDB(); 
    	employeedetailsDB.getemployeeEfficiencyDB();
    	employeedetailsDB.getemployeeProductivityDB();
    	
		return true;  
	}
}
