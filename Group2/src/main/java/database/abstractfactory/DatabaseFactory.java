package database.abstractfactory;
import insertTicket.Interfaces.ICreateTicket;
import database.*;
import employeeMilestones.abstractfactory.EmployeeMilestoneFactory;
import employeeMilestones.abstractfactory.IEmployeeMilestoneFactory;
import database.ConnectionManager;
import database.DatabaseOperations;
import database.IConnectionManager;
import database.IDatabaseOperations;
import database.ITicketOperationsDB;
import database.TicketOperationsDB;

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
