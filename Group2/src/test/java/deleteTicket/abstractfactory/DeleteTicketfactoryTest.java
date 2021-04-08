package deleteTicket.abstractfactory;

import deleteTicket.DeleteTicketMock;
import deleteTicket.interfaces.IDeleteTicket;

public class DeleteTicketfactoryTest implements IDeleteTicketfactoryTest {
	private static IDeleteTicketfactoryTest uniqueInstance = null;

    private DeleteTicketfactoryTest()
    {

    }

    public static IDeleteTicketfactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new DeleteTicketfactoryTest();
        }
        return uniqueInstance;
    }

	public IDeleteTicket deleteTicketMock() {
		return new DeleteTicketMock();
	}
	
}
