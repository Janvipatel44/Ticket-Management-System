package reuseableClasses.abstractfactory;

import reuseablePackage.interfaces.ICheckTicketExists;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;

public abstract class ReuseableClassesFactoryAbsTest
{
	public abstract ICheckTicketExists checkticketexistMock();
	public abstract IGetListOfTickets getlistofticketsMock();
	public abstract IExportTicket exportticketdataMock();
	public abstract IOpenTicket openticketMock();
}
