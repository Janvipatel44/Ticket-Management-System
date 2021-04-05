package deleteTicket.abstractfactory;

import deleteTicket.checkTicketExistsMock;
import deleteTicket.deleteTicketMock;
import deleteTicket.getListOfTicketMock;
import deleteTicket.interfaces.IdeleteTicket;
import reuseablePackage.TableGenerator;
import reuseablePackage.displayTicket;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

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

	public IcheckTicketExists checkticketexistsMock()
	{
		return new checkTicketExistsMock();
	}
	
	public IgetListOfTickets getlistoftickets(IdisplayTicket displayUser)
	{
		return new getListOfTicketMock(displayUser);
	}
	
	public IInputOutputHandler inputoutputhandler() {
		return new InputOutputHandler();
	}
	public ITableGenerator tablegenerat()
	{
		return new TableGenerator();
	}
	public IdisplayTicket displayuser(ITableGenerator tablegenerat)
	{
		return new displayTicket(tablegenerat);
	}

	public IdeleteTicket deleteTicketMock() {
		return new deleteTicketMock();
	}
	
}
