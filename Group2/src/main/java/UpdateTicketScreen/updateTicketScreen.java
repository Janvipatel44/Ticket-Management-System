package UpdateTicketScreen;

import java.text.ParseException;
import java.util.Scanner;

import database.ConnectionManager;
import database.IConnectionManager;
import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IstoreTicketData;
import reuseablePackage.interfaces.IticketStatusInProgress;
import updateTicketDetails.abstractfactory.IupdateTicketFactory;
import updateTicketDetails.abstractfactory.updateTicketFactory;
import updateTicketDetails.interfaces.IupdateTicket;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class updateTicketScreen implements IupdateTicketScreen
{
	String configurationFile = "ConfigurationFile";
	String ticketId = null;
	String userRole = "manager";
	String employeeID = "emp123";
	boolean result=false;
	Scanner sc = new Scanner(System.in);
	
	IInputOutputHandler inputoutputhandler;
	IConnectionManager ConnectionMng;
	
	IupdateTicketFactory updateticketfactory = updateTicketFactory.instance(); 
	IreuseableClassFactory reusableFactory = reuseableClassFactory.instance();
	
	IcheckTicketExists checkticketexists;
	IstoreTicketData storeticketdata;
	
	IdisplayTicket displayticket;
	IgetListOfTickets getalltickets;
	IupdateTicket updateTicket;
	IticketStatusInProgress ticketInProgress;
	
	public updateTicketScreen()
	{
		inputoutputhandler = new InputOutputHandler();
		ConnectionMng = new ConnectionManager(configurationFile);
		
		reusableFactory = reuseableClassFactory.instance();
		checkticketexists = reusableFactory.checkticketexists();
		storeticketdata = reusableFactory.storeTicketData();
		displayticket = reusableFactory.displayUser(inputoutputhandler);
		getalltickets = reusableFactory.getalltickets(storeticketdata, displayticket, ConnectionMng);
		ticketInProgress = reusableFactory.ticketInProgress(ConnectionMng);
		
		updateticketfactory = updateTicketFactory.instance(); 
		updateTicket = updateticketfactory.updateTicket(ConnectionMng,ticketInProgress);
		
	}
	
	public void updateticketscreen()
	{
		
		inputoutputhandler.displayMethod("Enter your role:");
		String userenterRole = inputoutputhandler.input();
		inputoutputhandler.displayMethod("Tickets Details");
		getalltickets.listOfTickets();
		inputoutputhandler.displayMethod("1. update"+"\n"+"2. delete"+"\n"+"Enter operation you want to perform");
	
		int choice = inputoutputhandler.inputInt();
		if(choice ==1)
		{
			if(userRole.equals(userenterRole))
			{
				inputoutputhandler.displayMethod("Enter Ticket Id you want to update:");
				ticketId = inputoutputhandler.input();
				result=checkticketexists.ticketExistForManager(ticketId, employeeID);
				if(result == true)
				{
					inputoutputhandler.displayMethod("1. Expected Date"+"\n"+"2. Reporter ID"+"\n"+"3. Assignee Name"+"\n"+"4. priority"+"\n"+"5. urgency"+
							"\n"+"6. impact"+"\n"+"7. status of ticket");
					
					inputoutputhandler.displayMethod("Please provide your choice");
					int choiceToUpdate =inputoutputhandler.inputInt();
					inputoutputhandler.displayMethod("Enter Update Value:");
					String value = inputoutputhandler.input();
					result = updateTicket.updateValueOfTicketForManager(ticketId,choiceToUpdate,value);
					if(result == true)
					{
						inputoutputhandler.displayMethod("true");
					}
					else
					{
						inputoutputhandler.displayMethod("false");
					}
					
				}
				else
				{
					inputoutputhandler.displayMethod("Please provide valid ticket id. You are either not allow to update tickets data, or ticket with given id does not exists");
				}
					
			}
			else
			{
				inputoutputhandler.displayMethod("Enter Ticket Id you want to update:");
				ticketId = inputoutputhandler.input();
				result = checkticketexists.ticketExistForNotManager(ticketId, employeeID);
				if(result == true)
				{
					inputoutputhandler.displayMethod("Change Ticket Status");
					inputoutputhandler.displayMethod("Enter Ticket Status:");
					String value = inputoutputhandler.input();
					
					try {
						result = updateTicket.updateValueOfTicketForNotManager(ticketId,value);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(result == true)
					{
						inputoutputhandler.displayMethod("true");
					}
					else
					{
						inputoutputhandler.displayMethod("false");
					}
				}
				else
				{
					inputoutputhandler.displayMethod("Please provide valid ticket id. You are either not allow to update tickets data, or ticket with given id does not exists");
				}
			}
		}
	}
}
		
