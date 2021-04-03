package insertTicket.Interfaces;

import java.text.ParseException;
import java.util.HashMap;

public interface IInsertTicket {
	
	public HashMap<String,String> userInputTicketDetails() throws ParseException;
	public boolean validateInsertion() throws ParseException;
	public void successfulInsertion() throws ParseException;
}
