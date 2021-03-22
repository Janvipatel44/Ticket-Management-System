package StoreTicketData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class storeTicketData implements IstoreTicketData
{
	static Map<String,ArrayList<String>> ticketData ; 
	static ArrayList<String> commentsOntickets;
			
	public storeTicketData()
	{
		ticketData = new HashMap<String,ArrayList<String>>();; 
		commentsOntickets = new ArrayList<String>();
	}

	public Map<String,ArrayList<String>> addFetchedTickets(ResultSet resultSet) 
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
			return ticketData;
		} 
		catch (SQLException e)
		{
			return ticketData;
		}
		
	}

	
	public ArrayList<String> addFetchedComments(ResultSet resultSet) 
	{
		try 
		{
			System.out.println("Comments:");
			while (resultSet.next()) 
			{		
				String commentData = resultSet.getString("firstName")+" "+resultSet.getString("lastName")+"\t\t"+resultSet.getDate("date")+
									 "\n"+resultSet.getString("text");
				commentsOntickets.add(commentData);
			}
			return commentsOntickets;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return commentsOntickets;
		}
	}

	public ArrayList<String> getSingleTicketData(String TicketID)
	{
		ArrayList<String> singleTicketData = new ArrayList<String>();
		if(ticketData.containsKey(TicketID)) 
		{
			singleTicketData = ticketData.get(TicketID);
			return singleTicketData;
		}
		else
		{
			return singleTicketData;
		}
		
	}
}
