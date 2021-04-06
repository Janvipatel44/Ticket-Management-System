package reuseableClasses.abstractfactory;

import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IopenTicket;

public abstract class reuseableClassesFactoryAbsTest
{
	public abstract IcheckTicketExists checkticketexistMock();
	public abstract IgetListOfTickets getlistofticketsMock();
	public abstract IopenTicket openticketMock();
}
