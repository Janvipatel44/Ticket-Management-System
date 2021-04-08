package userinterface;

import java.util.Scanner;

import commentOnTicket.abstractfactory.CommentOnTicketsFactory;
import commentOnTicket.abstractfactory.ICommentOnTicketsFactory;
import commentOnTicket.interfaces.ICommentOnTickets;
import database.ConnectionManager;
import database.intefaces.IConnectionManager;
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

public class CommentOnTicketScreen implements ICommentOnTicketScreen
{
	Scanner sc = new Scanner(System.in);
	
	private String ticketId = null;
	private String commentString = null;
	private boolean result = false;
	private boolean commentPostResult=false;
	private String employeeID;
	private String currentUserRole;
	private static String userRole="manager";
	private String managerId;
	private final String ConfigurationFile = "ConfigurationFile";

	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IManagerFeaturesFactory managerFeaturesFactory;

	IConnectionManager ConnectionMng = new ConnectionManager(ConfigurationFile);
	IInputOutputHandler inputoutputhandler;
	
	ICommentOnTicketsFactory commentonticketfactory = CommentOnTicketsFactory.instance();
	ICommentOnTickets postcomment = commentonticketfactory.postComment(ConnectionMng);
	
	IReuseableClasssFactory reuseableclassfactory = ReuseableClasssFactory.instance();
	ICheckTicketsExists checkticketexists= reuseableclassfactory.checkticketexists();
	IStoreTicketData storeTicketData =reuseableclassfactory.storeTicketData();
	ITableGenerator tableformate = reuseableclassfactory.tableFormate();
	IDisplayTickets displaytickets = reuseableclassfactory.displayUser(tableformate);
	IGetListOfTickets getalltickets = reuseableclassfactory.getalltickets(storeTicketData,displaytickets,ConnectionMng);
	
	public CommentOnTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
	
	}
	
	public  void commentonticketscreen(IParameterizedUser user)
	{
		userRole=user.getUserType().toLowerCase();
		if(userRole.equals(userRole))
		{
			employeeID=user.getManager();
		}
		else
		{
			employeeID=user.getEmployeeID();
		}
		String output="";
		output=getalltickets.listOfTickets();
		inputoutputhandler.displayMethod(output);
		do {
			
			inputoutputhandler.displayMethod("Enter Ticket Id you want to post comment on.:");
			inputoutputhandler.displayMethod("Enter exit to go to main page");
			inputoutputhandler.displayMethod("\n");
			ticketId = inputoutputhandler.input();
			
			if(ticketId.toLowerCase().equals("exit"))
			{
				break;
			}
			result=checkticketexists.ticketExists(ticketId);
			
			if(result == true)
			{
				inputoutputhandler.displayMethod("Write comment you want to post");
				commentString = inputoutputhandler.input();
				commentPostResult=postcomment.postCommentOnticket(ticketId,employeeID, commentString);
				if(commentPostResult==true)
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
				inputoutputhandler.displayMethod("Ticket with " + ticketId + "does not exists. Please provide valid ticketId.");
			}
		}while(true);
	
		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputoutputhandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);
 
	}
}
