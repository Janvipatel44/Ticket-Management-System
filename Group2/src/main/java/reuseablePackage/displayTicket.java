package reuseablePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import reuseablePackage.interfaces.IdisplayTicket;
import sortTickets.interfaces.IInputOutputHandler;

public class displayTicket implements IdisplayTicket
{
	List<String> tableHeader;
	List<List<String>> rowOfTable;
	
	TableGenerator tableFormate;
	IInputOutputHandler inputoutputhandler;
	
	public displayTicket(IInputOutputHandler inputoutputhandler) 
	{
		tableHeader = new ArrayList<String>();
		rowOfTable = new  ArrayList<>();
		tableFormate = new TableGenerator(); 
		this.inputoutputhandler = inputoutputhandler;
	}
	
	public void printTicketsDetails(Map<String,ArrayList<String>> ticketData,List<String> columnsOfTable)
	{ 
			
		tableHeader.clear();
		rowOfTable.clear();
		tableHeader.add(columnsOfTable.get(0));
		tableHeader.add(columnsOfTable.get(1));
		for(String key : ticketData.keySet())
		{
			ArrayList<String> rowData = new ArrayList<>();
			rowData.add(key);
			String element = ticketData.get(key).get(0);
			rowData.add(element);
			rowOfTable.add(rowData);
			
			
		}
		String table = tableFormate.generateTable(tableHeader, rowOfTable);
		inputoutputhandler.displayMethod(table);
	}
	
		
	public void printSignleTicketDetails(List<String> singleTicketData,List<String> columnsOfTable, List<String> comments)
	{
		rowOfTable.clear();
		tableHeader = columnsOfTable;
		for(int i=0;i<singleTicketData.size();i++)
		{
			if(singleTicketData.get(i) == null)
			{
				singleTicketData.set(i, "");
			}
		}
		rowOfTable.add(singleTicketData);
		String table = tableFormate.generateTable(tableHeader, rowOfTable);
		inputoutputhandler.displayMethod(table);
		inputoutputhandler.displayMethod("  Comments...");
		String commentsData="";
		for(int i = 0; i < comments.size() ; i++)
		{
			commentsData = commentsData +" "+comments.get(i)+"\n";
		}
		inputoutputhandler.displayMethod(commentsData);
	}
}
    

	
