package employeeEfficiency;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

import database.ConnectionManager;
import database.IConnectionManager;
import employeeEfficiency.Interfaces.IEmployeeEfficiencyCalculator;
import employeeEfficiency.Interfaces.IEmployeePerformanceDB;
import employeeEfficiency.Interfaces.IEmployeeProductivityCalculator;
import employeeEfficiency.Interfaces.IGenerateEmployeePerformanceReport;
import employeeEfficiency.Interfaces.IInputEmployeeDetails;
import employeeEfficiency.abstractFactory.EmployeePerformanceFactory;
import employeeEfficiency.abstractFactory.IEmployeePerformanceFactory;

public class EmployeePerformanceDB implements IEmployeePerformanceDB {

	private Connection connection;
	private String ConfigurationFile = "ConfigurationFile.txt"; 
 
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	IEmployeePerformanceFactory  employeePerformanceFactory = EmployeePerformanceFactory.instance();

	IEmployeeEfficiencyCalculator employeeEfficiency;
	IEmployeeProductivityCalculator employeeProductivity;
	IGenerateEmployeePerformanceReport displayEmployeePerformance;

	private IInputEmployeeDetails employeeDetails = null;

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

		try {  
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call ticketCount(?, ?)}");
			
			statement.setString(1, employeeDetails.getEmployeeId());
            statement.setDate(2, java.sql.Date.valueOf(employeeDetails.getDate()) );
            hasResult = statement.execute();
           
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            	displayEmployeePerformance = employeePerformanceFactory.getPerformanceReport(employeeDetails);
            	displayEmployeePerformance.displayEmployeeDetailsAndTicketCount(resultset);
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
            statement.setDate(2, java.sql.Date.valueOf(employeeDetails.getDate()) );
            hasResult = statement.execute();
                        
	        System.out.print(hasResult); 
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            	employeeEfficiency = employeePerformanceFactory.getEmployeeEfficiencyCalculator(resultset);
            	calculatedEmployeeEfficiency = employeeEfficiency.calculateEmployeeEfficiency();
            	displayEmployeePerformance.displayEmployeeEfficiency(calculatedEmployeeEfficiency);
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
            statement.setDate(2, java.sql.Date.valueOf(employeeDetails.getDate()) );
            hasResult = statement.execute();
                        
	        System.out.print(hasResult); 
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            	employeeProductivity = employeePerformanceFactory.getEmployeeProductivityCalculator(resultset);
            	calculatedEmployeeProductivity = employeeProductivity.calculateEmployeeProductivity();
            	displayEmployeePerformance.displayEmployeeProductivity(calculatedEmployeeProductivity);
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