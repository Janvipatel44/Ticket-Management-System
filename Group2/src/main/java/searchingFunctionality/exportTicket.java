package searchingFunctionality;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class exportTicket implements  IexportTicket{
	private String FileName=null;
	private Scanner sc=new Scanner(System.in);
	
	@Override
	public void exportTicket(ArrayList<ArrayList<String>> ticketsData) {
		System.out.println("Enter file name with Path:");
		FileName=sc.next();
		File myObj = new File(FileName);
	      try {
			if (myObj.createNewFile()) {
				  FileWriter myWriter = new FileWriter(FileName);
				  for(int i=0;i<ticketsData.size();i++){
					  myWriter.write("TicketID:"+ ticketsData.get(i).get(0)+"\n");
					  myWriter.write("\t"+"description:"+ ticketsData.get(i).get(1)+"\n");
					  myWriter.write("\t"+"startDate:"+ ticketsData.get(i).get(2)+"\n");
					  myWriter.write("\t"+"endDate:"+ ticketsData.get(i).get(3)+"\n");
					  myWriter.write("\t"+"reporterId:"+ ticketsData.get(i).get(4)+"\n");
					  myWriter.write("\t"+"employeeId:"+ ticketsData.get(i).get(5)+"\n");
					  myWriter.write("\t"+"assigneeName:"+ ticketsData.get(i).get(6)+"\n");
					  myWriter.write("\t"+"ticketType:"+ticketsData.get(i).get(7)+"\n");
					  myWriter.write("\t"+"priority:"+ ticketsData.get(i).get(8)+"\n");
					  myWriter.write("\t"+"urgency:"+ ticketsData.get(i).get(9)+"\n");
					  myWriter.write("\t"+"impact:"+ ticketsData.get(i).get(10)+"\n");
					  myWriter.write("\t"+"comments:"+ ticketsData.get(i).get(11)+"\n");
					  myWriter.write("\n");
					  myWriter.write("\n");
     			  }		  
			      myWriter.close();
			}
		} 
	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
