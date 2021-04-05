package deleteTicket;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import deleteTicket.abstractfactory.IdeleteTicketfactoryTest;
import deleteTicket.abstractfactory.deleteTicketfactoryTest;
import deleteTicket.interfaces.IdeleteTicket;
import reuseableClasses.abstractfactory.IreuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.reuseableClassFactoryTest;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IgetListOfTickets;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class deleteTicketTest 
{
	
	IInputOutputHandler inputoutputhandler = new InputOutputHandler();
	IdeleteTicketfactoryTest deleteticketfactory = deleteTicketfactoryTest.instance();
	IdeleteTicket deleteticket = deleteticketfactory.deleteTicketMock();
	
	IreuseableClassesFactoryTest resueableclassesfactory = reuseableClassFactoryTest.instance();
	IgetListOfTickets getlistofticket = resueableclassesfactory.getlistofticketsMock();
	IcheckTicketExists checkticketexist = resueableclassesfactory.checkticketexistMock();
	
	
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
