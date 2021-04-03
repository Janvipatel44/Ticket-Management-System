package database.abstractFactory;
import Tickets.ICreateTicket;
import database.*;
public class DatabaseFactoryImplementation extends DatabaseFactory
{
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
