package customerAnalysis;
import customerAnalysis.Interfaces.*;
import customerAnalysis.abstractfactory.*;
import database.*;
import database.abstractfactory.*;
import employeeMilestones.PersistenceEmployeeTickets;
import mailservice.ReadPropertiesFile;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PersistenceCustomer implements IPersistenceCustomer
{
    private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
    private final ICustomerAnalysisFactory customerAnalysisFactory = CustomerAnalysisFactory.instance();
    private String projectConfigurationFile = "ProjectConfiguration.properties";
    private String dbConfigurationKey = "DBConfiguration";
    private IConnectionManager connection;

    public PersistenceCustomer() throws IOException
    {
        Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
        String configurationFile = (String)properties.get(dbConfigurationKey);
        connection = databaseFactory.getConnectionManager(configurationFile);
    }

    public List<IParameterizedCustomerTicket> getTicketsOfCustomer(String customerID)
    {
        List<IParameterizedCustomerTicket> tickets = new ArrayList<>();
        String ticketID;
        Date startDate;
        Date endDate;
        String ticketType;
        int priority;
        int urgency;
        int impact;
        String ticketLevel;
        String creatorID;
        String employeeID;
        int rating;
        Connection dummyConnection;
        CallableStatement procedureCall;

        if(connection == null)
        {
            return null;
        }

        try
        {
            String procedureName = "getCustomerTickets";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?)}");
            procedureCall.setString(1, customerID);
            ResultSet resultSet = procedureCall.executeQuery();
            while(resultSet.next())
            {
                ticketID = resultSet.getString("ticketId");
                startDate = resultSet.getDate("startDate");
                endDate = resultSet.getDate("endDate");
                ticketType = resultSet.getString("ticketType");
                priority = resultSet.getInt("priority");
                urgency = resultSet.getInt("urgency");
                impact = resultSet.getInt("impact");
                ticketLevel = resultSet.getString("ticketLevel");
                creatorID = resultSet.getString("creatorID");
                employeeID = resultSet.getString("employeeId");
                rating = resultSet.getInt("rating");
                IParameterizedCustomerTicket ticket = customerAnalysisFactory.getParameterizedCustomerTicket(ticketID, customerID, startDate, endDate, ticketType, priority, urgency, impact, ticketLevel, creatorID, employeeID, rating);
                tickets.add(ticket);
            }
            return tickets;
        }
        catch (SQLException throwable)
        {
            return null;
        }
        finally
        {
            connection.closeConnection();
        }
    }
}