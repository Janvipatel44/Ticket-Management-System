package comments.abstractfactory;

import commentOnTicket.interfaces.ICommentOnTicket;
import comments.CommentOnTicketMock;

public class CommentOnTicketFactoryTest implements ICommentOnTicketFactoryTest
{
	private static CommentOnTicketFactoryTest uniqueInstance = null;

    private CommentOnTicketFactoryTest()
    {

    }

    public static ICommentOnTicketFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new CommentOnTicketFactoryTest();
        }
        return uniqueInstance;
    }

	public ICommentOnTicket commentonticketMock()
	{
		return new CommentOnTicketMock();
	}
	
}
