package sortTicketTest;


import java.util.ArrayList;
import java.util.List;

import sortTicketTest.abstractfactory.ISortTicketFactoryTest;
import sortTicketTest.abstractfactory.SortTicketFactoryTest;
import sortTickets.interfaces.IdisplayTicket;
import sortTickets.interfaces.IopenTicket;

public class openTicketMock implements IopenTicket
{
	ArrayList<String> singleTicketData;
	ArrayList<String> comments;
	
	List<String> columnOfTable;
		
	ISortTicketFactoryTest sortticketfactory = SortTicketFactoryTest.instance();
	IdisplayTicket displayuser;
	public openTicketMock()
	{
		displayuser = sortticketfactory.displayUser();
		singleTicketData = new 	ArrayList<String>();
		comments = new 	ArrayList<String>();
		columnOfTable = new ArrayList<String>();
	}

	public void openticket(String ticketId)
	{
		String ticketID = "111";
		if(ticketId.equals(ticketID))
		{
			singleTicketData.add("111");
			singleTicketData.add("develope bugd free login functionality");
			singleTicketData.add("2021-03-15");
			singleTicketData.add("2021-03-30");
			singleTicketData.add("EMP12");
			singleTicketData.add("EMP123");
			singleTicketData.add("Tejasw");
			singleTicketData.add("bug");
			singleTicketData.add("1");
			singleTicketData.add("3");
		}
		addColumnsOfTable();
		comments = commentOnTicket(ticketId);
		displayuser.printSignleTicketDetails(singleTicketData,columnOfTable,comments);
			
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
	
	private void addColumnsOfTable() {
		columnOfTable.add("ticketId");
		columnOfTable.add("description");
		columnOfTable.add("startDate");
		columnOfTable.add("endDate");
		columnOfTable.add("reporterId");
		columnOfTable.add("employeeId");
		columnOfTable.add("assigneeName");
		columnOfTable.add("ticketType");
		columnOfTable.add("priority");
		columnOfTable.add("urgency");
		
	}	

}
