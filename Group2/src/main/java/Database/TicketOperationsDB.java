package database;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.CallableStatement;

import Tickets.ICreateTicket;

public class TicketOperationsDB implements ITicketOperationsDB{

	private Connection connection;
	private String ConfigurationFile = "ConfigurationFile.txt";
 
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	ICreateTicket createTicket = null;
	public TicketOperationsDB(ICreateTicket createTicket) {
		this.createTicket = createTicket;
	}
	public boolean insertTicket()
	{
		connection = IConnectionMng.establishConnection();
        boolean success=false;
		try {
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call insertTicket(?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			statement.setString(1, createTicket.getTicketId());
            statement.setString(2, createTicket.getDescription() );
            statement.setDate(3, java.sql.Date.valueOf(createTicket.getStartDate()) );
            statement.setDate(4, java.sql.Date.valueOf(createTicket.getEndDate()) );
            statement.setString(5, createTicket.getReporterId() );
            statement.setString(6, createTicket.getEmployeeId() );
            statement.setString(7, createTicket.getAssigneeName() );
            statement.setString(8, createTicket.getTicketType() );
            statement.setInt(9, createTicket.getPriority() );
            statement.setInt(10, createTicket.getUrgency() );
            statement.setInt(11, createTicket.getImpact() );
            statement.setString(12, createTicket.getTicketLevel() );
            statement.setString(13, createTicket.getCustomerName() );
            statement.setInt(14, createTicket.getRating() );
            statement.setString(15, createTicket.getCreatorName() );
            statement.setString(16, createTicket.getAttachmentID() );

	        statement.execute();
	        success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return success;
	}	
	
	public boolean duplicateTicket() {
		
		connection = IConnectionMng.establishConnection();
		int duplicate_ticket = 0;
        boolean success=false;
		try {
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call duplicateTicket(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			statement.setString(1, createTicket.getTicketId());
            statement.setString(2, createTicket.getDescription() );
            statement.setDate(3, java.sql.Date.valueOf(createTicket.getStartDate()) );
            statement.setDate(4, java.sql.Date.valueOf(createTicket.getEndDate()) );
            statement.setString(5, createTicket.getReporterId() );
            statement.setString(6, createTicket.getEmployeeId() );
            statement.setString(7, createTicket.getAssigneeName() );
            statement.setString(8, createTicket.getTicketType() );
            statement.setInt(9, createTicket.getPriority() );
            statement.setInt(10, createTicket.getUrgency() );
            statement.setInt(11, createTicket.getImpact() );
            statement.setString(12, createTicket.getTicketLevel() );
            statement.setString(13, createTicket.getCustomerName() );
            statement.setInt(14, createTicket.getRating() );
            statement.setString(15, createTicket.getCreatorName() );
            statement.setString(16, createTicket.getAttachmentID() );
            statement.setInt(17, java.sql.Types.INTEGER);  

            statement.execute();
            duplicate_ticket = statement.getInt(17);
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
