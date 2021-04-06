package updateTicketDetails;

import reuseablePackage.interfaces.IticketStatusInProgress;

public class ticketStatusInProgressMock implements IticketStatusInProgress
{
	public double calculateHours(String ticketID) 
	{
		double hours=1;
		return  hours;
	}
}
