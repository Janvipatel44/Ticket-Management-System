package updateTicketDetails.abstractfactory;

import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.ticketStatusInProgressMock;
import updateTicketDetails.UpdateTicketTestMock;
import updateTicketDetails.interfaces.IUpdateTicket;

public class UpdateTicketDetailsfactoryTest implements IUpdateTicketDetailsfactoryTest
{
	private static IUpdateTicketDetailsfactoryTest uniqueInstance = null;

    private UpdateTicketDetailsfactoryTest()
    {

    }

    public static IUpdateTicketDetailsfactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new UpdateTicketDetailsfactoryTest();
        }
        return uniqueInstance;
    }
	
    public  IticketStatusInProgress ticketInProgressMock()
    {
    	return new ticketStatusInProgressMock();
    }
    
    public IUpdateTicket updateticketMock()
    {
    	return new UpdateTicketTestMock();
    }


}
