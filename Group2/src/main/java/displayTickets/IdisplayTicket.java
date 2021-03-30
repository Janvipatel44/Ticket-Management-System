package displayTickets;

import java.sql.ResultSet;

public interface IdisplayTicket 
{
	public void displaySearchedOutput(ResultSet resultSet);

	public void openTicket(String ticketID);
}
