package sortTicketTest;


import java.util.ArrayList;

import displayTickets.IdisplayTicket;
import openTicketOption.IopenTicket;

public class openTicketMock implements IopenTicket
{
	ArrayList<String> singleTicketData;
	ArrayList<String> comments;
	private IdisplayTicket displayUser;
		
	public openTicketMock(IdisplayTicket displayUser)
	{
		this.displayUser = displayUser;
		singleTicketData = new 	ArrayList<String>();
		comments = new 	ArrayList<String>();
	}

	public void openticket(String ticketId)
	{
		String ticketID = "111";
		if(ticketId.equals(ticketID))
		{
			singleTicketData.add("develope bugd free login functionality");
			singleTicketData.add("2021-03-15");
			singleTicketData.add("2021-03-30");
			singleTicketData.add("EMP12");
			singleTicketData.add("EMP123");
			singleTicketData.add("Tejasw");
			singleTicketData.add(" bug");
			singleTicketData.add("1");
			singleTicketData.add("3");
			singleTicketData.add("3");
			singleTicketData.add("3");
		}
		comments = commentOnTicket(ticketId);
		displayUser.printSignleTicketDetails(singleTicketData,comments);
			
	}
	
	private ArrayList<String> commentOnTicket(String ticketId) 
	{
		ArrayList<String> comment = new ArrayList<String>();
		String ticketID = "111";
		if(ticketId.equals(ticketID))
		{
			String commentData = "Tejaswi" + " "+"Chaudhary"+"\t\t"+"2021-03-14"+"\n"+"ITs good enough";
			comment.add(commentData);
		}
		return comment;
	}
}
