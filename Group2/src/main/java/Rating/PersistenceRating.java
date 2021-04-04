package Rating;
import database.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import Rating.interfaces.*;
import database.abstractfactory.*;
public class PersistenceRating implements IPersistenceRating
{
    private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
    private final String configurationFile = "ConfigurationFile.txt";
    private final IConnectionManager connection = databaseFactory.getConnectionManager(configurationFile);
    IDatabaseOperations databaseOperations = databaseFactory.getDatabaseOperations();

    public String getPersistenceCreatorID(String ticketID)
    {
        Connection dummyConnection=null;
        CallableStatement procedureCall;
        try {
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
        catch (SQLException throwables)
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
        catch (SQLException throwables)
        {
            return false;
        }
        finally
        {
            connection.closeConnection();
        }
    }
}