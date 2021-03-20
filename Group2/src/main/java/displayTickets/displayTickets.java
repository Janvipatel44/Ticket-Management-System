package displayTickets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class displayTickets implements IdisplayTickets
{
	public void displayTickets(List<String> listoftickets)
	{
		System.out.println("List of Ticket IDs");
		for(int i=0;i<listoftickets.size();i++)
		{
			System.out.println("\t"+listoftickets.get(i));
		}
	}
}
