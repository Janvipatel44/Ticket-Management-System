package updateTicketDetails;

import java.text.ParseException;

import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.abstractfactory.IupdateTicketDetailsfactoryTest;
import updateTicketDetails.abstractfactory.updateTicketDetailsfactoryTest;
import updateTicketDetails.interfaces.IupdateTicket;

public class updateTicketTestMock  implements IupdateTicket
{

	public boolean updateValueOfTicketForManager(String ticketID, int choice, String valueToUpdate) {
		boolean result = false;
		if(choice == 7) 
		{
			result =changeTicketSatatus(ticketID,valueToUpdate);
		}
		else
		{
			result =ticketExist(ticketID);
		}
		return result;
	}
	
	public boolean updateValueOfTicketForNotManager(String ticketID, String valueToUpdate) throws ParseException
	{
		boolean result;
		result =changeTicketSatatus(ticketID,valueToUpdate);
		return result;
		
	}
	
	private boolean ticketExist(String ticketID)
	{
		String ticketId = "111";
		if(ticketId.equals(ticketID))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	private boolean changeTicketSatatus(String ticketID, String valueToUpdate) 
	{
		IupdateTicketDetailsfactoryTest updateticketsdetailsfactore = updateTicketDetailsfactoryTest.instance();
		IticketStatusInProgress ticketinprogress = updateticketsdetailsfactore.ticketInProgressMock();
		boolean result=false;
		double hour=0;
		String previousInProgressTicket = "in progress";
		String previousOnHoldTicket = "on hold";
		 result = ticketExist(ticketID);
		 if(result == true && previousInProgressTicket.equals(valueToUpdate))
		 {
			 hour = ticketinprogress.calculateHours(ticketID);
		 }
		 else if(result == true && previousOnHoldTicket.equals(valueToUpdate))
		 {
			 hour = ticketinprogress.calculateHours(ticketID);
		 }
		 else
		 {
			result = false; 
		 }
		if(hour == 1)
		{
			result = true;
		}
		return  result;
	}
}
