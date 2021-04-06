package deleteTicket.abstractfactory;

import deleteTicket.deleteTicketMock;
import deleteTicket.interfaces.IdeleteTicket;

public class deleteTicketfactoryTest implements IdeleteTicketfactoryTest {
	private static IdeleteTicketfactoryTest uniqueInstance = null;

    private deleteTicketfactoryTest()
    {

    }

    public static IdeleteTicketfactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new deleteTicketfactoryTest();
        }
        return uniqueInstance;
    }

	public IdeleteTicket deleteTicketMock() {
		return new deleteTicketMock();
	}
	
}
