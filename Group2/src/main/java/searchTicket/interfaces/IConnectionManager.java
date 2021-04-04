package searchTicket.interfaces;

import java.sql.Connection;
import java.sql.Connection;

public interface IConnectionManager {
	
	public Connection establishConnection();
	public void closeConnection();
}
