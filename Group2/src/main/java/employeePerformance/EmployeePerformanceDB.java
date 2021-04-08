package employeePerformance;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IEmployeeProductivityCalculator;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import employeePerformance.abstractFactory.EmployeePerformanceFactory;
import employeePerformance.abstractFactory.IEmployeePerformanceFactory;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class EmployeePerformanceDB implements IEmployeePerformanceDB 
{
	private Connection connection;
	private String ConfigurationFile = "ConfigurationFile.txt"; 
 
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	IEmployeePerformanceFactory  employeePerformanceFactory = EmployeePerformanceFactory.instance();
	IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
	IEmployeeEfficiencyCalculator employeeEfficiency;
	IEmployeeProductivityCalculator employeeProductivity;
	IGenerateEmployeePerformanceReport generateEmployeePerformanceReport;

	private IInputEmployeeDetails employeeDetails = null;
	ArrayList<String> employeeDetailsString = new ArrayList<String>() ;
	
	public EmployeePerformanceDB(IInputEmployeeDetails employeeDetails)
    {
        this.employeeDetails = employeeDetails;
    }

	public boolean getticketCountsDB() throws ParseException
	{
		connection = IConnectionMng.establishConnection();
        boolean success = false;
        boolean hasResult = false;
        ResultSet resultset = null;
		
		try 
		{  
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call ticketCount(?, ?)}");
			statement.setString(1, employeeDetails.getEmployeeId());
			System.out.print(new java.sql.Timestamp(employeeDetails.generateDateFormat().getTime()));
            statement.setTimestamp(2, new java.sql.Timestamp(employeeDetails.generateDateFormat().getTime()));
            hasResult = statement.execute();
           
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            	
            	generateEmployeePerformanceReport = employeePerformanceFactory.getPerformanceReport();
            	employeeDetailsString = generateEmployeePerformanceReport.displayEmployeeDetailsAndTicketCount(employeeDetails, resultset);
            }
            success = true;
			return success;
		
		} 
		catch (SQLException e) 
		{
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return success;
	}
	
	public boolean getemployeeEfficiencyDB() throws ParseException
	{
		connection = IConnectionMng.establishConnection();
        boolean success=false;
        boolean hasResult = false;
        ResultSet resultset = null;
        HashMap<Integer,Integer> calculatedEmployeeEfficiency = null;
		try 
		{  
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call employeeEfficiency(?, ?)}");

			statement.setString(1, employeeDetails.getEmployeeId());
            statement.setTimestamp(2, new java.sql.Timestamp(employeeDetails.generateDateFormat().getTime()));
            hasResult = statement.execute();
                        
	        System.out.print(hasResult); 
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            	employeeEfficiency = employeePerformanceFactory.getEmployeeEfficiencyCalculator(resultset);
            	calculatedEmployeeEfficiency = employeeEfficiency.calculateEmployeeEfficiency();
            	employeeDetailsString = generateEmployeePerformanceReport.displayEmployeeEfficiency(calculatedEmployeeEfficiency);
            }
			return true;
		} 
		catch (SQLException e) 
		{
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return success;
	}

	public boolean getemployeeProductivityDB() throws ParseException
	{
		connection = IConnectionMng.establishConnection();
        boolean success=false;
        boolean hasResult = false;
        ResultSet resultset = null;
        HashMap<Integer, Integer> calculatedEmployeeProductivity = null;
        
		try 
		{  
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call employeeProductivity(?, ?)}");
			
			statement.setString(1, employeeDetails.getEmployeeId());
            statement.setTimestamp(2, new java.sql.Timestamp(employeeDetails.generateDateFormat().getTime()));
            hasResult = statement.execute();
                        
	        System.out.print(hasResult); 
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            	employeeProductivity = employeePerformanceFactory.getEmployeeProductivityCalculator(resultset);
            	calculatedEmployeeProductivity = employeeProductivity.calculateEmployeeProductivity();
            	employeeDetailsString  = generateEmployeePerformanceReport.displayEmployeeProductivity(calculatedEmployeeProductivity);
            }
			return true;
		} 
		catch (SQLException e) 
		{
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return success;
	}
}