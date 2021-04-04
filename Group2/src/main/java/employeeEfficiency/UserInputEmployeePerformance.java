package employeeEfficiency;

import java.text.ParseException;
import java.util.Scanner;

import employeeEfficiency.Interfaces.IEmployeePerformanceDB;
import employeeEfficiency.Interfaces.IInputEmployeeDetails;
import employeeEfficiency.Interfaces.IUserInputEmployeePerformance;
import employeeEfficiency.abstractFactory.EmployeePerformanceFactory;
import employeeEfficiency.abstractFactory.IEmployeePerformanceFactory;

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
