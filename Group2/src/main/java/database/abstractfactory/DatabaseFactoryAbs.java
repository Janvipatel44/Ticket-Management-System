package database.abstractfactory;
import Tickets.ICreateTicket;
import database.*;
public abstract class DatabaseFactoryAbs
{
    public abstract IConnectionManager getConnectionManager(String configurationFile);
    public abstract IDatabaseOperations getDatabaseOperations();
    public abstract ITicketOperationsDB getTicketOperationsDB(ICreateTicket createTicket);
}
