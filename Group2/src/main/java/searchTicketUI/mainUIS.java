package searchTicketUI;


import java.util.Scanner;

import database.ConnectionManager;
import database.IConnectionManager;
import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IexportTicket;
import reuseablePackage.interfaces.IopenTicket;
import reuseablePackage.interfaces.IstoreTicketData;
import searchTicket.abstractfactory.IsearchTicketFactory;
import searchTicket.abstractfactory.searchTicketFactory;
import searchTicket.interfaces.IsearchTicket;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class mainUIS 
{
	static Scanner sc=new Scanner(System.in);
	static String ConfigurationFile = "ConfigurationFile";
//	static IstoreTicketData storeTicketData = new storeTicketData();
//	static IdisplayTicket displayUser = new displayTicket();
//	static IConnectionManager ConnectionMng = new ConnectionManager(ConfigurationFile);

	static IConnectionManager connectionMng = new ConnectionManager(ConfigurationFile);
	static IInputOutputHandler inputoutputhandler = new InputOutputHandler();
	
	static IreuseableClassFactory reuseablefactory = reuseableClassFactory.instance();
	static IstoreTicketData storeticketdata = reuseablefactory.storeTicketData();
	static IdisplayTicket displayuser = reuseablefactory.displayUser(inputoutputhandler);
	static IopenTicket openticket = reuseablefactory.openticket(storeticketdata,displayuser, connectionMng);
	
	
	static IsearchTicketFactory searchticketfactory = searchTicketFactory.instance(); 
	static IsearchTicket searchticket= searchticketfactory.searchticket(storeticketdata,displayuser, connectionMng);
	static IexportTicket exportTicketData = searchticketfactory.exportTicketData(storeticketdata);
	
	public static void main(String args[]) throws ClassNotFoundException 
	{
		int choice=0;
		String searchInput=null;
			
		//Available options for user
		String userOptions = "1. Ticket ID"+"\n"+"2. Assignee"+"\n"+"3. Ticket type"+"\n"+"4. All Ticket"+"\n"+
							 "5. Ticket creator"+"\n"+"6. keyword"+"\n"+"7. exit";
		inputoutputhandler.displayMethod(userOptions);
		
		do 
		{
			System.out.println("Please Provide your choice:");
			choice=inputoutputhandler.inputInt();
			
			
			if(choice==1) 
			{
				System.out.println("Please Provide TicketID:");
				searchInput=inputoutputhandler.input();
				searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==2)
			{
				System.out.println("Please Provide name of Ticket Assignee:");
				searchInput=inputoutputhandler.input();
				searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==3) 
			{
				System.out.println("Please Provide Ticket Type:");
				searchInput=inputoutputhandler.input();
				searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==4) 
			{
				System.out.println("All Tickets:");
				searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==5) 
			{
				System.out.println("Please Provide Name of Ticket Creator:");
				searchInput=inputoutputhandler.input();
				searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==6) 
			{
				System.out.println("Please Provide Keyword:");
				searchInput=inputoutputhandler.input();
				searchticket.searchbyTicket(choice, searchInput);
			}
			else 
			{
				inputoutputhandler.displayMethod("You have provided wrong input.Please choose the correct input value");
			}
			open();
		}
		while(choice!=7);
	}

	private static void open() {
		int choice=0;
		String ticketID=null;
		
		String optionsAfterSEarchTicket = "1. open Ticket"+"\n"+"2. Export Ticket"+"\n"+"3. exit";
		inputoutputhandler.displayMethod(optionsAfterSEarchTicket);
		
		do 
		{
			inputoutputhandler.displayMethod("Choose Operation you want to perform");
			choice=inputoutputhandler.inputInt();
			if(choice == 1)
			{
				
				inputoutputhandler.displayMethod("Enter Ticket ID:");
				ticketID = inputoutputhandler.input();
				openticket.openticket(ticketID) ;
			}
			else if(choice == 2)
			{
				String FileName = "";
				inputoutputhandler.displayMethod("Enter FileName with Path:");
				FileName = inputoutputhandler.input();
				exportTicketData.exportTicket(FileName);
				
			}
		}
		while(choice!=3);
	}
}
