package employeePerformanceReport;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IInputEmployeeDetails;

public class EmployeePerformanceDBMock implements IEmployeePerformanceDB
{
		IInputEmployeeDetails employeeDetails;
		public EmployeePerformanceDBMock(IInputEmployeeDetails employeeDetails)
	    {
	        this.employeeDetails = employeeDetails;
	    }

		public HashMap<String, String> getticketCountsDB() 
		{
	        boolean hasResult = false;
	        ResultSet resultset = null;
			
			try 
			{  
				resultset.moveToInsertRow();
				resultset.insertRow();
				resultset.ins
	            	resultset = statement.getResultSet();
	            	
	            	generateEmployeePerformanceReport = employeePerformanceFactory.getPerformanceReport();
	            	employeeDetailsString = generateEmployeePerformanceReport.displayEmployeeDetailsAndTicketCount(employeeDetails, resultset);
	            	IConnectionMng.closeConnection();
	            	return employeeDetailsString;
	            }
	            else 
	            	return null;
			} 
			catch (SQLException e) 
			{
				System.out.print("SQL Exception");
				e.printStackTrace();
			}
			
	        return HashMap<String,String>;
		}
		
		public ArrayList<String> getemployeeEfficiencyDB() throws ParseException
		{
			ArrayList<String> employeeDetailsString = new ArrayList<String>() ;

			connection = IConnectionMng.establishConnection();
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
	            	IConnectionMng.closeConnection();
	    			System.out.print("Employee details string: " +employeeDetailsString);
	            	return employeeDetailsString;
	            }
	            else {
	            	return null;
	            }
			} 
			catch (SQLException e) 
			{
				System.out.print("SQL Exception");
				e.printStackTrace();
			}
	        return employeeDetailsString;
		}

		public ArrayList<String> getemployeeProductivityDB() throws ParseException
		{
			ArrayList<String> employeeDetailsString = new ArrayList<String>() ;

			connection = IConnectionMng.establishConnection();
	        boolean hasResult = false;
	        ResultSet resultset = null;
	        HashMap<Integer, Integer> calculatedEmployeeProductivity = null;
	        
			try 
			{  
				CallableStatement statement = (CallableStatement) connection.prepareCall("{call employeeProductivity(?, ?)}");
				
				statement.setString(1, employeeDetails.getEmployeeId());
	            statement.setTimestamp(2, new java.sql.Timestamp(employeeDetails.generateDateFormat().getTime()));
	            hasResult = statement.execute();
	                        
	            if(hasResult)  
	            {  
	            	resultset = statement.getResultSet();
	            	employeeProductivity = employeePerformanceFactory.getEmployeeProductivityCalculator(resultset);
	            	calculatedEmployeeProductivity = employeeProductivity.calculateEmployeeProductivity();
	            	employeeDetailsString  = generateEmployeePerformanceReport.displayEmployeeProductivity(calculatedEmployeeProductivity);
	            	IConnectionMng.closeConnection();
	            	return employeeDetailsString;
	            }
	            else
	            {
	            	return null;
	            }
			} 
			catch (SQLException e) 
			{
				System.out.print("SQL Exception");
				e.printStackTrace();
			}
	        return employeeDetailsString;
		}
	}
}
