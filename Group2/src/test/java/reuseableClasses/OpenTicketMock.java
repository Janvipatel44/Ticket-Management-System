package reuseableClasses;

import java.util.ArrayList;
import java.util.List;

import reuseablePackage.abstractFactory.IReuseableClassFactory;
import reuseablePackage.abstractFactory.ReuseableClassFactory;
import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IDisplayTicket;
import reuseablePackage.interfaces.IOpenTicket;

public class OpenTicketMock implements IOpenTicket
{

	ArrayList<String> singleTicketData;
	ArrayList<String> comments;
	
	List<String> columnOfTable;
		
	private IReuseableClassFactory reuseableclassfactory = ReuseableClassFactory.instance();
	private ITableGenerator generateTable;
	private IDisplayTicket displayticket;
	
	public OpenTicketMock()
	{
		generateTable = reuseableclassfactory.tableFormate();
		displayticket = reuseableclassfactory.displayUser(generateTable);
		singleTicketData = new 	ArrayList<String>();
		comments = new 	ArrayList<String>();
		columnOfTable = new ArrayList<String>();
	}

	public String openticket(String ticketId)
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
		String output= displayticket.printSignleTicketDetails(singleTicketData,columnOfTable,comments);
		return output;
			
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