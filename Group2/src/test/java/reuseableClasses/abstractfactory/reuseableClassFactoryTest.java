package reuseableClasses.abstractfactory;

import reuseableClasses.checkTicketExistsMock;
import reuseableClasses.exportTicketDataMock;
import reuseableClasses.getListOfTicketsMock;
import reuseableClasses.openTicketMock;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IexportTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;

public class reuseableClassFactoryTest implements IreuseableClassesFactoryTest
{
	private static IreuseableClassesFactoryTest uniqueInstance = null;

    private reuseableClassFactoryTest()
    {

    }

    public static IreuseableClassesFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new reuseableClassFactoryTest();
        }
        return uniqueInstance;
    }

	public IcheckTicketExists checkticketexistMock()
	{
		return new checkTicketExistsMock();
	}
	public IgetListOfTickets getlistofticketsMock()
	{
		return new getListOfTicketsMock();
	}
	public IexportTicket exportticketdataMock()
	{
		return new exportTicketDataMock();
	}
	public IopenTicket openticketMock()
	{
		return new openTicketMock();
	}
}
