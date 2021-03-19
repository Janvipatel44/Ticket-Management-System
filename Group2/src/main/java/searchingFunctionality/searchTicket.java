package searchingFunctionality;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBConn;
import database.ConnectionManager;
import database.IConnectionManager;
import displayTickets.IdisplayTicket;
import displayTickets.displayTicket;

public class searchTicket implements IsearchTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	private String ConfigurationFile = "ConfigurationFile";
	
	private IdisplayTicket callObj=new displayTicket();
	private IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	@Override
	public void searchbyTicket(int choice, String searchInput) 
	{
		try 
		{
			connect = IConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call searchTicket(?,?)}");
			SPstatement.setLong(1,choice);
			SPstatement.setString(2,searchInput);
			hasResult=SPstatement.execute();
			if(hasResult) {
			    resultSet = SPstatement.getResultSet();
			    System.out.println("hasresult:"+hasResult + "resultset:"+resultSet );
				callObj.displaySearchedOutput(resultSet);
			}
	
			IConnectionMng.closeConnection();
		} 
		catch (SQLException e)
		{
				e.printStackTrace();
		}
	}
}
