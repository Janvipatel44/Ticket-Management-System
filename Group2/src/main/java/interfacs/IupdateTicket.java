package interfacs;

import java.text.ParseException;

public interface IupdateTicket 
{
	public boolean updateValueOfTicketForManager(String ticketID, int choice , String valueToUpdate);
	public boolean updateValueOfTicketForNotManager(String ticketID,String valueToUpdate) throws ParseException;
}
