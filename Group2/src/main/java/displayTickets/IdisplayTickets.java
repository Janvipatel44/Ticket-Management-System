package displayTickets;

import java.sql.ResultSet;
import java.util.List;

public interface IdisplayTickets 
{
	public void displaySearchedOutput(ResultSet resultSet);
	public void openTicket(String ticketID);
}
