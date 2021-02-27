package DatabaseConnection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection implements IDatabaseConnection{

    private final String jdbcClass="com.mysql.jdbc.Driver";
    private final String nullConstant="null";
    private List<String> configDetails = new ArrayList<String>();
    private String username;
    private String password;
    private String hostName;

    @Override
    public Connection getConnection(String configurationFile)
    {

        try {
            Class.forName(jdbcClass);
            Connection database_connection=null;
            BufferedReader buffReader=new BufferedReader(new FileReader(configurationFile));
            String line="";
            while(line!=nullConstant)
            {
                line=buffReader.readLine();
                configDetails.add(line);
                username=line;
            }
            hostName=configDetails.get(0);
            username=configDetails.get(1);
            password=configDetails.get(2);
            database_connection= DriverManager.getConnection(hostName,username,password);
            return database_connection;
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error: Unable to setup DB connection");
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Invalid configuration file");
        }
        catch (IOException e) {
            System.out.println("Error: Issue occured while reading configuration file. Please try again.");
        } catch (SQLException throwables) {
            System.out.println("Error: Connection issue.");
        }
        return null;

    }
}
