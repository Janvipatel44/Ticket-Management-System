package insertTicket;

import java.text.ParseException;

import database.ITicketOperationsDB;
import database.TicketOperationsDB;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;

public class InsertTicket implements IInsertTicket
{
	IInsertTicketFactory  insertTicketFactory = InsertTicketFactory.instance();

	ITicketOperationsDB ticketOperationDB;
	ICreateTicket createTicket;
	
	public InsertTicket(ICreateTicket createTicket){
		this.createTicket = createTicket;
	}
	public void successfulInsertion() throws ParseException
	{
		boolean result = false;
	
		try {
			System.out.print("In insert");
			ticketOperationDB = insertTicketFactory.insertTicketDB(createTicket);
			result = ticketOperationDB.duplicateTicket();
			if(result==false) {
				result = ticketOperationDB.insertTicket();
				System.out.print(result);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.print("Hello");
			e.printStackTrace();
		}
	}
}
