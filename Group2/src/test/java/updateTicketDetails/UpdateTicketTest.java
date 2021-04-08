package updateTicketDetails;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

import reuseableClasses.abstractfactory.IReuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.ReuseableClassFactoryTest;
import reuseablePackage.interfaces.ICheckTicketsExists;
import updateTicketDetails.abstractfactory.IUpdateTicketDetailsfactoryTest;
import updateTicketDetails.abstractfactory.UpdateTicketDetailsfactoryTest;
import updateTicketDetails.interfaces.IUpdateTicket;

public class UpdateTicketTest {

	IReuseableClassesFactoryTest reuseableClassFactorytest = ReuseableClassFactoryTest.instance();
	IUpdateTicketDetailsfactoryTest updateticketsdetailsfactore = UpdateTicketDetailsfactoryTest.instance();
	IUpdateTicket updateticketdetails = updateticketsdetailsfactore.updateticketMock();
	ICheckTicketsExists checkticketexists = reuseableClassFactorytest.checkticketexistMock();
	
	@Test
	public void updateForManagerWithValidTicketIDAndValidEmployeeID() {
		String ticketID = "111";
		String employeeID="emp123";
		String valuetoupdateAssigneeNamer = "manan";
		String valuesToUpdateInProgress="in progress";
		String valuesToUpdateOnHold="on hold";
		String valuesToUpdatedone="done";
		int choice = 3;
		int choiceForchangeTicketStatus = 7;
		boolean result = checkticketexists.ticketExistForManager(ticketID);
		if(result == true) {
			assertTrue(updateticketdetails.updateValueOfTicketForManager(ticketID, choice, valuetoupdateAssigneeNamer));
			assertTrue(updateticketdetails.updateValueOfTicketForManager(ticketID, choiceForchangeTicketStatus, valuesToUpdateInProgress));
			assertTrue(updateticketdetails.updateValueOfTicketForManager(ticketID, choiceForchangeTicketStatus, valuesToUpdateOnHold));
			
		}
		
	}
	
	@Test
	public void updateForManagerWithInvalidValidTicketIDAndValidEmployeeID() {
		String ticketID = "112";
		String employeeID="emp123";
		String valuetoupdateAssigneeNamer = "manan";
		String valuesToUpdateInProgress="in progress";
		String valuesToUpdateOnHold="On hold";
		String valuesToUpdatedone="done";
		int choice = 3;
		int choiceForchangeTicketStatus = 7;
		boolean result = checkticketexists.ticketExistForManager(ticketID);
		if(result == false) {
			assertFalse(updateticketdetails.updateValueOfTicketForManager(ticketID, choice, valuetoupdateAssigneeNamer));
			assertFalse(updateticketdetails.updateValueOfTicketForManager(ticketID, choiceForchangeTicketStatus, valuesToUpdateInProgress));
			assertFalse(updateticketdetails.updateValueOfTicketForManager(ticketID, choiceForchangeTicketStatus, valuesToUpdateOnHold));
			
		}
		
	}

	
	@Test
	public void updateForManagerWithValidTicketIDAndInValidEmployeeID() {
		String ticketID = "111";
		String employeeID="emp1233";
		String valuetoupdateAssigneeNamer = "manan";
		String valuesToUpdateInProgress="in progress";
		String valuesToUpdateOnHold="on hold";
		String valuesToUpdatedone="done";
		int choice = 3;
		int choiceForchangeTicketStatus = 7;
		boolean result = checkticketexists.ticketExistForManager(ticketID);
		if(result == true)
		{
			assertFalse(updateticketdetails.updateValueOfTicketForManager(ticketID, choice, valuetoupdateAssigneeNamer));
			assertFalse(updateticketdetails.updateValueOfTicketForManager(ticketID, choiceForchangeTicketStatus, valuesToUpdateInProgress));
			assertFalse(updateticketdetails.updateValueOfTicketForManager(ticketID, choiceForchangeTicketStatus, valuesToUpdateOnHold));
			
		}
		
	}
	
	@Test
	public void updateForManagerWithCloseTicket() {
		String ticketID = "111";
		String employeeID="emp123";
		String valuetoupdateAssigneeNamer = "manan";
		String valuesToUpdateInProgress="in progress";
		String valuesToUpdateOnHold="On hold";
		String valuesToUpdatedone="done";
		int choice = 3;
		int choiceForchangeTicketStatus = 7;
		boolean result = checkticketexists.ticketExistForManager(ticketID);
		if(result == true) {
			assertFalse(updateticketdetails.updateValueOfTicketForManager(ticketID, choiceForchangeTicketStatus, valuesToUpdatedone));
	
		}
	}

	@Test
	public void updateForNotManagerWithValidTicketIDAndValidEmployeeID() {
		String ticketID = "111";
		String employeeID="emp123";
		String valuetoupdateAssigneeNamer = "manan";
		String valuesToUpdateInProgress="in progress";
		String valuesToUpdateOnHold="on hold";
		String valuesToUpdatedone="done";
		int choice = 3;
		int choiceForchangeTicketStatus = 7;
		boolean result = checkticketexists.ticketExistForManager(ticketID);
		if(result == true) 
		{
			try {
			
				assertTrue(updateticketdetails.updateValueOfTicketForNotManager(ticketID, valuesToUpdateInProgress));
				assertTrue(updateticketdetails.updateValueOfTicketForNotManager(ticketID, valuesToUpdateOnHold));
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
			
	}
	
	@Test
	public void updateForNotManagerWithInvalidValidTicketIDAndValidEmployeeID() {
		String ticketID = "112";
		String employeeID="emp123";
		String valuetoupdateAssigneeNamer = "manan";
		String valuesToUpdateInProgress="in progress";
		String valuesToUpdateOnHold="On hold";
		String valuesToUpdatedone="done";
		int choice = 3;
		int choiceForchangeTicketStatus = 7;
		boolean result = checkticketexists.ticketExistForManager(ticketID);
		if(result == true) {
			try 
			{
				assertFalse(updateticketdetails.updateValueOfTicketForNotManager(ticketID, valuesToUpdateInProgress));
				assertFalse(updateticketdetails.updateValueOfTicketForNotManager(ticketID, valuesToUpdateOnHold));
			
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	
	@Test
	public void updateForNotManagerWithValidTicketIDAndInValidEmployeeID() {
		String ticketID = "111";
		String employeeID="emp1233";
		String valuetoupdateAssigneeNamer = "manan";
		String valuesToUpdateInProgress="in progress";
		String valuesToUpdateOnHold="On hold";
		String valuesToUpdatedone="done";
		int choice = 3;
		int choiceForchangeTicketStatus = 7;
		boolean result = checkticketexists.ticketExistForManager(ticketID);
		if(result == true) {
			try {
				assertFalse(updateticketdetails.updateValueOfTicketForNotManager(ticketID, valuesToUpdateInProgress));
				assertFalse(updateticketdetails.updateValueOfTicketForNotManager(ticketID, valuesToUpdateOnHold));
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
	
		}
	}

	
	@Test
	public void updateForNotManagerWithCloseTicket() {
		String ticketID = "111";
		String employeeID="emp123";
		String valuetoupdateAssigneeNamer = "manan";
		String valuesToUpdateInProgress="in progress";
		String valuesToUpdateOnHold="On hold";
		String valuesToUpdatedone="done";
		int choice = 3;
		int choiceForchangeTicketStatus = 7;
		boolean result = checkticketexists.ticketExistForManager(ticketID);
		if(result == true) {
			try {
				assertFalse(updateticketdetails.updateValueOfTicketForNotManager(ticketID, valuesToUpdatedone));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
			
	}

}
