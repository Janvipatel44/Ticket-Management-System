package customerAnalysis;
import customerAnalysis.Interfaces.*;
import customerAnalysis.abstractfactory.*;
import database.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PersistenceCustomer implements IPersistenceCustomer
{
    private final ICustomerAnalysisFactory customerAnalysisFactory = CustomerAnalysisFactory.instance();
    private final String configurationFile = "ConfigurationFile.txt";
    private final IConnectionManager connection = new ConnectionManager(configurationFile);

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

        try {
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
