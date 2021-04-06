package reuseableClasses.abstractfactory;

import reuseableClasses.checkTicketExistsMock;
<<<<<<< HEAD
import reuseableClasses.exportTicketDataMock;
import reuseableClasses.getListOfTicketsMock;
import reuseableClasses.openTicketMock;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IexportTicket;
=======
import reuseableClasses.getListOfTicketsMock;
import reuseableClasses.openTicketMock;
import reuseablePackage.interfaces.IcheckTicketExists;
>>>>>>> c6eefe9a39d31e61d315bfad8c29b0da7afff01d
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
<<<<<<< HEAD
	public IexportTicket exportticketdataMock()
	{
		return new exportTicketDataMock();
	}
=======
<<<<<<< HEAD
=======
	
>>>>>>> e56b2235298b9593bd0c3cef8226877d954e1f08
>>>>>>> c6eefe9a39d31e61d315bfad8c29b0da7afff01d
	public IopenTicket openticketMock()
	{
		return new openTicketMock();
	}
}
