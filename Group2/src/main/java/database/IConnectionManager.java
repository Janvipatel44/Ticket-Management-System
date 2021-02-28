package database;
import java.sql.Connection;
public interface IConnectionManager {
	
	public Connection establishConnection();
	public void closeConnection();

}
