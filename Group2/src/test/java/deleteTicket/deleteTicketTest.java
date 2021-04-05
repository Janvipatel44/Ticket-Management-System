package deleteTicket;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import deleteTicket.abstractfactory.IdeleteTicketfactoryTest;
import deleteTicket.abstractfactory.deleteTicketfactoryTest;
import deleteTicket.interfaces.IdeleteTicket;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import userinterface.IInputOutputHandler;

public class deleteTicketTest 
{
	
	
	IdeleteTicketfactoryTest deleteticketfactory = deleteTicketfactoryTest.instance();
	IInputOutputHandler inputoutputhandler= deleteticketfactory.inputoutputhandler();
	ITableGenerator tablegenerat = deleteticketfactory.tablegenerat();
	IdisplayTicket displayuser = deleteticketfactory.displayuser(tablegenerat);
	IgetListOfTickets getlistofticket = deleteticketfactory.getlistoftickets(displayuser);
	IcheckTicketExists checkticketexist = deleteticketfactory.checkticketexistsMock();
	IdeleteTicket deleteticket = deleteticketfactory.deleteTicketMock();
	
	@Test
	public void deleteTicketWithValidTicketIdandEmployeeId()
	{
		String ticketId = "111";
		String employeeId = "emp123";
		String output = getlistofticket.listOfTickets();
		inputoutputhandler.displayMethod(output);
		boolean result = checkticketexist.ticketExistForManager(ticketId, employeeId);
		if(result == true)
		{
			assertTrue(deleteticket.deleteticket(ticketId));
		}
		
	}
	
	@Test
	public void deleteTicketWithInValidTicketIdandEmployeeId()
	{
		String ticketId = "1112";
		String employeeId = "emp123";
		String output = getlistofticket.listOfTickets();
		inputoutputhandler.displayMethod(output);
		boolean result = checkticketexist.ticketExistForManager(ticketId, employeeId);
		if(result == true)
		{
			assertTrue(deleteticket.deleteticket(ticketId));
		}
		
	}
	
	@Test
	public void deleteTicketWithValidTicketIdandInEmployeeId()
	{
		String ticketId = "111";
		String employeeId = "emp1233";
		String output = getlistofticket.listOfTickets();
		inputoutputhandler.displayMethod(output);
		boolean result = checkticketexist.ticketExistForManager(ticketId, employeeId);
		if(result == true)
		{
			assertTrue(deleteticket.deleteticket(ticketId));
		}
		
	}

}
