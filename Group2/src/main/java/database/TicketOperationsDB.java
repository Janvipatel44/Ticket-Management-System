package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import insertTicket.Interfaces.ICreateTicket;

import java.sql.CallableStatement;

public class TicketOperationsDB implements ITicketOperationsDB{

	private Connection connection;
	private String ConfigurationFile = "ConfigurationFile.txt";
 
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	ICreateTicket createTicket = null;
    HashMap<String, String> inputsHandler = new HashMap<String, String>();

	public TicketOperationsDB(HashMap<String,String> inputsHandler) {
		this.inputsHandler = inputsHandler;
	}
	public boolean insertTicket()
	{
		connection = IConnectionMng.establishConnection();
        boolean success=false;
		try {
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call insertTicket(?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		
			//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
			//LocalDate dateTime = LocalDate.parse(inputsHandler.get("expectedEndDate"), dtf);
 
			System.out.print("Hashmap:" +inputsHandler);
			statement.setString(1, inputsHandler.get("ticketID"));
            statement.setString(2, inputsHandler.get("description") );
            statement.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
            statement.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));
            statement.setString(5, inputsHandler.get("reporterID"));
            statement.setString(6, inputsHandler.get("employeeID"));
            statement.setString(7, inputsHandler.get("assigneeName") );
            statement.setString(8, inputsHandler.get("ticketType")  );
            //Integer.parseInt(inputsHandler.get("urgency"))
            statement.setInt(9, '1' );
            statement.setInt(10, '2' );
            statement.setInt(11, '3');
            statement.setString(12, inputsHandler.get("ticketLevel") );
            statement.setString(13, inputsHandler.get("customerID") );
            statement.setString(14, inputsHandler.get("customerName"));
            statement.setString(15, inputsHandler.get("creatorID") );
            statement.setString(16,  inputsHandler.get("creatorName"));

	        statement.execute();
	        success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return success;
	}	
	
	/*public boolean duplicateTicket() {
		
		connection = IConnectionMng.establishConnection();
		int duplicate_ticket = 0;
        boolean success=false;
		try {
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call duplicateTicket(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			statement.setString(1, createTicket.getTicketID());
            statement.setString(2, createTicket.getDescription() );
            statement.setDate(3, java.sql.Date.valueOf(createTicket.getStartDate()) );
            statement.setDate(4, java.sql.Date.valueOf(createTicket.getEndDate()) );
            statement.setString(5, createTicket.getReporterID() );
            statement.setString(6, createTicket.getEmployeeID() );
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
	}*/
}
