package Tickets;

import java.text.ParseException;

public interface IInsertTicket {
	
	public void userInputTicketDetails() throws ParseException;
	public boolean validateInsertion() throws ParseException;
	public void successfulInsertion();
}
