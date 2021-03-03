package sortTickets;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBConn;
import database.ConnectionManager;
import database.IConnectionManager;

public class sortTicket implements IsortTicket {
	DBConn obj=new DBConn();
	
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	private String ConfigurationFile = "ConfigurationFile";
	
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	@Override
	public void sortTickets(int choice) {
		try {
			connect = IConnectionMng.establishConnection();
			
			//Stored Procedure call that finds tickets from the system as per the user requirement 
			SPstatement = connect.prepareCall("{call sortTickets(?)}");
			//first parameter decided search option 
			SPstatement.setLong(1,choice);
			hasResult=SPstatement.execute();
			ResultSet resultSet=SPstatement.getResultSet();
			while (resultSet.next()) {	
			  	System.out.println(resultSet.getString("ticketId")+ " "
			   		+resultSet.getString("description")+ " "
			   		+resultSet.getString("startDate")+ " "
			   		+resultSet.getString("endDate")+ " "
			   		+resultSet.getString("reporterId")+ " "
			  		+resultSet.getString("employeeId")+ " "
			   		+resultSet.getString("assigneeName")+ " "
			   		+resultSet.getString("ticketType")+ " "
			   		+resultSet.getString("priority")+ " "
			   		+resultSet.getString("urgency")+ " "
			   		+resultSet.getString("impact")+ " "
			   		+resultSet.getString("comments"));
			}
			IConnectionMng.closeConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
