package insertTicket.Interfaces;

import java.text.ParseException;

public interface IInsertTicket {
	
	public boolean userInputTicketDetails() throws ParseException;
	//public boolean validateInsertion() throws ParseException;
	public void successfulInsertion() throws ParseException;
}
