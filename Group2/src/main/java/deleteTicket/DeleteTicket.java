package deleteTicket;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

<<<<<<< HEAD:Group2/src/main/java/deleteTicket/DeleteTicket.java
import database.IConnectionManager;
import deleteTicket.interfaces.IDeleteTicket;
=======
import database.intefaces.IConnectionManager;
import deleteTicket.interfaces.IdeleteTicket;
>>>>>>> 5a2ea7b7154c35580472c415ac24ce2ced02e5a3:Group2/src/main/java/deleteTicket/deleteTicket.java

public class DeleteTicket implements IDeleteTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private String ConfigurationFile = "ConfigurationFile";
	
	private IConnectionManager IConnectionMng;
	
	public DeleteTicket(IConnectionManager IConnectionMng)
	{
		this.IConnectionMng =IConnectionMng ;
	}

	public boolean deleteticket(String ticketId)
	{
		try 
		{
			connect = IConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call deleteticket(?)}");
			SPstatement.setString(1,ticketId);
			SPstatement.execute();
			IConnectionMng.closeConnection();
			return true;
		} 
		catch (SQLException e)
		{
				e.printStackTrace();
				return false;
		}
	}			
}
