package userinterface;

import userinterface.abstractFactory.*;
import java.text.ParseException;
import java.util.ArrayList;

import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import employeePerformance.abstractFactory.EmployeePerformanceFactory;
import employeePerformance.abstractFactory.IEmployeePerformanceFactory;
import login.Interfaces.IParameterizedUser;

public class EmployeePerformanceScreen implements IEmployeePerformanceScreen
{
    private final IInputOutputHandler inputOutputHandler;
    private final IUserInterfaceFactory userInterfaceFactory;
    private IEmployeePerformanceFactory employeePerformanceFactory = EmployeePerformanceFactory.instance();
    private IInputEmployeeDetails inputEmployeeDetails;
    private IEmployeePerformanceDB employeedetailsDB;
    private IBackToHomePageScreen backToHomePageScreen;
    private IGenerateEmployeePerformanceReport generateEmployeePerformance;
    public EmployeePerformanceScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
        this.userInterfaceFactory = UserInterfaceFactory.instance();
    }
    //IParameterizedUser user
    public void displayTicketGenerationScreen()
    {
	   
	   	String date = null;
	    String employeeID = null;
	 	ArrayList <String> efficiencyReport = new ArrayList<String>();
	    inputOutputHandler.displayMethod("Enter employeeID:");
		employeeID = inputOutputHandler.input();
		
		inputOutputHandler.displayMethod("Enter Date from which you want to see analysis report:");
		date = inputOutputHandler.input();
			
		inputEmployeeDetails = employeePerformanceFactory.userInput(date, employeeID);
		
		employeedetailsDB = employeePerformanceFactory.employeedetailsDB(inputEmployeeDetails);
		 
		try
		{
			if(employeedetailsDB.getticketCountsDB()==true) 
			{
			    inputOutputHandler.displayMethod("Successfully performed fetching of ticket count based on ticket level:");
			}
			else 
			{
			    inputOutputHandler.displayMethod("Ticket count fetching failed");
			}
		} 
		catch (ParseException e1) 
		{
			// TODO Auto-generated catch block
		    inputOutputHandler.displayMethod(e1.toString());
			e1.printStackTrace();
		}
		
		try {
			if(employeedetailsDB.getemployeeEfficiencyDB()==true) 
			{
			    inputOutputHandler.displayMethod("Successfully performed data fetching for generating employee efficiency:");
			}
			else 
			{
			    inputOutputHandler.displayMethod("data fetching failed for calculating employee efficiency");
			}
		} 
		catch (ParseException e1) 
		{
			// TODO Auto-generated catch block
		    inputOutputHandler.displayMethod(e1.toString());
			e1.printStackTrace();
		}
		
		try 
		{
			if(employeedetailsDB.getemployeeProductivityDB() == true) 
			{
				
			    inputOutputHandler.displayMethod("Successfully performed data fetching for generating employee productivity:");
			}
			else 
			{
			    inputOutputHandler.displayMethod("data fetching failed for calculating employee productivity");
			}
		} 
		catch (ParseException e1) 
		{
			// TODO Auto-generated catch block
		    inputOutputHandler.displayMethod(e1.toString());
			e1.printStackTrace();
		}
    	
	    //backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
        //backToHomePageScreen.displayGoBackToHomePageOption(user);
    }

	
}