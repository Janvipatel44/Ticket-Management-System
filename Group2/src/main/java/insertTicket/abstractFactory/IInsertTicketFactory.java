package insertTicket.abstractFactory;

import database.ITicketOperationsDB;

import insertTicket.Interfaces.IInputDateValidation;
import insertTicket.Interfaces.IInputRangeValidation;
import insertTicket.Interfaces.IInputStringValidation;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.Interfaces.IUserInputTicket;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IUserInputValidation;

public interface IInsertTicketFactory {


    public 	IUserInputValidation validation() ;
    public 	ICreateTicket getcreateTicket(String ticketID, String description,  String expectedEndDate, String reporterID,
			String employeeID,  String assigneeName, String ticketType, String ticketStatus, int priority, int urgency, int impact,
			String ticketLevel, String customerID, String customerName, String creatorID, String creatorName);
    
    public 	IInputStringValidation ticketStringValidation();
    
    public 	IInputDateValidation dateValidation();
    
    public 	IInputRangeValidation rangeValidation();
	
    public 	IUserInputTicket inputTicket(); 

    public  ITicketOperationsDB insertTicketDB(ICreateTicket createTicket);
    public IInsertTicket insertTicket(ICreateTicket createTicket); 

}
