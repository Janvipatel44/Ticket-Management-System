package searchTicket;

import java.util.ArrayList;
import java.util.List;

import reuseablePackage.interfaces.IdisplayTicket;
import reuseablePackage.interfaces.IopenTicket;
import searchTicket.abstarctfactory.IsearchFactoryTest;
import searchTicket.abstarctfactory.searchFactoryTest;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;


public class openTicketMock implements IopenTicket
{
	ArrayList<String> singleTicketData;
	ArrayList<String> comments;
	
	List<String> columnOfTable;
		
	IsearchFactoryTest  searchfactorytest = searchFactoryTest.instance();
	IInputOutputHandler inputoutputhandler = new InputOutputHandler();
	private IdisplayTicket displayUser;
	
	public openTicketMock()
	{
		displayUser = searchfactorytest.displayUser(inputoutputhandler);
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
			singleTicketData.add("description: develope bugd free login functionality");
			singleTicketData.add("startDate:2021-03-15");
			singleTicketData.add("endDate:2021-03-30");
			singleTicketData.add("reporterId:EMP12");
			singleTicketData.add("employeeId:EMP123");
			singleTicketData.add("assigneeName:Tejasw");
			singleTicketData.add("ticketType: bug");
			singleTicketData.add("priority:1");
			singleTicketData.add("urgency:3");
		}
		addColumnsOfTable();
		comments = commentOnTicket(ticketId);
		displayUser.printSignleTicketDetails(singleTicketData,columnOfTable,comments);
			
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
