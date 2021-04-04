package commentOnTicket.interfaces;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IstoreTicketData
{
	public void addFetchedTickets(ResultSet resultSet, ResultSetMetaData tableMetaData);
	public void addFetchedComments(ResultSet resultSet);
	public Map<String,ArrayList<String>> getTableData();
	public ArrayList<String> getSingleTicketData(String TicketID);
	public List<String> getTicketColumns();
	public List<String> getcommentsOnTicket();

}
