package comments;

import reuseablePackage.interfaces.IcheckTicketExists;

public class CheckTicketExistsMock implements IcheckTicketExists
{
	private String ticketId = "12456";
	public boolean ticketExists(String ticketID)
	{
		if(ticketId.equals(ticketID))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
