package userinterface;

import java.text.ParseException;
import java.util.Scanner;

import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import login.Interfaces.IParameterizedUser;
import reuseablePackage.abstractFactory.IReuseableClassFactory;
import reuseablePackage.abstractFactory.ReuseableClassFactory;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.ICheckTicketExists;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.IticketStatusInProgress;
import roles.abstractfactory.IRoleFactory;
import updateTicketDetails.abstractfactory.IUpdateTicketFactory;
import updateTicketDetails.abstractfactory.UpdateTicketFactory;
import updateTicketDetails.interfaces.IUpdateTicket;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class UpdateTicketScreen implements IUpdateTicketScreen
{
	String configurationFile = "ConfigurationFile";
	String ticketId = null;
	String userRole = "manager";
	boolean result=false;
	Scanner sc = new Scanner(System.in);
	
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IRoleFactory roleFactory;
	
	IInputOutputHandler inputoutputhandler;
	
	IConnectionManager ConnectionMng = new ConnectionManager(configurationFile);
		
	IUpdateTicketFactory updateticketfactory = UpdateTicketFactory.instance(); 
	IReuseableClassFactory reusableFactory = ReuseableClassFactory.instance();
	
	ICheckTicketExists checkticketexists = reusableFactory.checkticketexists();
	IStoreTicketData storeticketdata = reusableFactory.storeTicketData();
	ITableGenerator tableformate = reusableFactory.tableFormate();
	IDisplayTicket displayticket = reusableFactory.displayUser(tableformate);
	IGetListOfTickets getalltickets = reusableFactory.getalltickets(storeticketdata, displayticket, ConnectionMng);
	IticketStatusInProgress ticketInProgress = reusableFactory.ticketInProgress(ConnectionMng);
	IUpdateTicket updateTicket = updateticketfactory.updateTicket(ConnectionMng,ticketInProgress);
	
	
	public UpdateTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
	}
	
	public void updateticketscreen(IParameterizedUser user)
	{
		String output="";
		String userenterRole = user.getUserType().toLowerCase();
		inputoutputhandler.displayMethod("Enter your role:"+userenterRole);
		inputoutputhandler.displayMethod("Tickets Details");
		output = getalltickets.listOfTickets();
		inputoutputhandler.displayMethod(output);
			
		if(userRole.equals(userenterRole))
		{
			do {
				inputoutputhandler.displayMethod("Enter Ticket Id you want to update:");
				inputoutputhandler.displayMethod("Enter exit to go to main menu");
				ticketId = inputoutputhandler.input();
				if(ticketId.toLowerCase().equals("exit")) 
				{
					break;
				}
				result=checkticketexists.ticketExistForManager(ticketId);
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
				
			}while(true);
					
		}
		else
		{
			String employeeID=user.getEmployeeID();
			inputoutputhandler.displayMethod(employeeID);
			do 
			{
				
				inputoutputhandler.displayMethod("Enter Ticket Id you want to update:");
				inputoutputhandler.displayMethod("Enter exit to go to main menu");
				ticketId = inputoutputhandler.input();
				if(ticketId.toLowerCase().equals("exit")) 
				{
					break;
				}
				result = checkticketexists.ticketExistForNotManager(ticketId, employeeID);
				if(result == true)
				{
					inputoutputhandler.displayMethod("Change Ticket Status");
					inputoutputhandler.displayMethod("Enter Ticket Status:");
					String value = inputoutputhandler.input();
					
				try {
						result = updateTicket.updateValueOfTicketForNotManager(ticketId,value);
					} catch (ParseException e) {
						inputoutputhandler.displayMethod("Error");
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
				
			}while(true);
			
		}
		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputoutputhandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);

	}
}
		
