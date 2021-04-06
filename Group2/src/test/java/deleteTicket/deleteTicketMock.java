package deleteTicket;

import deleteTicket.interfaces.IdeleteTicket;

public class deleteTicketMock implements IdeleteTicket
{

	
	public boolean deleteticket(String ticketId) {
		return true;
	}

}
