package deleteTicket;

import deleteTicket.interfaces.IDeleteTicket;

public class DeleteTicketMock implements IDeleteTicket
{

	
	public boolean deleteticket(String ticketId) {
		return true;
	}

}
