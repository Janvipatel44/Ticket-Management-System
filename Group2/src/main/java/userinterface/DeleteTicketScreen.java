package userinterface;

import java.util.Scanner;

import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import deleteTicket.abstractfactory.DeleteTicketsFactory;
import deleteTicket.abstractfactory.IDeleteTicketsFactory;
import deleteTicket.interfaces.IDeleteTickets;
import login.Interfaces.IParameterizedUser;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import reuseablePackage.abstractFactory.IReuseableClasssFactory;
import reuseablePackage.abstractFactory.ReuseableClasssFactory;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.ITableGenerator;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class DeleteTicketScreen implements IDeleteTicketScreen
{
	String configurationFile = "ConfigurationFile";
	String ticketId = null;
	String userRole = "admin";
	boolean result=false;
	Scanner sc = new Scanner(System.in);
	
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IManagerFeaturesFactory managerFeaturesFactory;

	IInputOutputHandler inputoutputhandler;
	IConnectionManager ConnectionMng = new ConnectionManager(configurationFile);
	
	IReuseableClasssFactory reusableFactory = ReuseableClasssFactory.instance();
	ICheckTicketsExists checkticketexists = reusableFactory.checkticketexists();
	IStoreTicketData storeticketdata = reusableFactory.storeTicketData();
	ITableGenerator tableformate = reusableFactory.tableFormate();
	IDisplayTickets displayticket = reusableFactory.displayUser(tableformate);
	IGetListOfTickets getalltickets = reusableFactory.getalltickets(storeticketdata, displayticket, ConnectionMng);
	
	IDeleteTicketsFactory deleteticketfactory = DeleteTicketsFactory.instance();
	IDeleteTickets deleteticket;
	
	public DeleteTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
	}
	
	public void deleteTicketScreen(IParameterizedUser user)
	{
		String output;
		
		String userenterRole = user.getUserType().toLowerCase();
		inputoutputhandler.displayMethod("Tickets Details");
		output = getalltickets.listOfTickets();
		inputoutputhandler.displayMethod(output);
		
		if(userRole.equals(userenterRole))
		{
			
			inputoutputhandler.displayMethod("Enter Ticket Id you want to delete:");
			ticketId = inputoutputhandler.input();
			result=checkticketexists.ticketExistForManager(ticketId);
			if(result == true)
			{
				result = deleteticket.deleteticket(ticketId);
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
			inputoutputhandler.displayMethod("Sorry you can't delete ticket");
		}
		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputoutputhandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);

	}

}
