package updateTicketDetails.abstractfactory;

import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.ticketStatusInProgressMock;
import updateTicketDetails.updateTicketTestMock;
import updateTicketDetails.interfaces.IupdateTicket;

public class updateTicketDetailsfactoryTest implements IupdateTicketDetailsfactoryTest
{
	private static IupdateTicketDetailsfactoryTest uniqueInstance = null;

    private updateTicketDetailsfactoryTest()
    {

    }

    public static IupdateTicketDetailsfactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new updateTicketDetailsfactoryTest();
        }
        return uniqueInstance;
    }
	
    public  IticketStatusInProgress ticketInProgressMock()
    {
    	return new ticketStatusInProgressMock();
    }
    
    public IupdateTicket updateticketMock()
    {
    	return new updateTicketTestMock();
    }


}
