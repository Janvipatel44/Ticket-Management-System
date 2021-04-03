package database.abstractfactory;
import Tickets.ICreateTicket;
import database.*;
import employeeMilestones.abstractfactory.EmployeeMilestoneFactory;
import employeeMilestones.abstractfactory.IEmployeeMilestoneFactory;

public class DatabaseFactory implements IDatabaseFactory {

    private static IDatabaseFactory uniqueInstance = null;

    private DatabaseFactory()
    {

    }

    public static IDatabaseFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new DatabaseFactory();
        }
        return uniqueInstance;
    }

    public IConnectionManager getConnectionManager(String configurationFile)
    {
        return new ConnectionManager(configurationFile);
    }

    public IDatabaseOperations getDatabaseOperations()
    {
        return new DatabaseOperations();
    }

    public ITicketOperationsDB getTicketOperationsDB(ICreateTicket createTicket)
    {
        return new TicketOperationsDB(createTicket);
    }
}
