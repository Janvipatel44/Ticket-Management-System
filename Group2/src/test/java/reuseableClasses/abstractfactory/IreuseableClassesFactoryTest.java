package reuseableClasses.abstractfactory;

import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;

public interface IreuseableClassesFactoryTest 
{
	IcheckTicketExists checkticketexistMock();
	IgetListOfTickets getlistofticketsMock();
	IopenTicket openticketMock();
}
