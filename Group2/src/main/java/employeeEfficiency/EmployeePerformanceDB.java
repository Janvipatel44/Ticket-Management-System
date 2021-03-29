package employeeEfficiency;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

import database.ConnectionManager;
import database.IConnectionManager;

public class EmployeePerformanceDB implements IEmployeePerformanceDB {

	private Connection connection;
	private String ConfigurationFile = "ConfigurationFile.txt"; 
 
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	EmployeeEfficiencyCalculator employeeEfficiency;
	EmployeeProductivityCalculator employeeProductivity;
	
	private IInputEmployeeDetails employeeDetails = null;

	public EmployeePerformanceDB(IInputEmployeeDetails employeeDetails)
    {
        this.employeeDetails = employeeDetails;
    }
	
	IGenerateEmployeePerformanceReport displayEmployeePerformance;

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
            	displayEmployeePerformance = new GenerateEmployeePerformanceReport(employeeDetails);
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
            	employeeEfficiency = new EmployeeEfficiencyCalculator(resultset);
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
            	employeeProductivity = new EmployeeProductivityCalculator(resultset);
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