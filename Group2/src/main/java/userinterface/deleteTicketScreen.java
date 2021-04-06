package userinterface;

import java.util.Scanner;

import database.ConnectionManager;
import database.IConnectionManager;
import deleteTicket.abstractfactory.DeleteTicketFactory;
import deleteTicket.abstractfactory.IDeleteTicketFactory;
import deleteTicket.interfaces.IdeleteTicket;
import login.Interfaces.IParameterizedUser;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IstoreTicketData;
import userinterface.IBackToHomePageScreen;
import userinterface.IInputOutputHandler;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class deleteTicketScreen implements IdeleteTicketScreen
{
	String configurationFile = "ConfigurationFile";
	String ticketId = null;
	String userRole = "manager";
	String empployeeID = "emp123";
	boolean result=false;
	Scanner sc = new Scanner(System.in);
	
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IManagerFeaturesFactory managerFeaturesFactory;

	IInputOutputHandler inputoutputhandler;
	IConnectionManager ConnectionMng = new ConnectionManager(configurationFile);
	
	IreuseableClassFactory reusableFactory = reuseableClassFactory.instance();
	IcheckTicketExists checkticketexists = reusableFactory.checkticketexists();
	IstoreTicketData storeticketdata = reusableFactory.storeTicketData();
	ITableGenerator tableformate = reusableFactory.tableFormate();
	IdisplayTicket displayticket = reusableFactory.displayUser(tableformate);
	IgetListOfTickets getalltickets = reusableFactory.getalltickets(storeticketdata, displayticket, ConnectionMng);
	
	IDeleteTicketFactory deleteticketfactory = DeleteTicketFactory.instance();
	IdeleteTicket deleteticket;
	
	public deleteTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
	}
	
	public void deleteTicketScreen(IParameterizedUser user)
	{
		String output;
		inputoutputhandler.displayMethod("Enter your role:");
		String userenterRole = inputoutputhandler.input();
		inputoutputhandler.displayMethod("Tickets Details");
		output = getalltickets.listOfTickets();
		inputoutputhandler.displayMethod(output);
		
		inputoutputhandler.displayMethod("1. update"+"\n"+"2. delete");
	
		inputoutputhandler.displayMethod("Enter operation you want to perform");
		int choice = inputoutputhandler.inputInt();

		if(userRole.equals(userenterRole))
		{
			
			inputoutputhandler.displayMethod("Enter Ticket Id you want to delete:");
			ticketId = inputoutputhandler.input();
			result=checkticketexists.ticketExistForManager(ticketId,empployeeID);
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
