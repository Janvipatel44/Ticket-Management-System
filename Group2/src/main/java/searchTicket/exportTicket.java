package searchTicket;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import searchTicket.interfaces.IexportTicket;
import searchTicket.interfaces.IstoreTicketData;

public class exportTicket implements  IexportTicket{
	private Scanner sc=new Scanner(System.in);
	
	private IstoreTicketData storeTicketData;
	private TableGenerator tableFormate;
	
	public exportTicket(IstoreTicketData storeTicketData)
	{
		this.storeTicketData = storeTicketData;
		tableFormate = new TableGenerator();
	}
	
	public void exportTicket(String FileName) {
		File myObj = new File(FileName);
	      try {
			if (myObj.createNewFile()) 
			{
				FileWriter myWriter = new FileWriter(FileName);
				  Map<String, ArrayList <String>> ticketsDatas = storeTicketData.getTableData();
				  List<List<String>> allRowData = new ArrayList<>();
				  
				  int index=0;
				  for(String key : ticketsDatas.keySet())
				  {
					  List<String> rowData = new ArrayList<>();
					  rowData.add(key);
					  for(int i=0;i<ticketsDatas.get(key).size();i++)
					  {
						  String data =  ticketsDatas.get(key).get(i);
						  if(data == null)
						  {
							  rowData.add(""); 
						  }
						  else {
							  rowData.add(data);  
						  }
						   
					  }
					  allRowData.add(index,rowData);
					  index++;
				  }
				  List<String> columnOfTable = storeTicketData.getTicketColumns();
				  myWriter.write(tableFormate.generateTable(columnOfTable, allRowData));
				  myWriter.close();
			}		  
		} 
	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
