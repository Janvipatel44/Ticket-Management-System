package reuseableClasses.abstractfactory;

import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;

public abstract class ReuseableClassesFactoryAbsTest
{
	public abstract ICheckTicketsExists checkticketexistMock();
	public abstract IGetListOfTickets getlistofticketsMock();
	public abstract IExportTicket exportticketdataMock();
	public abstract IOpenTicket openticketMock();
}
