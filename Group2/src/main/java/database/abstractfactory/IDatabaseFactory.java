package database.abstractfactory;
import Tickets.ICreateTicket;
import database.*;
public interface IDatabaseFactory
{
    IConnectionManager getConnectionManager(String configurationFile);
    IDatabaseOperations getDatabaseOperations();
    ITicketOperationsDB getTicketOperationsDB(ICreateTicket createTicket);
}
