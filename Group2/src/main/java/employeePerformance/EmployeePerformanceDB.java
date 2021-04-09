package employeePerformance;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import database.ConnectionManager;
import database.IConnectionManager;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IEmployeeProductivityCalculator;
import employeePerformance.Interfaces.IFetchedPerformanceDetails;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import employeePerformance.abstractFactory.EmployeePerformanceFactory;
import employeePerformance.abstractFactory.IEmployeePerformanceFactory;
import userinterface.IInputOutputHandler;
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
	IFetchedPerformanceDetails fetchedperformanceDetails;
	
	private IInputEmployeeDetails employeeDetails = null;
	private IInputOutputHandler inputOutputHandler; 
	public EmployeePerformanceDB(IInputEmployeeDetails employeeDetails, IFetchedPerformanceDetails fetchedperformanceDetails, IInputOutputHandler inputOutputHandler)
    {
        this.employeeDetails = employeeDetails;
        this.fetchedperformanceDetails = fetchedperformanceDetails;
        this.inputOutputHandler = inputOutputHandler;
    }

	public ArrayList<String> getticketCountsDB() throws ParseException
	{
		connection = IConnectionMng.establishConnection();

		ArrayList<IFetchedPerformanceDetails> ticketCountAnalysislist = new ArrayList<IFetchedPerformanceDetails>() ;
		ArrayList<String> employeeDetailsString = new ArrayList<String>() ;

		boolean hasResult = false;
        ResultSet resultset = null;
        String startDate = null;
        String endDate = null;
        String expectedEndDate = null;
        String ticketLevel = null;
        String count = null;
        double workingHours = 0;
        
		try 
		{  
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call ticketCount(?, ?)}");
			statement.setString(1, employeeDetails.getEmployeeId());
            statement.setTimestamp(2, new java.sql.Timestamp(employeeDetails.generateDateFormat().getTime()));
            hasResult = statement.execute();
           
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            }  
            else 
            {
            	return null;
            }
            
            while(resultset.next()) 
            {
            	ticketLevel = resultset.getString("ticketLevel");
            	count = resultset.getString("count");
            	IFetchedPerformanceDetails fetchedperformanceDetails = new FetchedPerformanceDetails(ticketLevel, count, startDate, expectedEndDate, endDate, workingHours);
            	ticketCountAnalysislist.add(fetchedperformanceDetails);
            }
            
            generateEmployeePerformanceReport = employeePerformanceFactory.getPerformanceReport(inputOutputHandler);
            employeeDetailsString = generateEmployeePerformanceReport.displayEmployeeDetailsAndTicketCount(employeeDetails, ticketCountAnalysislist);
        	IConnectionMng.closeConnection();
        	
        	return employeeDetailsString;
		} 
		catch (SQLException e) 
		{
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return employeeDetailsString;
	}
	
	public ArrayList<String> getemployeeEfficiencyDB() throws ParseException
	{
		connection = IConnectionMng.establishConnection();
		ArrayList<String> employeeEfficiencyDetailsFormattedTable = new ArrayList<String>() ;
		ArrayList<IFetchedPerformanceDetails> efficiencyEfficiencyDetailsList = new ArrayList<IFetchedPerformanceDetails>() ;

		String startDate = null;
        String endDate = null;
        String expectedEndDate = null;
        String ticketLevel = null;
        String count = null;
        double workingHours = 0;
        
        boolean hasResult = false;
        ResultSet resultset = null;
        HashMap<Integer,Integer> calculatedEmployeeEfficiency = null;
        
		try 
		{  
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call employeeEfficiency(?, ?)}");

			statement.setString(1, employeeDetails.getEmployeeId());
            statement.setTimestamp(2, new java.sql.Timestamp(employeeDetails.generateDateFormat().getTime()));
            hasResult = statement.execute();
                        
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            }
            else
            {
            	return null;
            }
            
            while(resultset.next()) 
            {
                startDate = resultset.getString("startDate");
            	expectedEndDate = resultset.getString("expectedEndDate");
            	endDate = resultset.getString("endDate");
            	IFetchedPerformanceDetails fetchedperformanceDetails = new FetchedPerformanceDetails(ticketLevel, count, startDate, expectedEndDate, endDate, workingHours);
            	efficiencyEfficiencyDetailsList.add(fetchedperformanceDetails);
            }
            
            employeeEfficiency = employeePerformanceFactory.getEmployeeEfficiencyCalculator(inputOutputHandler);
        	calculatedEmployeeEfficiency = employeeEfficiency.calculateEmployeeEfficiency(efficiencyEfficiencyDetailsList);
        	employeeEfficiencyDetailsFormattedTable = generateEmployeePerformanceReport.displayEmployeeEfficiency(calculatedEmployeeEfficiency);
        	
        	statement.close();
        	resultset.close();
        	IConnectionMng.closeConnection();

        	return employeeEfficiencyDetailsFormattedTable;
		} 
		catch (SQLException e) 
		{
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
		
        return  employeeEfficiencyDetailsFormattedTable;
	}

	public ArrayList<String> getemployeeProductivityDB() throws ParseException
	{
		ArrayList<IFetchedPerformanceDetails> efficiencyProductivityDetailsList = new ArrayList<IFetchedPerformanceDetails>() ;
		ArrayList<String> employeeProductivityDetailsFormattedTable = new ArrayList<String>() ;

		connection = IConnectionMng.establishConnection();
        boolean hasResult = false;
        ResultSet resultset = null;
        HashMap<Integer, Integer> calculatedEmployeeProductivity = null;
        
        String startDate = null;
        String endDate = null;
        String expectedEndDate = null;
        String ticketLevel = null;
        String count = null;
    	double workingHours = 0;

		try 
		{  
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call employeeProductivity(?, ?)}");
			
			statement.setString(1, employeeDetails.getEmployeeId());
            statement.setTimestamp(2, new java.sql.Timestamp(employeeDetails.generateDateFormat().getTime()));
            hasResult = statement.execute();
                        
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            	
            }
            else
            {
            	return null;
            }
            
            while(resultset.next()) 
            {
            	startDate = resultset.getString("startDate");
            	endDate = resultset.getString("endDate");
            	workingHours = resultset.getDouble("resolutionHours");
				IFetchedPerformanceDetails fetchedperformanceDetails = new FetchedPerformanceDetails(ticketLevel, count, startDate, expectedEndDate, endDate, workingHours);

            	efficiencyProductivityDetailsList.add(fetchedperformanceDetails);

            }

            employeeProductivity = employeePerformanceFactory.getEmployeeProductivityCalculator(inputOutputHandler);
        	calculatedEmployeeProductivity = employeeProductivity.calculateEmployeeProductivity(efficiencyProductivityDetailsList);
        	employeeProductivityDetailsFormattedTable  = generateEmployeePerformanceReport.displayEmployeeProductivity(calculatedEmployeeProductivity);
        	IConnectionMng.closeConnection();
		} 
		catch (SQLException e) 
		{
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return employeeProductivityDetailsFormattedTable;
	}
}