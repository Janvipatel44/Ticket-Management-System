package updateTicketDetails;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfacs.IConnectionManager;
import interfacs.IcheckTicketExists;

public class checkTicketExists  implements IcheckTicketExists
{
	
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSetValue=null;
	private String ConfigurationFile = "ConfigurationFile";
	private int choice=1;
	private IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	
	public boolean ticketExistsForCreator(String ticketID, String employeeID)
	{
		boolean result = false;
		try 
		{
			resultSetValue = getTicketDetail(ticketID);
			if(resultSetValue.next())
			{
				String creatorId = resultSetValue.getString("creatorID");
				System.out.println(creatorId);
				if(creatorId.equalsIgnoreCase(employeeID))
				{
					result = true;
				}
				
			}
			IConnectionMng.closeConnection();
		}
		catch (SQLException e)
		{
				e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean ticketExistsForAssignee(String ticketID, String employeeID)
	{
		boolean result = false;
		try 
		{
			resultSetValue = getTicketDetail(ticketID);
			if(resultSetValue.next())
			{
				String AssigneeID = resultSetValue.getString("employeeID");
				if(AssigneeID.equalsIgnoreCase(employeeID))
				{
					result = true;
				}
			}
			IConnectionMng.closeConnection();			
		}
		catch (SQLException e)
		{
				e.printStackTrace();
		}
		return result;
	}
	
	private ResultSet getTicketDetail(String ticketID) throws SQLException
	{
		ResultSet resultSet =null;
		connect = IConnectionMng.establishConnection();
		SPstatement = connect.prepareCall("{call searchTicket(?,?)}");
		SPstatement.setLong(1,choice);
		SPstatement.setString(2,ticketID);
		SPstatement.execute();
		resultSet = SPstatement.getResultSet();
		return resultSet;
		
	}
}
