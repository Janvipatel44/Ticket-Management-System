package displayTickets;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class displayTicket implements IdisplayTickets
{
	static Map<String,ArrayList<String>> ticketData = new LinkedHashMap<String,ArrayList<String>>();
	ArrayList <String> ticketsData = new ArrayList <String>();
	//Display searched tickets to a user
	public void displaySearchedOutput(ResultSet resultSet)
	{ 
		
		try {
			int i=0;
			while (resultSet.next()) 
			{
				ticketData.put(resultSet.getString("ticketId"), new ArrayList<String>());
				ticketData.get(resultSet.getString("ticketId")).add("description:"+resultSet.getString("description"));
				ticketData.get(resultSet.getString("ticketId")).add("startDate:"+resultSet.getString("startDate"));
				ticketData.get(resultSet.getString("ticketId")).add("endDate:"+resultSet.getString("endDate"));
				ticketData.get(resultSet.getString("ticketId")).add("reporterId:"+resultSet.getString("reporterId"));
				ticketData.get(resultSet.getString("ticketId")).add("employeeId:"+resultSet.getString("employeeId"));
				ticketData.get(resultSet.getString("ticketId")).add("assigneeName:"+resultSet.getString("assigneeName"));
				ticketData.get(resultSet.getString("ticketId")).add("ticketType:"+resultSet.getString("ticketType"));
				ticketData.get(resultSet.getString("ticketId")).add("priority:"+resultSet.getString("priority"));
				ticketData.get(resultSet.getString("ticketId")).add("urgency:"+resultSet.getString("urgency"));
				ticketData.get(resultSet.getString("ticketId")).add("impact:"+resultSet.getString("impact"));
				
			}
			System.out.println(ticketData);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void openTicket(String ticketID)
	{
		System.out.println("Details for Ticket: " + ticketID);
		ticketsData = ticketData.get(ticketID);
		for(int i = 0; i < ticketsData.size(); i++)
		{
			System.out.println(ticketsData.get(i));
		}
	}
}
	
