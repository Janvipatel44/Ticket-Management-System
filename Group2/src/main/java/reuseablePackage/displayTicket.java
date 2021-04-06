package reuseablePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import reuseablePackage.interfaces.ITableGenerator;
import reuseablePackage.interfaces.IdisplayTicket;
import userinterface.IInputOutputHandler;


public class displayTicket implements IdisplayTicket
{
	List<String> tableHeader;
	List<List<String>> rowOfTable;
	
	ITableGenerator tableFormate;
	IInputOutputHandler inputoutputhandler;
	
	public displayTicket(ITableGenerator tableFormate) 
	{
		tableHeader = new ArrayList<String>();
		rowOfTable = new  ArrayList<>();
		this.tableFormate = tableFormate;
	}
	
	public String printTicketsDetails(Map<String,ArrayList<String>> ticketData,List<String> columnsOfTable)
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
		return table;
	}
	
		
	public String printSignleTicketDetails(List<String> singleTicketData,List<String> columnsOfTable, List<String> comments)
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
		table = table + "\n  Comments...";
		String commentsData="";
		for(int i = 0; i < comments.size() ; i++)
		{
			commentsData = commentsData +" "+comments.get(i)+"\n";
		}
		table = table + "\n"+commentsData;
		return table;
	}
}
    
