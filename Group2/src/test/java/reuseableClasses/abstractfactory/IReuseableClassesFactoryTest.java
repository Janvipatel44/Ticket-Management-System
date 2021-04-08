package reuseableClasses.abstractfactory;

import reuseablePackage.interfaces.ICheckTicketExists;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;

public interface IReuseableClassesFactoryTest 
{
	ICheckTicketExists checkticketexistMock();
	IGetListOfTickets getlistofticketsMock();

	IExportTicket exportticketdataMock();
	IOpenTicket openticketMock();
}
