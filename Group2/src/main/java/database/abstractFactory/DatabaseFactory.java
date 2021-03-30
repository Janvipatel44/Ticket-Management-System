package database.abstractFactory;
import Tickets.ICreateTicket;
import database.*;
public abstract class DatabaseFactory
{
    public abstract IConnectionManager getConnectionManager(String configurationFile);
    public abstract IDatabaseOperations getDatabaseOperations();
    public abstract ITicketOperationsDB getTicketOperationsDB(ICreateTicket createTicket);
}
