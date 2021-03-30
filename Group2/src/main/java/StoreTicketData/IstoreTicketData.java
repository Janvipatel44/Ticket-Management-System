package StoreTicketData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

public interface IstoreTicketData
{
	public Map<String,ArrayList<String>> addFetchedTickets(ResultSet resultSet);
	public ArrayList<String> addFetchedComments(ResultSet resultSet);
	public ArrayList<String> getSingleTicketData(String TicketID);
}
