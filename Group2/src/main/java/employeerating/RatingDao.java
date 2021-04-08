package employeerating;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import database.abstractfactory.*;
import database.intefaces.IConnectionManager;
import database.intefaces.IDatabaseOperations;
import employeerating.interfaces.*;
import mailservice.ReadPropertiesFile;

public class RatingDao implements IRatingDao
{
    private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
    private String projectConfigurationFile = "ProjectConfiguration.properties";
    private String dbConfigurationKey = "DBConfiguration";
    private IConnectionManager connection;
    IDatabaseOperations databaseOperations = databaseFactory.getDatabaseOperations();

    public RatingDao() throws IOException {
        Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
        String configurationFile = (String)properties.get(dbConfigurationKey);
        connection = databaseFactory.getConnectionManager(configurationFile);
    }

    public String getPersistenceCreatorID(String ticketID)
    {
        Connection dummyConnection=null;
        CallableStatement procedureCall;

        if(connection == null)
        {
            return null;
        }

        try
        {

            String procedureName = "checkCreator";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?,?}");
            procedureCall.setString(1, ticketID);
            procedureCall.registerOutParameter(2, Types.VARCHAR);
            if(databaseOperations.executeCommand(procedureCall))
            {
                return procedureCall.getString(2);
            }
            return null;
        }
        catch (Exception throwables)
        {
            return null;
        }
        finally
        {
            connection.closeConnection();
        }
    }

    public boolean insertRating(String ticketID, int rating)
    {
        Connection dummyConnection=null;
        CallableStatement procedureCall;
        try
        {
            String procedureName = "insertRating";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?,?}");
            procedureCall.setString(1, ticketID);
            procedureCall.setInt(2, rating);
            return databaseOperations.executeUpdateCommand(procedureCall);
        }
        catch (Exception throwables)
        {
            return false;
        }
        finally
        {
            connection.closeConnection();
        }
    }
}
