package reuseableClasses.abstractfactory;

import reuseableClasses.CheckTicketExistsMock;
import reuseableClasses.GetListOfTicketsMock;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IGetListOfTickets;
import searchTicket.ExportTicketDataMock;
import searchTicket.OpenTicketMock;
import searchTicket.interfaces.IExportTicket;
import searchTicket.interfaces.IOpenTicket;

public class ReuseableClassFactoryTest implements IReuseableClassesFactoryTest
{
	private static IReuseableClassesFactoryTest uniqueInstance = null;

    private ReuseableClassFactoryTest()
    {

    }

    public static IReuseableClassesFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new ReuseableClassFactoryTest();
        }
        return uniqueInstance;
    }

	public ICheckTicketsExists checkticketexistMock()
	{
		return new CheckTicketExistsMock();
	}
	public IGetListOfTickets getlistofticketsMock()
	{
		return new GetListOfTicketsMock();
	}

	public IExportTicket exportticketdataMock()
	{
		return new ExportTicketDataMock();
	}

	public IOpenTicket openticketMock()
	{
		return new OpenTicketMock();
	}
}
