package searchingFunctionality;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class searchedOutput {
	ArrayList<ArrayList <String>> ticketsData=new ArrayList<ArrayList <String>>();
	//Display searched tickets to a user
	public boolean displaySearchedOutput(ResultSet resultSet) { 
		
		try {
			int i=0;
			while (resultSet.next()) {	
			  	System.out.println(resultSet.getString("ticketId")+ " "
			   		+resultSet.getString("description")+ " "
			   		+resultSet.getString("startDate")+ " "
			   		+resultSet.getString("endDate")+ " "
			   		+resultSet.getString("reporterId")+ " "
			  		+resultSet.getString("employeeId")+ " "
			   		+resultSet.getString("assigneeName")+ " "
			   		+resultSet.getString("ticketType")+ " "
			   		+resultSet.getString("priority")+ " "
			   		+resultSet.getString("urgency")+ " "
			   		+resultSet.getString("impact")+ " "
			   		+resultSet.getString("comments"));
					
			  	 ticketsData.add(new ArrayList());	    
				 ticketsData.get(i).add(0,resultSet.getString("ticketId"));
				 ticketsData.get(i).add(1,resultSet.getString("description"));
				 ticketsData.get(i).add(2,resultSet.getString("startDate"));
				 ticketsData.get(i).add(3,resultSet.getString("endDate"));
				 ticketsData.get(i).add(4,resultSet.getString("reporterId"));
				 ticketsData.get(i).add(5,resultSet.getString("employeeId"));
				 ticketsData.get(i).add(6,resultSet.getString("assigneeName"));
				 ticketsData.get(i).add(7,resultSet.getString("ticketType"));
				 ticketsData.get(i).add(8,resultSet.getString("priority"));
				 ticketsData.get(i).add(9,resultSet.getString("urgency"));
				 ticketsData.get(i).add(10,resultSet.getString("impact"));
				 ticketsData.get(i).add(11,resultSet.getString("comments"));
				 i++;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ticketsData.size()==0) {
				System.out.println("Tis ticket does not exist ");
				return false;
			}else {
				System.out.println("Select Option:");
				System.out.println("1. Export Tickets");
				System.out.println("2. exit:");
			    int choice = 0;
			    Scanner sc=new Scanner(System.in);
			    choice=sc.nextInt();
				if(choice==1) {
					IexportTicket obj=new exportTicket();
					obj.exportTicket(ticketsData);
				}else {
					System.out.println("exit");
				}
				return true;
			}
			
		}	 
	
	}
	
