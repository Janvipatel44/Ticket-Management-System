package insertTickets.abstractfactory;

import insertTicket.InsertTicket;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IInputDateValidation;
import insertTicket.Interfaces.IInputRangeValidation;
import insertTicket.Interfaces.IInputStringValidation;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.Interfaces.ITicketOperationsDB;
import insertTicket.Interfaces.IUserInputValidation;

public interface IInsertTicketTestFactory
{
	public IInputStringValidation ticketStringValidation();
    public IInputDateValidation dateValidation();
    public IInputRangeValidation rangeValidation();
    public ITicketOperationsDB insertTicketDB(ICreateTicket createTicket);
    public 	ICreateTicket getcreateTicket(String ticketID, String description,  String expectedEndDate, String reporterID,
			String employeeID,  String assigneeName, String ticketType, String ticketStatus, int priority, int urgency, int impact,
			String ticketLevel, String customerID, String customerName, String creatorID, String creatorName, String attachmentID);
    public IInsertTicket insertTicket(ICreateTicket createTicket); 
    public IUserInputValidation userInputValidation();

}

