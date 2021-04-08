package updateTicketDetails;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import insertTicket.Interfaces.ICreateTicket;
import updateTicketDetails.interfaces.ITicketStatusOperationsDB;
import updateTicketDetails.interfaces.IworkingHours;

public class TicketStatusOperationsDB implements ITicketStatusOperationsDB
{
	
		private Connection connection;
		private String ConfigurationFile = "ConfigurationFile.txt";
	 
		IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
		ICreateTicket createTicket = null;
		IworkingHours hours;
	    HashMap<String, String> inputsHandler = new HashMap<String, String>();

	    
		public double ticketonHoldHours(String ticketID)
		{
				connection = IConnectionMng.establishConnection();
		        boolean hasResult = false;
		        double onHoldHours = 0;
		        ResultSet resultset;
				try {
				CallableStatement statement = (CallableStatement) connection.prepareCall("{call getTicketStatusDate(?)}");
				
				statement.setString(1, ticketID);
			
				hasResult = statement.execute();
				System.out.println(hasResult);
		
		        if(hasResult)  
		        {  
		        	resultset = statement.getResultSet();
		        	hours = new workingHours(resultset);
		        	onHoldHours = hours.insertTicket(resultset);
		        }
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				System.out.print("SQL Exception inprogress");
				e.printStackTrace();
			}
			return onHoldHours;	
		}
		

	    public double ticketInProgressHours(String ticketID)
		{
			String inProgressEnterdate = null;
			Date todayDate = null;
			Date formateGetDate = null;
			double inProgressHours = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Calendar cal = Calendar.getInstance();
		    CallableStatement statement;
			ResultSet resultset;
			boolean hasResult = false;
			try
			{
				
				connection = IConnectionMng.establishConnection();
				statement = connection.prepareCall("{call getTicketStatusDate(?)}");
				statement.setString(1,ticketID);
				
				hasResult = statement.execute();
				System.out.println(hasResult);
		
		        if(hasResult)  
		        {  
		        	resultset = statement.getResultSet();
		        	hours = new workingHours(resultset);
		        	inProgressHours = hours.insertTicket(resultset);

		        	
		        	//responseTime_resolutionTime_Calculator(inProgressHours);
			        //insertHours(inProgressHours);
		        	
		        }
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return inProgressHours;	
	    }
	    
	    public boolean openTicket(String ticketID) throws SQLException
		{
	    	
		    CallableStatement statement;
			ResultSet resultset;
			boolean hasResult = false;
			double inProgressHours = 0;
	    	ticketInProgressHours( ticketID);
	    	connection = IConnectionMng.establishConnection();
			statement = connection.prepareCall("{call check_openTicket(?)}");
			statement.setString(1,ticketID);
			
			hasResult = statement.execute();
			System.out.println(hasResult);
	
	        if(hasResult)  
	        {  
	        	resultset = statement.getResultSet();
	        	hours = new workingHours(resultset);
	        	inProgressHours = hours.insertTicket(resultset);
				System.out.println(hasResult);

	        	connection = IConnectionMng.establishConnection();
				statement = connection.prepareCall("{call calculating_responseHours(?,?)}");
				statement.setDouble(1,inProgressHours);
				statement.setString(2,ticketID);

				statement.execute();
	        }
			return true;
	    }
		/*public boolean insertHours(double inProgressHours)
		{
			connection = IConnectionMng.establishConnection();
	        boolean success=false;
	        boolean hasResult = false;
	        ResultSet resultset;
			try 
			{
				
				CallableStatement statement = (CallableStatement) connection.prepareCall("{call insert_Hours_InProgress(?,?)}");
				
				statement.setString(1, "111");
				statement.setDouble(2, inProgressHours);
				hasResult = statement.execute();
		
				System.out.println(hasResult);

		        success = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("SQL Exception insertHourse");
				e.printStackTrace();
			}
			return success;	
		}*/
		/*public boolean responseTime_resolutionTime_Calculator(double inProgressHours)
		{
			connection = IConnectionMng.establishConnection();
	        boolean success=false;
	        boolean hasResult = false;
	        ResultSet resultset;
			try 
			{
				CallableStatement statement = (CallableStatement) connection.prepareCall("{call ticketStatus_InProgress(?)}");
				
				statement.setString(1, "111");
			
				hasResult = statement.execute();
				System.out.println(hasResult);
			
			    if(hasResult)  
			    {  
			    	resultset = statement.getResultSet();
			    	while(resultset.next()) {
				    	if(resultset.getString("status")==null)
				    	{
				    		CallableStatement statement1 = (CallableStatement) connection.prepareCall("{call calculating_responseHours(?,?)}");
							
							statement1.setString(1, "111");
							statement1.setDouble(2,inProgressHours);
							
							statement1.execute();				
				    	}
				    	else if(resultset.getString("status")=="done")
				    	{
				    		CallableStatement statement1 = (CallableStatement) connection.prepareCall("{call calculating_resolutionHours(?)}");
							
							statement1.setString(1, "111");
							
							statement1.execute();				
				    	}
				    	else {
				    		return false;
				    	}
			    	}
			    }
			    System.out.println(hasResult);
			
			    success = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			    System.out.println("respones");

				System.out.print("SQL Exception");
				e.printStackTrace();
			}
				return success;	
		}*/
	}


