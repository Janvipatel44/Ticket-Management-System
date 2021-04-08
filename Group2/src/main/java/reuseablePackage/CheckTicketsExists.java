package reuseablePackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.ICheckTicketsExists;

public class CheckTicketsExists  implements ICheckTicketsExists
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private String ConfigurationFile = "ConfigurationFile";
	private int choice=1;
	
	private IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	
	public boolean ticketExists(String ticketID)
	{
		boolean result=false;
		try {
			fetchTicketForTicketID(ticketID);
			if(resultSet.next())
			{
				result=true;	
			}
			IConnectionMng.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return result;
	}
	
	private void fetchTicketForTicketID(String ticketID) throws Exception
	{
		try 
		{
			connect = IConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call searchTicket(?,?)}");
			SPstatement.setLong(1,choice);
			SPstatement.setString(2,ticketID);
			SPstatement.execute();
			resultSet = SPstatement.getResultSet();
		}
		catch (SQLException e)
		{
			throw new Exception();
		}
		
	}
	
	public boolean ticketExistForManager(String ticketID)
	{
		boolean result=false;
		try
		{
			fetchTicketForTicketID(ticketID);
			if(resultSet.next())
			{
				result=true;
				IConnectionMng.closeConnection();
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean ticketExistForNotManager(String ticketID,String employeeID)
	{
		boolean result=false;
		try
		{
			fetchTicketForTicketID(ticketID);
			if(resultSet.next())
			{
				String employeeid = resultSet.getString("employeeID");
				if(employeeid.equals(employeeID))
				{
					
					result=true;
				}
				IConnectionMng.closeConnection();
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

}