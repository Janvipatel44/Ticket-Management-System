package insertTickets;

import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.Test;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IInsertTicket;
import insertTickets.abstractfactory.IInsertTicketTestFactory;
import insertTickets.abstractfactory.InsertTicketTestFactory;

public class InsertTicketTest 
{
	String ticketID = "12346"; 
	String description = "Employee Efficiency"; 
	String expectedEndDate = "2021-01-01 12:00:00"; 
	String reporterID = "emp123";
	String employeeID = "emp456";  
	String assigneeName = "Janvi Patel"; 
	String ticketType = "Feature";
	String ticketStatus = "";
	int priority = 1;
	int urgency = 2;
	int impact = 5;
	String ticketLevel = "Easy"; 
	String customerID = "cus123";
	String customerName = "Elegant Microweb";
	String creatorID = "creator55";
	String creatorName = "";
	String attachmentId = "gyftdseyGek";

	IInsertTicketTestFactory insertTicketTestFactory = InsertTicketTestFactory.instance();
	IInsertTicket insertTicket ;
	
	@Test
	public void successfulGenerationTicket() 
	{
		ICreateTicket createTicket = insertTicketTestFactory.getcreateTicket(ticketID,  description,   expectedEndDate,  reporterID,
				 employeeID,   assigneeName,  ticketType,  ticketStatus,  priority,  urgency,  impact,
				 ticketLevel,  customerID,  customerName,  creatorID, creatorName, attachmentId);
		insertTicket = insertTicketTestFactory.insertTicket(createTicket);
		try {
			assertTrue(insertTicket.successfulInsertion());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void duplicateTicket()
	{
		
		ticketID = "111";
		ICreateTicket createTicket = insertTicketTestFactory.getcreateTicket(ticketID,  description,   expectedEndDate,  reporterID,
				 employeeID,   assigneeName,  ticketType,  ticketStatus,  priority,  urgency,  impact,
				 ticketLevel,  customerID,  customerName,  creatorID, creatorName, attachmentId);
		
		insertTicket = insertTicketTestFactory.insertTicket(createTicket);
		try {
			assertTrue(insertTicket.successfulInsertion());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
