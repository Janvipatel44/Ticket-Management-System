package sortTickets;

import java.util.Scanner;

import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import sortTickets.abstractfactory.ISortTicketFactory;
import sortTickets.abstractfactory.SortTicketFactory;
import sortTickets.interfaces.IConnectionManager;
import sortTickets.interfaces.IInputOutputHandler;
import sortTickets.interfaces.IsortTicketData;

public class sortTicketUI {

	static Scanner sc = new Scanner(System.in);

	static String ConfigurationFile = "ConfigurationFile";
	static String printOnScreenString = "";

	static IreuseableClassFactory resuableclassfactore = reuseableClassFactory.instance();
	static ISortTicketFactory storeticketfactory = SortTicketFactory.instance();
	static IstoreTicketData storeTicketData = resuableclassfactore.storeTicketData();
	static IInputOutputHandler inputoutputhandler = resuableclassfactore.inputoutputhandler();
	static IdisplayTicket displayUser = resuableclassfactore.displayUser(inputoutputhandler);
	static IConnectionManager ConnectionMng = resuableclassfactore.ConnectionMng(ConfigurationFile);

	public static void main(String args[]) {
		int choice = 0;
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
		int choice = 1;
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
			} catch (NumberFormatException e) {

			}
		} while (choice != 2);
	}

}
