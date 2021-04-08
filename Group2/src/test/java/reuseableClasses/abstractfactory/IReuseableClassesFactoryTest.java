package reuseableClasses.abstractfactory;

import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IGetListOfTickets;
import searchTicket.interfaces.IExportTicket;
import searchTicket.interfaces.IOpenTicket;

public interface IReuseableClassesFactoryTest 
{
	ICheckTicketsExists checkticketexistMock();
	IGetListOfTickets getlistofticketsMock();

	IExportTicket exportticketdataMock();
	IOpenTicket openticketMock();
}
