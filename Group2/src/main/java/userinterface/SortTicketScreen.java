package userinterface;

import java.util.Scanner;

import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import login.Interfaces.IParameterizedUser;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import reuseablePackage.abstractFactory.IReuseableClassFactory;
import reuseablePackage.abstractFactory.ReuseableClassFactory;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import sortTickets.SortTicket;
import sortTickets.abstractfactory.ISortTicketFactory;
import sortTickets.abstractfactory.SortTicketFactory;
import sortTickets.interfaces.ISortTicket;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class SortTicketScreen implements ISortTciketScreen{

	static Scanner sc = new Scanner(System.in);
	int choice = 0;
	static String ConfigurationFile = "ConfigurationFile";
	static String printOnScreenString = "";
	
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IManagerFeaturesFactory managerFeaturesFactory;


	static IInputOutputHandler inputoutputhandler;
	
	static IReuseableClassFactory resuableclassfactore = ReuseableClassFactory.instance();
	static ISortTicketFactory storeticketfactory = SortTicketFactory.instance();
	static IStoreTicketData storeTicketData = resuableclassfactore.storeTicketData();
	static ITableGenerator tableformate = resuableclassfactore.tableFormate();
	static IDisplayTicket displayUser = resuableclassfactore.displayUser(tableformate);
	static IConnectionManager ConnectionMng = new ConnectionManager(ConfigurationFile);

	public SortTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;		
	}
	
	public void sortticketscreen(IParameterizedUser user)
	{
		String output="";
		printOnScreenString = "Sort Ticket BY:" + "\n\n" + "1. Priority" + "\n" + "2. Urgency" + "\n" + "3. impact"
				+ " \n" + "4. exit" + "\n";
		inputoutputhandler.displayMethod(printOnScreenString);
		do {
			inputoutputhandler.displayMethod("Enter your choice:");
			choice = inputoutputhandler.inputInt();
			ISortTicket sortTicketobj = new SortTicket(storeTicketData, displayUser, ConnectionMng);
			if (choice <= 3 && choice >= 1) {
				output = sortTicketobj.sortTickets(choice);
				inputoutputhandler.displayMethod(output);
				open();
			}
		} while (choice != 4);
		
		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputoutputhandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);
	}

	private static void open() {
		int choice = 0;
		String output="";
		String ticketID = null;
		IOpenTicket openticket = resuableclassfactore.openticket(storeTicketData, displayUser, ConnectionMng);

		printOnScreenString = "1. open Ticket" + " \n" + "2. exit";
		inputoutputhandler.displayMethod(printOnScreenString);

		do {
			try {
				inputoutputhandler.displayMethod("Choose Operation you want to perform");
				inputoutputhandler.displayMethod("\n");
				choice = inputoutputhandler.inputInt();

				if (choice == 1) {
					inputoutputhandler.displayMethod("Enter Ticket ID:");
					inputoutputhandler.displayMethod("\n");
					ticketID = inputoutputhandler.input();
					output = openticket.openticket(ticketID);
					inputoutputhandler.displayMethod(output);
				}
				else
				{
					inputoutputhandler.displayMethod("invalid input");
				}
			} catch (NumberFormatException e) {

			}
		} while (choice != 2);
	
	}

}
