package sortTciketScreen;

import java.util.Scanner;

import database.ConnectionManager;
import database.IConnectionManager;
import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.sortTicket;
import sortTickets.abstractfactory.ISortTicketFactory;
import sortTickets.abstractfactory.SortTicketFactory;
import sortTickets.interfaces.IsortTicketData;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class sortTicketScreen implements IsortTciketScreen{

	static Scanner sc = new Scanner(System.in);
	int choice = 0;
	static String ConfigurationFile = "ConfigurationFile";
	static String printOnScreenString = "";

	static IreuseableClassFactory resuableclassfactore;
	static ISortTicketFactory storeticketfactory;
	static IstoreTicketData storeTicketData;
	static IInputOutputHandler inputoutputhandler;
	static IdisplayTicket displayUser;
	static IConnectionManager ConnectionMng;

	public sortTicketScreen()
	{
		ConnectionMng = new ConnectionManager(ConfigurationFile);
		inputoutputhandler = new InputOutputHandler();
		
		resuableclassfactore = reuseableClassFactory.instance();
		storeticketfactory = SortTicketFactory.instance();
		storeTicketData = resuableclassfactore.storeTicketData();
		displayUser = resuableclassfactore.displayUser(inputoutputhandler);
	}
	
	public void sortticketscreen()
	{
		
		printOnScreenString = "Sort Ticket BY:" + "\n\n" + "1. Priority" + "\n" + "2. Urgency" + "\n" + "3. impact"
				+ " \n" + "4. exit" + "\n";
		inputoutputhandler.displayMethod(printOnScreenString);
		do {
			inputoutputhandler.displayMethod("Enter your choice:");
			choice = inputoutputhandler.inputInt();
			IsortTicketData sortTicketobj = new sortTicket(storeTicketData, displayUser, ConnectionMng);
			if (choice <= 3 || choice <= 1) {
				sortTicketobj.sortTickets(choice);
			}
			open();
		} while (choice != 4);

	}

	private static void open() {
		int choice = 0;
		String ticketID = null;
		IopenTicket openticket = resuableclassfactore.openticket(storeTicketData, displayUser, ConnectionMng);

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
					openticket.openticket(ticketID);
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
