package DatabaseConnection;
import java.sql.Connection;
public interface IDatabaseConnection
{
    public Connection getConnection(String configurationFile);
}
