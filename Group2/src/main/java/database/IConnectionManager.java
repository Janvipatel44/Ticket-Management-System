package database;
import java.sql.Connection;
public interface IConnectionManager
{
	Connection establishConnection();
	void closeConnection();
}
