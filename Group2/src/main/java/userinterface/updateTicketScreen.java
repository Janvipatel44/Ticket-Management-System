package userinterface;

import java.text.ParseException;
import java.util.Scanner;

import database.ConnectionManager;
import database.IConnectionManager;
import login.Interfaces.IParameterizedUser;
import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IstoreTicketData;
import reuseablePackage.interfaces.IticketStatusInProgress;
import roles.abstractfactory.IRoleFactory;
import updateTicketDetails.abstractfactory.IupdateTicketFactory;
import updateTicketDetails.abstractfactory.updateTicketFactory;
import updateTicketDetails.interfaces.IupdateTicket;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class updateTicketScreen implements IupdateTicketScreen
{
	String configurationFile = "ConfigurationFile";
	String ticketId = null;
	String userRole = "manager";
	String employeeID = "ct785";
	boolean result=false;
	Scanner sc = new Scanner(System.in);
	
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IRoleFactory roleFactory;
	
	IInputOutputHandler inputoutputhandler;
	
	IConnectionManager ConnectionMng = new ConnectionManager(configurationFile);
		
	IupdateTicketFactory updateticketfactory = updateTicketFactory.instance(); 
	IreuseableClassFactory reusableFactory = reuseableClassFactory.instance();
	
	IcheckTicketExists checkticketexists = reusableFactory.checkticketexists();
	IstoreTicketData storeticketdata = reusableFactory.storeTicketData();
	ITableGenerator tableformate = reusableFactory.tableFormate();
	IdisplayTicket displayticket = reusableFactory.displayUser(tableformate);
	IgetListOfTickets getalltickets = reusableFactory.getalltickets(storeticketdata, displayticket, ConnectionMng);
	IticketStatusInProgress ticketInProgress = reusableFactory.ticketInProgress(ConnectionMng);
	IupdateTicket updateTicket = updateticketfactory.updateTicket(ConnectionMng,ticketInProgress);
	
	
	public updateTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
	}
	
	public void updateticketscreen(IParameterizedUser user)
	{
		String output = "";
		inputoutputhandler.displayMethod("Enter your role:");
		String userenterRole = inputoutputhandler.input();
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
				
			}while(true);
					
		}
		else
		{
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
				
			}while(true);
			
		}
		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputoutputhandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);

	}
}
		
