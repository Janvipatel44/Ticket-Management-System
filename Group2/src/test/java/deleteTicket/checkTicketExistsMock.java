package deleteTicket;

import reuseablePackage.interfaces.IcheckTicketExists;

public class checkTicketExistsMock implements IcheckTicketExists

{
	int ticketExist = 0;

	public boolean ticketExists(String ticketID) {

		boolean result=false;
		try {
			fetchTicketForTicketID(ticketID);
			if(ticketExist == 1)
			{
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


	public boolean ticketExistForManager(String ticketID, String employeeID) {
		boolean result=false;
		try {
			fetchTicketForTicketID(ticketID);
			if(ticketExist == 1)
			{
				String creatorID = "emp123";
				if(creatorID.equals(employeeID)) {
					result = true;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


	public boolean ticketExistForNotManager(String ticketID, String employeeID) {
		boolean result=false;
		try {
			fetchTicketForTicketID(ticketID);
			if(ticketExist == 1)
			{
				String assigneeID = "emp123";
				if(assigneeID.equals(employeeID)) {
					result = true;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private void fetchTicketForTicketID(String ticketID) throws Exception
	{
		
		String ticketid = "111";
		if(ticketid.equals(ticketID))
		{
			ticketExist = 1;
		}
		
		
	}
}
