package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

import insertTicket.Interfaces.ICreateTicket;

import java.sql.CallableStatement;

public class TicketOperationsDB implements ITicketOperationsDB{

	private Connection connection;
	private String ConfigurationFile = "ConfigurationFile.txt";
 
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	ICreateTicket createTicket = null;
    HashMap<String, String> inputsHandler = new HashMap<String, String>();

	public TicketOperationsDB(ICreateTicket createTicket) {
		this.createTicket = createTicket;
	}
	public boolean insertTicket() throws ParseException
	{
		connection = IConnectionMng.establishConnection();
        boolean success=false;
		try {
			System.out.print("Insertion");
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call insertTicket(?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		
			
			statement.setString(1, createTicket.getTicketID());
            statement.setString(2, createTicket.getDescription() );
            statement.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
            statement.setTimestamp(4, new java.sql.Timestamp( createTicket.getExpectedEndDate().getTime()));
            statement.setString(5, createTicket.getReporterID());
            statement.setString(6, createTicket.getEmployeeID());
            statement.setString(7, createTicket.getAssigneeName());
            statement.setString(8, createTicket.getTicketType() );
            statement.setInt(9, createTicket.getPriority() );
            statement.setInt(10, createTicket.getUrgency());
            statement.setInt(11, createTicket.getImpact() );
            statement.setString(12, createTicket.getTicketLevel());
            statement.setString(13, createTicket.getCustomerID());
            statement.setString(14, createTicket.getCustomerName());
            statement.setString(15, createTicket.getCreatorID());
            statement.setString(16, createTicket.getCreatorName());

	        statement.execute();
	        success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return success;
	}	
	
	public boolean duplicateTicket() throws ParseException {
		
		connection = IConnectionMng.establishConnection();
		int duplicate_ticket = 0;
        boolean success=false;
		try {
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call duplicateTicket(?,?)}");

			statement.setString(1, createTicket.getTicketID());
            statement.execute();
            duplicate_ticket = statement.getInt(2);
            System.out.print("duplicate_ticket:" +duplicate_ticket);
			if(duplicate_ticket==0) {
			    success = false;
			}
			else {
				System.out.println("Duplicate Entry Found!!!");
				success = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
		return success;
	}
}
