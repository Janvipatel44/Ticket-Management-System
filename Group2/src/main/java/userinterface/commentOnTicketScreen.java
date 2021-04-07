package userinterface;

import java.util.Scanner;

import commentOnTicket.abstractfactory.IcommentOnTicketFactory;
import commentOnTicket.abstractfactory.commentOnTicketFactory;
import commentOnTicket.interfaces.IcommentOnTicket;
import database.ConnectionManager;
import database.IConnectionManager;
import login.Interfaces.IParameterizedUser;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IstoreTicketData;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class commentOnTicketScreen implements IcommentOnTicketScreen
{
	Scanner sc = new Scanner(System.in);
	
	private String ticketId = null;
	private String commentString = null;
	private boolean result = false;
	private boolean commentPostResult=false;
	private String employeeID = "emp123";
	private final String ConfigurationFile = "ConfigurationFile";

	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IManagerFeaturesFactory managerFeaturesFactory;

	IConnectionManager ConnectionMng = new ConnectionManager(ConfigurationFile);
	IInputOutputHandler inputoutputhandler;
	
	IcommentOnTicketFactory commentonticketfactory = commentOnTicketFactory.instance();
	IcommentOnTicket postcomment = commentonticketfactory.postComment(ConnectionMng);
	
	IreuseableClassFactory reuseableclassfactory = reuseableClassFactory.instance();
	IcheckTicketExists checkticketexists= reuseableclassfactory.checkticketexists();
	IstoreTicketData storeTicketData =reuseableclassfactory.storeTicketData();
	ITableGenerator tableformate = reuseableclassfactory.tableFormate();
	IdisplayTicket displaytickets = reuseableclassfactory.displayUser(tableformate);
	IgetListOfTickets getalltickets = reuseableclassfactory.getalltickets(storeTicketData,displaytickets,ConnectionMng);
	
	public commentOnTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
	
	}
	
	public  void commentonticketscreen(IParameterizedUser user)
	{
		
		String output="";
		output=getalltickets.listOfTickets();
		do {
			inputoutputhandler.displayMethod(output);
			inputoutputhandler.displayMethod("Enter Ticket Id you want to post comment on.:");
			inputoutputhandler.displayMethod("Enter exit to go to main page");
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
