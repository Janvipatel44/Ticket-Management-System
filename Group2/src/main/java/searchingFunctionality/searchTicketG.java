package searchingFunctionality;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBConn;
import database.ConnectionManager;
import database.IConnectionManager;

public class searchTicketG implements IsearchTicket{
	//Database connectoion
	
	
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	private String ConfigurationFile = "ConfigurationFile";
	private searchedOutput callObj=new searchedOutput();
	
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	@Override
	public boolean searchbyTicket(int choice, String searchtype) {
		try {
			connect = IConnectionMng.establishConnection();
			//Stored Procedure call that finds tickets from the system as per the user requirement 
			SPstatement = connect.prepareCall("{call searchTicket(?,?)}");
			//first parameter decided search option 
			SPstatement.setLong(1,choice);
			//second parameter passes search value
			SPstatement.setString(2,searchtype);
			hasResult=SPstatement.execute();
			if(hasResult) {
				//store tickets that matches with user requirement
			    resultSet = SPstatement.getResultSet();
			    System.out.println("hasresult:"+hasResult + "resultset:"+resultSet );
			    //pass string to display tickets on user screen
				boolean result=callObj.displaySearchedOutput(resultSet);
				return result;
			}
			
			//close DB connection
			IConnectionMng.closeConnection();
			
		} 
		catch (SQLException e) {
				e.printStackTrace();
		}
		return false;
	}
}
