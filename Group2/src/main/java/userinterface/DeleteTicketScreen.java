package userinterface;

import java.util.Scanner;

import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import deleteTicket.abstractfactory.DeleteTicketFactory;
import deleteTicket.abstractfactory.IDeleteTicketFactory;
import deleteTicket.interfaces.IDeleteTicket;
import login.Interfaces.IParameterizedUser;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import reuseablePackage.abstractFactory.IReuseableClassFactory;
import reuseablePackage.abstractFactory.ReuseableClassFactory;
import reuseablePackage.interfaces.ITableGenerator;
<<<<<<< HEAD:Group2/src/main/java/userinterface/DeleteTicketScreen.java
import reuseablePackage.interfaces.ICheckTicketExists;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IStoreTicketData;
=======
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IstoreTicketData;
>>>>>>> 5a2ea7b7154c35580472c415ac24ce2ced02e5a3:Group2/src/main/java/userinterface/deleteTicketScreen.java
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class DeleteTicketScreen implements IDeleteTicketScreen
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
	
	IReuseableClassFactory reusableFactory = ReuseableClassFactory.instance();
	ICheckTicketExists checkticketexists = reusableFactory.checkticketexists();
	IStoreTicketData storeticketdata = reusableFactory.storeTicketData();
	ITableGenerator tableformate = reusableFactory.tableFormate();
	IDisplayTicket displayticket = reusableFactory.displayUser(tableformate);
	IGetListOfTickets getalltickets = reusableFactory.getalltickets(storeticketdata, displayticket, ConnectionMng);
	
	IDeleteTicketFactory deleteticketfactory = DeleteTicketFactory.instance();
	IDeleteTicket deleteticket;
	
	public DeleteTicketScreen(IInputOutputHandler inputoutputhandler)
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
