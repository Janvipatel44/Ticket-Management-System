package commentOnTicketUI;

import java.util.Scanner;

import commentOnTicket.abstractfactory.IcommentOnTicketFactory;
import commentOnTicket.abstractfactory.commentOnTicketFactory;
import commentOnTicket.interfaces.IcommentOnTicket;
import database.ConnectionManager;
import database.IConnectionManager;
import reuseablePackage.abstractFactory.IreuseableClassFactory;
import reuseablePackage.abstractFactory.reuseableClassFactory;
import reuseablePackage.interfaces.IcheckTicketExists;
import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IgetListOfTickets;
import reuseablePackage.interfaces.IstoreTicketData;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class commentOnTicketScreen implements IcommentOnTicketScreen
{
	Scanner sc = new Scanner(System.in);
	
	private String ticketId = null;
	private String commentString = null;
	private boolean result = false;
	private boolean commentPostResult=false;
	private String employeeID = "emp123";
	private final String ConfigurationFile = "ConfigurationFile";

	IConnectionManager ConnectionMng = new ConnectionManager(ConfigurationFile);
	IInputOutputHandler inputoutputhandler = new InputOutputHandler();
	
	IcommentOnTicketFactory commentonticketfactory;
	IcommentOnTicket postcomment;
	
	IreuseableClassFactory reuseableclassfactory ;
	IcheckTicketExists checkticketexists;
	IstoreTicketData storeTicketData;
	IdisplayTicket displaytickets;
	IgetListOfTickets getalltickets;
	
	public commentOnTicketScreen()
	{
		ConnectionMng = new ConnectionManager(ConfigurationFile);
		inputoutputhandler = new InputOutputHandler();
		
		commentonticketfactory = commentOnTicketFactory.instance();
		postcomment = commentonticketfactory.postComment(ConnectionMng);
		
		reuseableclassfactory = reuseableClassFactory.instance();
		checkticketexists= reuseableclassfactory.checkticketexists();
		storeTicketData =reuseableclassfactory.storeTicketData();
		displaytickets = reuseableclassfactory.displayUser(inputoutputhandler);
		getalltickets = reuseableclassfactory.getalltickets(storeTicketData,displaytickets,ConnectionMng);
	}
	
	public  void commentonticketscreen()
	{
		
		
		getalltickets.listOfTickets();
		
		inputoutputhandler.displayMethod("Enter Ticket Id you want to post comment on.:");
		
		ticketId = inputoutputhandler.input();
		
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
		
		 
	}
}
