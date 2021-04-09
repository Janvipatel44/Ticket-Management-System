package updateTicketDetails;

import java.text.ParseException;

import updateTicketDetails.interfaces.IUpdateTicket;

public class UpdateTicketTestMock  implements IUpdateTicket
{

	public boolean updateValueOfTicketForManager(String ticketID, int choice, String valueToUpdate)
	{
//		boolean result = false;
//		if(choice == 7) 
//		{
//			result =changeTicketSatatus(ticketID,valueToUpdate);
//		}
//		else
//		{
//			result =ticketExist(ticketID);
//		}
//		return result;
//	}
//	
//	public boolean updateValueOfTicketForNotManager(String ticketID, String valueToUpdate) throws ParseException
//	{
//		boolean result;
//		result =changeTicketSatatus(ticketID,valueToUpdate);
//		return result;
//	
		return true;
	}
	private boolean ticketExist(String ticketID)
	{
//		String ticketId = "111";
//		if(ticketId.equals(ticketID))
//		{
//			return true;
//		}
//		else 
//		{
//			return false;
//		}
		return true;
	}

    private boolean changeTicketSatatus(String ticketID, String valueToUpdate) 
	{
//		IUpdateTicketDetailsfactoryTest updateticketsdetailsfactore = UpdateTicketDetailsfactoryTest.instance();
//		boolean result=false;
//		double hour=0;
//		String previousInProgressTicket = "in progress";
//		String previousOnHoldTicket = "on hold";
//		 result = ticketExist(ticketID);
//		 if(result == true && previousInProgressTicket.equals(valueToUpdate))
//		 {
//			 hour = ticketinprogress.calculateHours(ticketID);
//		 }
//		 else if(result == true && previousOnHoldTicket.equals(valueToUpdate))
//		 {
//			 hour = ticketinprogress.calculateHours(ticketID);
//		 }
//		 else
//		 {
//			result = false; 
//		 }
//		if(hour == 1)
//		{
//			result = true;
//		}
//		return  result;
    	return true;
	}
	@Override
	public boolean updateValueOfTicketForNotManager(String ticketID, String valueToUpdate) throws ParseException {
		// TODO Auto-generated method stub
		return false;
	}
}
