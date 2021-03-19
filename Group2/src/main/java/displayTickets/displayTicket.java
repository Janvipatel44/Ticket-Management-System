package displayTickets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class displayTicket implements IdisplayTicket
{
	ArrayList<ArrayList <String>> ticketsData=new ArrayList<ArrayList <String>>();
	//Display searched tickets to a user
	public void displaySearchedOutput(ResultSet resultSet)
	{ 
		
		try {
			int i=0;
			while (resultSet.next()) 
			{
			  	System.out.println("Ticket ID:"+resultSet.getString("ticketId"));
			  	System.out.println("\t"+"Description:"+resultSet.getString("description"));
			  	System.out.println("\t"+"Start Date:"+resultSet.getString("startDate"));
			  	System.out.println("\t"+"End Date:"+resultSet.getString("endDate"));
			  	System.out.println("\t"+"Reported ID:"+resultSet.getString("reporterId"));
			  	System.out.println("\t"+"Employee ID:"+resultSet.getString("employeeId"));
			  	System.out.println("\t"+"Assignee Name:"+resultSet.getString("assigneeName"));
			  	System.out.println("\t"+"Ticket Type:"+resultSet.getString("ticketType"));
			  	System.out.println("\t"+"Priority:"+resultSet.getString("priority"));
			  	System.out.println("\t"+"Urgency:"+resultSet.getString("urgency"));
			  	System.out.println("\t"+"Impact:"+resultSet.getString("impact"));
			  	System.out.println("\t"+"Comments:"+resultSet.getString("comments"));
			  	System.out.print("\n");
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
	
