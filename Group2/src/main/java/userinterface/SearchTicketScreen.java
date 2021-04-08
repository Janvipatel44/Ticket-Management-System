package userinterface;


import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import login.Interfaces.IParameterizedUser;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import reuseablePackage.abstractFactory.IReuseableClasssFactory;
import reuseablePackage.abstractFactory.ReuseableClasssFactory;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.abstractfactory.ISearchTicketFactory;
import searchTicket.abstractfactory.SearchTicketFactory;
import searchTicket.interfaces.ISearchTicket;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class SearchTicketScreen implements ISearchTicketScreen
{
	static String ConfigurationFile = "ConfigurationFile";
	
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IManagerFeaturesFactory managerFeaturesFactory;


	static IConnectionManager connectionMng = new ConnectionManager(ConfigurationFile);
	static IInputOutputHandler inputoutputhandler;
	
	static IReuseableClasssFactory reuseablefactory=ReuseableClasssFactory.instance();
	static IStoreTicketData storeticketdata=reuseablefactory.storeTicketData();
	static ITableGenerator tablegenerator = reuseablefactory.tableFormate();
	static IDisplayTickets displayuser=reuseablefactory.displayUser(tablegenerator);
	static IOpenTicket openticket;
	
	static ISearchTicketFactory searchticketfactory= SearchTicketFactory.instance();
	static ISearchTicket searchticket=searchticketfactory.searchticket(storeticketdata,displayuser, connectionMng);;
	
	public SearchTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
	}
	
	public void searchTicketScreen(IParameterizedUser user)
	{
		int choice=0;
		String output="";
		String searchInput=null;
			
		//Available options for user
		String userOptions = "1. Ticket ID"+"\n"+"2. Assignee"+"\n"+"3. Ticket type"+"\n"+"4. All Ticket"+"\n"+
							 "5. Ticket creator"+"\n"+"6. keyword"+"\n"+"7. exit";
		inputoutputhandler.displayMethod(userOptions);
		
		do 
		{
			System.out.println("Please Provide your choice to search Ticket:");
			choice=inputoutputhandler.inputInt();
			
			
			if(choice==1) 
			{
				System.out.println("Please Provide TicketID:");
				searchInput=inputoutputhandler.input();
				output=searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==2)
			{
				System.out.println("Please Provide name of Ticket Assignee:");
				searchInput=inputoutputhandler.input();
				output=searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==3) 
			{
				System.out.println("Please Provide Ticket Type:");
				searchInput=inputoutputhandler.input();
				output=searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==4) 
			{
				System.out.println("All Tickets:");
				output=searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==5) 
			{
				System.out.println("Please Provide Name of Ticket Creator:");
				searchInput=inputoutputhandler.input();
				output=searchticket.searchbyTicket(choice, searchInput);
			}
			else if(choice==6) 
			{
				System.out.println("Please Provide Keyword:");
				searchInput=inputoutputhandler.input();
				output=searchticket.searchbyTicket(choice, searchInput);
			}
			else 
			{
				inputoutputhandler.displayMethod("You have provided wrong input.Please choose the correct input value");
			}
			inputoutputhandler.displayMethod(output);
			
			if(output.length()>0)
			{
				open();
			}
			else
			{
				inputoutputhandler.displayMethod("No ticket found!");
			}
			
		}
		while(choice!=7);
		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputoutputhandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);

	}

	private static void open() {
		int choice=0;
		String ticketID=null;
		
		String optionsAfterSEarchTicket = "1. open Ticket"+"\n"+"2. Export Ticket"+"\n"+"3. exit";
		inputoutputhandler.displayMethod(optionsAfterSEarchTicket);
		
		do 
		{
			inputoutputhandler.displayMethod("Choose Operation you want to perform on searched listed tickets:");
			choice=inputoutputhandler.inputInt();
			if(choice == 1)
			{
				openticket = reuseablefactory.openticket(storeticketdata,displayuser, connectionMng);
				
				inputoutputhandler.displayMethod("Enter Ticket ID:");
				ticketID = inputoutputhandler.input();
				String output=openticket.openticket(ticketID);
				inputoutputhandler.displayMethod(output);
			}
			else if(choice == 2)
			{
				IExportTicket exportTicketData = searchticketfactory.exportTicketData(storeticketdata);
				String FileName = "";
				inputoutputhandler.displayMethod("Enter FileName with Path:");
				FileName = inputoutputhandler.input();
				exportTicketData.exportTicket(FileName);
				
			}
		}
		while(choice!=3);
	}
}
