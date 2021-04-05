package comments.abstractfactory;

import commentOnTicket.interfaces.IcommentOnTicket;
import comments.commentOnTicketMock;

public class commentOnTicketFactoryTest implements IcommentOnTicketFactoryTest
{
	private static commentOnTicketFactoryTest uniqueInstance = null;

    private commentOnTicketFactoryTest()
    {

    }

    public static IcommentOnTicketFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new commentOnTicketFactoryTest();
        }
        return uniqueInstance;
    }

	public IcommentOnTicket commentonticketMock()
	{
		return new commentOnTicketMock();
	}
	
}
