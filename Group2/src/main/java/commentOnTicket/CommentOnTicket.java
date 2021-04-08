package commentOnTicket;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import commentOnTicket.interfaces.ICommentOnTicket;
import database.IConnectionManager;

public class CommentOnTicket implements ICommentOnTicket
{

	private SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date(System.currentTimeMillis());
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private String ConfigurationFile = "ConfigurationFile";
	
	private IConnectionManager IConnectionMng;
	
	public CommentOnTicket(IConnectionManager IConnectionMng )
	{
		this.IConnectionMng = IConnectionMng; 
	}
	
	public boolean postCommentOnticket(String ticketId, String employeeID, String comment)
	{
		String dateInfo = formatter.format(date);

		try 
		{
			connect = IConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call postCommentOnTicket(?,?,?,?)}");
			SPstatement.setString(1,ticketId);
			SPstatement.setString(2,employeeID);
			SPstatement.setString(3,dateInfo);
			SPstatement.setString(4,comment);
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
