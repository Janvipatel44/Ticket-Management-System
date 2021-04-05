package reuseableClasses.abstractfactory;

import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IexportTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;

public interface IreuseableClassesFactoryTest 
{
	IcheckTicketExists checkticketexistMock();
	IgetListOfTickets getlistofticketsMock();
	IexportTicket exportticketdataMock();
	IopenTicket openticketMock();
}
