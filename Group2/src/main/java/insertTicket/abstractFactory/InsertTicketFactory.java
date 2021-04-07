package insertTicket.abstractFactory;

import insertTicket.CreateTicket;
import insertTicket.InputDateValidation;
import insertTicket.InputRangeValidation;
import insertTicket.InputStringValidation;
import insertTicket.InsertTicket;
import insertTicket.TicketOperationsDB;
import insertTicket.UserInputValidation;
import insertTicket.Interfaces.IInputDateValidation;
import insertTicket.Interfaces.IInputRangeValidation;
import insertTicket.Interfaces.IInputStringValidation;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.Interfaces.ITicketOperationsDB;
import insertTicket.Interfaces.IUserInputTicket;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IUserInputValidation;

public class InsertTicketFactory implements IInsertTicketFactory {
	private static IInsertTicketFactory uniqueInstance = null;

    private InsertTicketFactory()
    {
    	
    }

    public static IInsertTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new InsertTicketFactory();
        }
        return uniqueInstance;
    }

    public 	IUserInputValidation validation()  {
		// TODO Auto-generated method stub
		return new UserInputValidation();
	}

    public 	ICreateTicket getcreateTicket(String ticketID, String description,  String expectedEndDate, String reporterID,
			String employeeID,  String assigneeName, String ticketType, String ticketStatus, int priority, int urgency, int impact,
			String ticketLevel, String customerID, String customerName, String creatorID, String creatorName)  {
		// TODO Auto-generated method stub
		return new CreateTicket(  ticketID,  description,   expectedEndDate,  reporterID,
				 employeeID,   assigneeName,  ticketType,  ticketStatus,  priority,  urgency,  impact,
				 ticketLevel,  customerID,  customerName,  creatorID, creatorName);
	}
    
    public 	IInputStringValidation ticketStringValidation()
    {
    	return new InputStringValidation();
    }
    
    public 	IInputDateValidation dateValidation()
    {
    	return new InputDateValidation();
    }
    
    public 	IInputRangeValidation rangeValidation() 
    {
    	return new InputRangeValidation();
    }
    

    public ITicketOperationsDB insertTicketDB(ICreateTicket createTicket) 
    {
    	return new TicketOperationsDB(createTicket);
    }
    
   
    public IInsertTicket insertTicket(ICreateTicket createTicket) 
    {	
    	return new InsertTicket(createTicket);
    }

}
